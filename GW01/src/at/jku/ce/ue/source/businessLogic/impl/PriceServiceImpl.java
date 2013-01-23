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
		System.out.println("--entering GET_PRICE FUNCTION--");
		int price = 0;

		SupplierService supplService = new SupplierServiceImpl();
		Producer prod = supplService.getProducer(producerid);
		
		int charge = 0;

		if (prod != null) {
			Map<String, Integer> parts = prod.getParts();
			if (parts.containsKey(partid)) {
				// Aufschlag auf Preis der Subparts
				System.out.println("Current charge: "+parts.get(partid));
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
		System.out.println("size of subparts: "+subParts.size());

		// get foreign producers
		Map<String, InquiryOrderPlattformService> serviceList = Database
				.getInstance().getAllServices(false);
		System.out.println("LIST OF SERVICES: "+serviceList.size());
		
		int sum = 0;
		for (String subPart : subParts) {
			System.out.println("SUBPART: "+subPart);
			int cheapestSubPartPrice = -1;
			// Iterating through all platforms
			for (String platformName : serviceList.keySet()) {
				
				System.out.println("CURRENT Plattform: "+platformName);

				List<String> prods = serviceList.get(platformName)
						.getAllProducersForPart(subPart);

				int temp = -1;
				for (String prodOfSubPart : prods) {
					temp = serviceList.get(platformName).getPrice(customerid, prodOfSubPart, subPart, inquiryid);
					if (cheapestSubPartPrice == -1) {
						cheapestSubPartPrice = temp;
					}
					if (temp <= cheapestSubPartPrice && temp >= 0) {
						cheapestSubPartPrice = temp;
					}
					System.out.println("Platform: "+platformName+" Producer: "+prodOfSubPart+" Part: "+subPart+" cheapest price: "+cheapestSubPartPrice+" Unser Preis: "+temp);
				}
			}
			sum += cheapestSubPartPrice;
		}

		price = sum + charge;
		System.out.println("Current price: "+price);
		log.info("Current price: " + price);
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
