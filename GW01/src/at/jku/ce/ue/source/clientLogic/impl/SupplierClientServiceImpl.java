/**
 * 
 */
package at.jku.ce.ue.source.clientLogic.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.log.WriteLogService;
import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.OrderService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.businessLogic.impl.OrderServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.PartServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.PriceServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.clientLogic.SupplierClientService;
import at.jku.ce.ue.source.entities.Customer;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Offer;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierClientServiceImpl implements SupplierClientService {

	private static Logger log = Logger.getLogger("SupplierClientServiceImpl");

	private String inquiryId;

	@Override
	public Map<String, Producer> getAllProducers() {
		Database db = Database.getInstance();
		Map<String, Producer> storedPoducers = db.getProducers();
		List<Producer> producers = new LinkedList<Producer>();

		Map<String, InquiryOrderPlattformService> serviceList = db
				.getServices(false);

		// Iterating through all platforms
		for (String plattformName : serviceList.keySet()) {
			// Getting all producers of other platforms
			List<String> prods = serviceList.get(plattformName)
					.getAllProducersOnPlattform();

			// Iterating through all Producers of platform 'plattform'
			for (String name : prods) {
				// If not already stored in our database, store it
				if (!storedPoducers.containsKey(name)) {
					Producer prod = new Producer(name, name);
					prod.setPlattform(plattformName);
					// prod.setProducerService(producerService);
					storedPoducers.put(name, prod);
				}
			}
		}

		return storedPoducers;
	}

	@Override
	public List<String> getAllProducerNames() {
		List<String> prodNames = new LinkedList<String>();

		// get own data first:
		Map<String, Producer> producers = getAllProducers();
		List<Producer> prodList = new LinkedList(producers.values());
		for (Producer producer : prodList) {
			prodNames.add(producer.getName());
		}

		// data of foreign plattforms:
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getServices(false);

		// Iterating through all platforms
		for (String plattformName : serviceList.keySet()) {
			// Getting all producers of other platforms
			List<String> prods = serviceList.get(plattformName)
					.getAllProducersOnPlattform();

			// Iterating through all parts of platform 'plattform'
			for (String name : prods) {
				// add parts to current list
				prodNames.add(name);
			}
		}

		return prodNames;
	}

	@Override
	public List<String> getAllCustomerNames() {
		Database db = Database.getInstance();
		Map<String, Customer> customer = db.getCustomersOnPlatform();
		List<String> cNames = new LinkedList<String>();
		for (Map.Entry<String, Customer> c : customer.entrySet()) {
			cNames.add(c.getKey());
		}
		return cNames;

	}

	@Override
	public Map<String, Customer> getAllCustomers() {
		Database db = Database.getInstance();
		Map<String, Customer> customer = db.getCustomersOnPlatform();
		return customer;

	}

	@Override
	public String registerSupplier(String producerName, String password) {

		return "-1";
	}

	@Override
	public List<String> getAllProducersForPart(String partId) {

		List<String> producers = new LinkedList<String>();

		// get own producers
		SupplierServiceImpl supService = new SupplierServiceImpl();
		for (Producer prod : supService.getAllProducers().values()) {

			Map<String, Integer> partsOfProd = prod.getParts();
			if (partsOfProd.containsKey(partId)) {
				producers.add(prod.getName());
			}
		}

		// get foreign producers
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getServices(false);

		// Iterating through all platforms
		for (String plattformName : serviceList.keySet()) {
			// Getting all parts of other platforms
			List<String> prods = serviceList.get(plattformName)
					.getAllProducersForPart(partId);

			// Iterating through all parts of platform 'plattform'
			for (String name : prods) {
				// add parts to current list
				producers.add(name);
			}
		}

		if (producers.size() == 0)
			log.info("No Producers for part " + partId + " on platform GW01!");

		return producers;
	}

	@Override
	public List<String> getAllPartNames() {
		Database db = Database.getInstance();
		return new LinkedList<String>(db.getPartHierarchy().keySet());
	}

	@Override
	public List<Offer> getOffersForPart(String partName, String customerId) {
		List<Offer> listOfOffers = new LinkedList<Offer>();

		String inquiryId = Database.getInstance().generateInquiryId();

		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getAllServices(false);

		SupplierClientService supClientService = new SupplierClientServiceImpl();
		List<String> prodList = supClientService
				.getAllProducersForPart(partName);

		for (String platformName : serviceList.keySet()) {

			List<String> prodsOnPlatform = serviceList.get(platformName)
					.getAllProducersOnPlattform();

			for (String prod : prodList) {

				if (prodsOnPlatform.contains(prod)) {

					log.info("PRODUCER: " + prod + " PlATTFORM: "
							+ platformName);
					int price;
					if (platformName.contains("gruppe 1 publisher")) {
						PriceService priceService = new PriceServiceImpl();
						price = priceService.getPrice(customerId, prod,
								partName, inquiryId);
					} else {
						price = serviceList.get(platformName).getPrice(
								customerId, prod, partName, inquiryId);
					}

					String offerID = Database.getInstance().generateOfferId();
					Offer offer = new Offer(offerID, partName, prod,
							customerId, inquiryId, price, platformName);
					log.info(offer.toString());
					listOfOffers.add(offer);

					// LOGGING
					WriteLogService logService = new WriteLogServiceImpl();
					logService.logOffer(customerId, prod, partName, price,
							inquiryId, offerID);
				}

			}

		}

		return listOfOffers;
	}

	@Override
	public List<String> getAllPartsByProducer(String producerId) {
		List<String> allPartsByProducer = new LinkedList<String>();

		// get own data first
		PartServiceImpl partService = new PartServiceImpl();
		allPartsByProducer = partService.getAllPartsByProducer(producerId);

		// get foreign data:
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getServices(false);

		// iterate through:
		for (String platformName : serviceList.keySet()) {
			List<String> parts = serviceList.get(platformName)
					.getAllPartsByProducer(producerId);
			for (String pr : parts) {
				allPartsByProducer.add(pr);
			}
		}

		return allPartsByProducer;
	}

	@Override
	public void saveOrders(String customerId, String partId,
			List<Offer> selectedOfferList) throws Exception {
		Database db = Database.getInstance();
		Map<String, InquiryOrderPlattformService> serviceList = db
				.getAllServices(true);
		for (String s : serviceList.keySet()) {
			System.out.println(s);
		}
		for (Offer o : selectedOfferList) {
			String orderid = db.generateOrderId();

			System.out.println(o.getPlatformName());
			if (o.getPlatformName().contains("gruppe 1 publisher")) {
				OrderService orderService = new OrderServiceImpl();
				orderService.placeOrder(o.getCustomerOfOffer(),
						o.getSupplierOfOffer(), o.getPartName(),
						o.getInquiryOfOffer(), o.getPrice(), orderid);
			} else {
				InquiryOrderPlattformService concerningPlatform = serviceList
						.get(o.getPlatformName());
				concerningPlatform.placeOrder(o.getCustomerOfOffer(),
						o.getSupplierOfOffer(), o.getPartName(),
						o.getInquiryOfOffer(), o.getPrice(), orderid);
			}
//			System.out.println(concerningPlatform.toString());
			// OrderService os = new OrderServiceImpl();
		}
	}

	@Override
	public List<String> getDirectSubPartsOf(String partId) {
		// TODO Auto-generated method stub
		return null;
	}
}
