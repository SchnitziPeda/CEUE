/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Offer;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author andreaspfeifer
 * 
 */
public class PriceServiceImpl implements PriceService {

	private static Logger log = Logger.getLogger("PriceServiceImpl");

	@Override
	public int getPrice(String customerid, String producerid, String partid,
			String inquiryid) {
		int price = 0;

		SupplierService supplService = new SupplierServiceImpl();
		Producer prod = supplService.getProducer(producerid);
		
		int charge = 0;

		if (prod != null) {
			Map<String, Integer> parts = prod.getParts();

			if (parts.containsKey(partid)) {
				// Aufschlag auf Preis der Subparts
				charge = parts.get(partid);
			} else {
				log.severe("Producer " + producerid
						+ " does not produce Part "+partid+" on Platform of group GW01!");
			}
		} else {
			log.severe("Producer " + producerid
					+ " does not exist on Platform of group GW01!");
		}

		PartService partService = new PartServiceImpl();
		List<String> subParts = partService.getAllDirectSubpartsOfPart(partid);

		// get foreign producers
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getAllServices(false);
		int sum = 0;
		for (String subPart : subParts) {
			int cheapestSubPartPrice = -1;
			// Iterating through all platforms
			for (String platformName : serviceList.keySet()) {

				List<String> prods = serviceList.get(platformName)
						.getAllProducersForPart(subPart);

				int temp = -1;
				for (String prodOfSubPart : prods) {
					temp = serviceList.get(platformName).getPrice(customerid,
							prodOfSubPart, partid, inquiryid);
					if (cheapestSubPartPrice == -1) {
						cheapestSubPartPrice = temp;
					}
					if (temp <= cheapestSubPartPrice && temp >= 0) {
						cheapestSubPartPrice = temp;
					}
				}
			}
			sum += cheapestSubPartPrice;
		}
		price = sum + charge;
		log.info("Current price: " + price);
		return price;
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

}
