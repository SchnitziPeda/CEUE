package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.OrderService;
import at.jku.ce.ue.source.businessLogic.WriteLogService;
import at.jku.ce.ue.source.entities.Database;

public class OrderServiceImpl implements OrderService {

	private static Logger log = Logger.getLogger("OrderServiceImpl");

	@Override
	public void placeOrder(String customerid, String producerid, String partid,
			String inquiryid, int price, String orderid) {

		//
		// Map<String, InquiryOrderPlattformService> services = db
		// .getAllServices(false);
		//
		// // all Services
		// for (String platform : services.keySet()) {
		//
		// List<String> producersOnPlatform = services.get(platform)
		// .getAllProducersForPart(partid);
		//
		// // producer exists on platform?
		// if (producersOnPlatform.contains(producerid)) {
		//
		// // place order for subPart
		// services.get(platform).placeOrder(customerid, producerid, partid,
		// inquiryid,
		// price, orderid);
		//
		// // Order accepted
		// log.info("Order accepted on GW01! Thanks for your purchase :)");
		//
		// WriteLogServiceImpl logService = new WriteLogServiceImpl();
		// logService.logOrder(customerid, producerid, partid, price,
		// inquiryid, orderid, "OfferToGW01");
		//
		// } else {
		// log.severe("Order for part '" + partid + "' of producer '"
		// + producerid
		// + "' on platform GW01 not successful! Producer "
		// + producerid + " not on platform GW01.");
		// }
		// }

		Database db = Database.getInstance();
		Map<String, List<String>> partsOnPlatform = db.getPartHierarchy();

		Map<String, InquiryOrderPlattformService> services = db
				.getAllServices(false);
		
		int charge = 0;

		// All parts offered on platform
		if (partsOnPlatform.containsKey(partid)) {

			List<String> subParts = partsOnPlatform.get(partid);

			// has subParts?
			if (subParts.size() > 0) {
				
				int sum = 0;
				for (String subPart : subParts) {
					System.out.println("SUBPART: "+subPart);
					int cheapestSubPartPrice = -1;
					// Iterating through all platforms
					for (String platformName : services.keySet()) {
						
						System.out.println("CURRENT Plattform: "+platformName);

						List<String> prods = services.get(platformName)
								.getAllProducersForPart(subPart);

						int temp = -1;
						for (String prodOfSubPart : prods) {
							temp = services.get(platformName).getPrice(customerid, prodOfSubPart, subPart, inquiryid);
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
				
				
				}
			}

			// Order accepted
			System.out
					.println("Order accepted on GW01! Thanks for your purchase :)");

			WriteLogServiceImpl logService = new WriteLogServiceImpl();
			logService.logOrder(customerid, producerid, partid, price, inquiryid, orderid, "OfferToGW01");
		} else {
			log.severe("Order for part '"
					+ partid
					+ "' of producer '"
					+ producerid
					+ "' on platform GW01 not successful! Part not on platform GW01.");
		}

	}
}

//				// Iterate all subparts
//				for (String subPart : subParts) {
//
//					// all Services
//					for (InquiryOrderPlattformService inqService : services
//							.values()) {
//
//						List<String> prodsOnPlatform = inqService
//								.getAllProducersForPart(subPart);
//						
//						// has producer?
//						if (prodsOnPlatform.contains(producerid)) {
//
//							log.info("GW01 places Order: " + orderid + " "
//									+ customerid + " " + producerid + " "
//									+ subPart + " " + inquiryid + " " + price
//									+ " " + orderid);
//
//							// place order for subPart
//							inqService.placeOrder(customerid, producerid,
//									subPart, inquiryid, price, orderid);
//
//						}
//					}