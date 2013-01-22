/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.clientLogic.SupplierClientService;
import at.jku.ce.ue.source.clientLogic.impl.SupplierClientServiceImpl;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Offer;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author andreaspfeifer
 * 
 */
public class PriceServiceImpl implements PriceService {

	private static Logger log = Logger.getLogger("PriceServiceImpl");

	public List<Offer> getSupplyChains(String customerid, String partid,
			String inquiryid) {

		// Map<String, Integer> priceChains = new HashMap<String, Integer>();
		List<Offer> offersList = new LinkedList<Offer>();

		// get data of foreign plattforms
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getServices(false);

		log.info("Platforms generated!");

		int price = 0;

		PartService partService = new PartServiceImpl();

		try {

			SupplierClientService supplService = new SupplierClientServiceImpl();
			List<String> suppliers = supplService
					.getAllProducersForPart(partid);

			for (String supplier : suppliers) {
				// Look if there are subparts of part with partid
				if (partService.getAllDirectSubpartsOfPart(partid).size() > 0) {
					int cheapestPrice = 0;
					String cheapestProducer = null;
					// iterate through all direct subParts
					for (String subPart : partService
							.getAllDirectSubpartsOfPart(partid)) {

						cheapestPrice = 0;
						Offer cheapestOfferForSubPart = null;

						// iterate through all platforms
						List<String> suppliersOfSubPart = supplService
								.getAllProducersForPart(subPart);
						
							// inner price of each platform
							int innerPlatformProducerPrice = 0;

							// Iterate through all producers of subpart
							for (String prod : suppliersOfSubPart) {

								// Calculates price for every subPart of every
								// producer of part
								// priceForPart = calcPrice(customerid,
								// inquiryid,
								// serviceList, prod, price, helpprice,
								// innerprice,
								// subPart);

								// generates an inquiryid
								WriteLogServiceImpl logService = new WriteLogServiceImpl();
								logService.logInquiry(customerid, prod, partid,
										inquiryid);

								innerPlatformProducerPrice = serviceList.get(
										platformNameSubParts).getPrice(
										customerid, prod, subPart, inquiryid);

								String offerId = Database.getInstance()
										.generateOfferId();
								logService.logOffer(customerid, prod, partid,
										innerPlatformProducerPrice, inquiryid,
										offerId);

								log.info("InnerPrice for " + subPart
										+ " after call getPrice: "
										+ innerPlatformProducerPrice);
								if (innerPlatformProducerPrice < cheapestPrice
										&& innerPlatformProducerPrice > 0) {
									log.info(innerPlatformProducerPrice + "<"
											+ cheapestPrice + " &&"
											+ innerPlatformProducerPrice
											+ "> 0");
									// bei allen ab dem zweiten
									cheapestPrice = innerPlatformProducerPrice;
									cheapestProducer = prod;
									offerId = Database.getInstance()
											.generateOfferId();
									cheapestOfferForSubPart = new Offer(
											offerId, subPart, prod, customerid,
											inquiryid,
											innerPlatformProducerPrice);
									logService.logOffer(customerid, prod,
											partid, innerPlatformProducerPrice,
											inquiryid, offerId);
								} else if (cheapestPrice == 0
										&& innerPlatformProducerPrice > 0) {
									log.info(innerPlatformProducerPrice
											+ "== 0 && "
											+ innerPlatformProducerPrice
											+ "> 0");
									// bei ersten durchlauf dieser code
									cheapestPrice = innerPlatformProducerPrice;
									cheapestProducer = prod;
									offerId = Database.getInstance()
											.generateOfferId();
									cheapestOfferForSubPart = new Offer(
											offerId, subPart, prod, customerid,
											inquiryid,
											innerPlatformProducerPrice);
									logService.logOffer(customerid, prod,
											partid, innerPlatformProducerPrice,
											inquiryid, offerId);
								}

							}
							
						log.severe("PRICECALC: " + customerid + " "
								+ serviceList + " " + price + " " + subPart
								+ " " + cheapestPrice);

						// Storing the cheapest producer and its price for part
						offersList.add(cheapestOfferForSubPart);
					}
					int sumPrices = 0;
					for (Offer off : offersList) {
						sumPrices += off.getPrice();
					}
					String offerId = Database.getInstance().generateOfferId();
					Offer offerWholePart = new Offer(offerId, partid, prod,
							customerid, inquiryid, sumPrices);

				} else {
					// No subparts existing
					// log.severe("NoSubParts PRICECALC: " + customerid + " "
					// + serviceList + " " + price + " " + partid + " "
					// + price);
					//
					// for (String platformName : serviceList.keySet()) {
					//
					// // Get producers of all foreign platforms for every
					// subPart
					// List<String> allProducers = serviceList.get(platformName)
					// .getAllProducersForPart(partid);
					//
					// // Get producers of all own platforms for every subPart
					// SupplierService supplService = new SupplierServiceImpl();
					// List<String> ownProducers = supplService
					// .getAllProducersForPart(partid);
					//
					// // join all producers of all platforms
					// allProducers.addAll(ownProducers);
					//
					// for (String prod : allProducers) {
					// price = serviceList.get(platformName).getPrice(
					// customerid, prod, partid, inquiryid);
					// priceChains.put(prod, price);
					// }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logService.logOffer(customerid, producerid, partid, price, inquiryid,
		// Database.getInstance().generateOfferId());
		return offersList;
	}

	@Override
	public int getPrice(String customerid, String partid, String inquiryid) {

		//
		// // Get producers of all own platforms for every subPart
		// SupplierService supplService = new SupplierServiceImpl();
		// List<String> ownProducers = supplService
		// .getAllProducersForPart(partid);
		//
		//
		// for (String prod : allProducers) {
		// price = serviceList.get(platformName).getPrice(
		// customerid, prod, partid, inquiryid);
		// priceChains.put(prod, price);
		// }
		//
		return 666;
	}

	/**
	 * @param priceChains
	 * @param customerid
	 * @param inquiryid
	 * @param serviceList
	 * @param plattforms
	 * @param price
	 * @param subPart
	 * @return
	 */
	private int calcPrice(String customerid, String inquiryid,
			Map<String, InquiryOrderPlattformService> serviceList, String prod,
			int price, int helpprice, int innerprice, String subPart) {

		return price;
	}

	/**
	 * @param priceChains
	 * @param customerid
	 * @param inquiryid
	 * @param plattforms
	 * @param price
	 * @param subPart
	 * @return
	 */
	private int calcPriceNoSubparts(Map<String, Integer> priceChains,
			String customerid, String inquiryid,
			Map<String, InquiryOrderPlattformService> plattforms, int price,
			String subPart) {

		for (String platformName : plattforms.keySet()) {

			List<String> producersForeignPlatform = plattforms
					.get(platformName).getAllProducersForPart(subPart);

			for (String prod : producersForeignPlatform) {

				price = plattforms.get(platformName).getPrice(customerid, prod,
						subPart, inquiryid);
				priceChains.put(prod, price);

			}

		}
		return price;
	}

	public Map<String, Integer> getPriceForProducers(List<String> producer,
			String partid) {
		Map<String, Integer> prices = new HashMap<String, Integer>();

		/*
		 * TODO price logic for calculating end prices should go here
		 */

		Database db = Database.getInstance();
		Map<String, Producer> producerFromDatabase = db.getProducers();

		for (Producer prod : producerFromDatabase.values()) {

			Map<String, Integer> partsOfProd = prod.getParts();

			if (partsOfProd.containsKey(partid)) {
				prices.put(prod.getName(), partsOfProd.get(partid));
			}

		}

		return prices;

		// for(Producer prod : producerFromDatabase.values()){
		// for(String pd : producer){
		// // check if given producer matches with database
		// if(prod.getName().equals(pd)){
		// // check, if producer has the given product
		// // for(String part : prod.getParts()){
		// // if(part.getName().equals(partid)){
		// // // if equal, add to list
		// // prices.put(prod.getName(), part.getPrice());
		// // }
		// // }
		//
		// List<String> partNames = prod.getPartNames();
		//
		// if(partNames.contains(partid)){
		// prices.put(partid, part);
		// }
		//
		// }
		// }
		// }

	}

	@Override
	public void getClientPrice() {
		// TODO Auto-generated method stub
		
	}

}
