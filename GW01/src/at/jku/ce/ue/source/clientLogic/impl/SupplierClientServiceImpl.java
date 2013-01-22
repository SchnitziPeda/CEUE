/**
 * 
 */
package at.jku.ce.ue.source.clientLogic.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.PartServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.PriceServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.clientLogic.SupplierClientService;
import at.jku.ce.ue.source.entities.Customer;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierClientServiceImpl implements SupplierClientService {

	private String inquiryId;

	@Override
	public Map<String, Producer> getAllProducers() {

		Database db = Database.getInstance();
		Map<String, Producer> storedPoducers = db.getProducers();
		List<Producer> producers = new LinkedList<Producer>();

		// Managing UDDI Stuff
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();

		// Iterating through all platforms
		for (String plattformName : plattforms.keySet()) {
			// Getting all producers of other platforms
			List<String> prods = plattforms.get(plattformName)
					.getAllProducersOnPlattform();

			// Iterating through all Producers of platform 'plattform'
			for (String name : prods) {
				// If not already stored in our database, store it
				if (!storedPoducers.containsKey(name)) {
					Producer prod = new Producer(name, name);
					prod.setPlattform(plattformName);
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
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();
		// Iterating through all platforms
		for (String plattformName : plattforms.keySet()) {
			// Getting all producers of other platforms
			List<String> prods = plattforms.get(plattformName)
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
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();
		// Iterating through all platforms
		for (String plattformName : plattforms.keySet()) {
			// Getting all parts of other platforms
			List<String> prods = plattforms.get(plattformName)
					.getAllProducersForPart(partId);

			// Iterating through all parts of platform 'plattform'
			for (String name : prods) {
				// add parts to current list
				producers.add(name);
			}
		}

		return producers;
	}

	@Override
	public List<String> getAllPartNames() {
		Database db = Database.getInstance();
		List<String> storedParts = new LinkedList<String>();
		Map<String, Part> ownParts = db.getPartsOnPlattform();

		// adding own parts to list
		for (String key : ownParts.keySet()) {
			Part partname = ownParts.get(key);
			storedParts.add(partname.getName());
		}

		// // adding foreign parts to list
		// // Managing UDDI Stuff
		// UddiInteraction uddi = new UddiInteraction();
		// Map<String, InquiryOrderPlattformService> plattforms =
		// uddi.generateListofEndpoints();
		//
		// // Iterating through all platforms
		// for (String plattformName : plattforms.keySet()) {
		// // Getting all parts of other platforms
		// List<String> parts =
		// plattforms.get(plattformName).getAllPartsOnPlattform();
		//
		// // Iterating through all parts of platform 'plattform'
		// for (String name : parts) {
		// // add parts to current list
		// storedParts.add(name);
		// }
		// }

		return storedParts;

	}

	@Override
	public List<String> getDirectSubPartsOf(String partId) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public Map<String, Integer> getOffersForPart(String partName,
			String customerId) {
		Map<String, Integer> priceChains = new HashMap<String, Integer>();

		PartService partService = new PartServiceImpl();
		partService.getAllParts();
		String inquiryId = Database.getInstance().generateInquiryId();

		List<String> producersForGivenPart = this.getAllProducersForPart(partName);
		
		for(String prod : producersForGivenPart){
			// get price of producers:
			PriceService priceService = new PriceServiceImpl();
			priceChains.put(prod, priceService.getPrice(customerId, prod, partName, inquiryId));	
		}
		
		// System.out.println(supplyChains.size());

//		// get data of foreign plattforms
//		UddiInteraction uddi = new UddiInteraction();
//		Map<String, InquiryOrderPlattformService> plattforms = uddi
//				.generateListofEndpoints();
//
//		// iterate through all plattforms:
//		for (String platformName : plattforms.keySet()) {
//			// Getting all producers for parts of foreign plattforms
//			List<String> producerForeignPlatform = plattforms.get(platformName)
//					.getAllProducersForPart(partName);
//			for (String prod : producerForeignPlatform) {
//				// get prices for given product of foreign platform;
//				int price = plattforms.get(platformName).getPrice(customerId,
//						prod, partName, inquiryId);
//				if (price >= 0) {
//					// add price and producer to list
//					supplyChains.put(prod, price);
//				}
//			}
//		}

		return priceChains;
	}

	@Override
	public List<String> getAllPartsByProducer(String producerId) {
		List<String> allPartsByProducer = new LinkedList<String>();

		// get own data first
		PartServiceImpl partService = new PartServiceImpl();
		allPartsByProducer = partService.getAllPartsByProducer(producerId);

		// get foreign data:
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();
		// iterate through:
		for (String platformName : plattforms.keySet()) {
			List<String> parts = plattforms.get(platformName)
					.getAllPartsByProducer(producerId);
			for (String pr : parts) {
				allPartsByProducer.add(pr);
			}
		}

		return allPartsByProducer;
	}


	@Override
	public void saveOrders(String customerId, String partId, String[] orders,
			String[] producers, String[] prices) {
		Database db = Database.getInstance();

		// assemble data for orders to be saved
		for (int i = 0; i < orders.length; i++) {
			int pos = orders[i].indexOf("#");
			String numberOfOrder = orders[i].substring(pos + 1);
			// System.out.println(orders[i]+numberOfOrder);

			for (int j = 0; j < producers.length; j++) {
				int p = producers[j].indexOf("#");
				String number = producers[j].substring(p + 1);
				// System.out.println(producers[j]+number);

				if (numberOfOrder.equals(number)) {
					for (int k = 0; k < prices.length; k++) {
						int po = prices[k].indexOf("#");
						String numb = prices[k].substring(po + 1);

						if (number.equals(numb)) {
							int price = Integer.parseInt(prices[k].substring(0,
									po));
							String producerName = producers[j].substring(0, p);
							String order = orders[i].substring(0, pos);

							System.out.println("Order: " + order
									+ " Producer: " + producerName + " Price: "
									+ price);
							
							// TODO: what do we have to save?
							db.saveOrder(order, producerName, price);
							
							// TODO: 
							// call placeOrder() of provided web services;
							// if subparts exists -> log them as well 

							WriteLogServiceImpl logService = new WriteLogServiceImpl();
							logService.logOrder(customerId, producerName,
									partId, price, db.generateInquiryId(), db.generateOfferId(), db.generateOrderId());
						}
					}

				}

			}
		}

	}

}
