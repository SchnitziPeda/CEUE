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

		Database db = Database.getInstance();

		Map<String, List<String>> partsOnPlatform = db.getPartHierarchy();
		Map<String, InquiryOrderPlattformService> services = db
				.getAllServices(false);

		// producer exists on platform?
		if (db.getProducer(producerid) != null) {

			List<String> subParts = partsOnPlatform.get(partid);

			// has subParts?
			if (subParts.size() > 0) {

				// Iterate all subparts
				for (String subPart : subParts) {

					// all Services
					for (InquiryOrderPlattformService inqService : services
							.values()) {

						List<String> prodsOnPlatform = inqService
								.getAllProducersForPart(subPart);

						// has producer?
						if (prodsOnPlatform.contains(producerid)) {

							log.info("GW01 places Order: " + orderid + " "
									+ customerid + " " + producerid + " "
									+ subPart + " " + inquiryid + " " + price
									+ " " + orderid);

							// place order for subPart
							inqService.placeOrder(customerid, producerid,
									subPart, inquiryid, price, orderid);

						}
					}
				}
			}

			// Order accepted
			log.info("Order accepted on GW01! Thanks for your purchase :)");
			
			WriteLogServiceImpl logService = new WriteLogServiceImpl();
			logService.logOrder(customerid, producerid, partid, price, inquiryid, orderid, "OfferToGW01");
			
		} else {
			log.severe("Order for part '" + partid + "' of producer '"
					+ producerid
					+ "' on platform GW01 not successful! Producer "
					+ producerid + " not on platform GW01.");
		}
		// // All parts offered on platform
		// if (partsOnPlatform.containsKey(partid)) {
		//
		// List<String> subParts = partsOnPlatform.get(partid);
		//
		// // has subParts?
		// if (subParts.size() > 0) {
		//
		// // Iterate all subparts
		// for (String subPart : subParts) {
		//
		// // all Services
		// for (InquiryOrderPlattformService inqService : services
		// .values()) {
		//
		// List<String> prodsOnPlatform =
		// inqService.getAllProducersForPart(subPart);
		//
		// // has producer?
		// if (prodsOnPlatform.contains(producerid)) {
		//
		// log.info("GW01 places Order: " + orderid + " "
		// + customerid + " " + producerid + " "
		// + subPart + " " + inquiryid + " " + price
		// + " " + orderid);
		//
		// // place order for subPart
		// inqService.placeOrder(customerid, producerid,
		// subPart, inquiryid, price, orderid);
		//
		// }
		// }
		// }
		// }
		//
		// // Order accepted
		// System.out
		// .println("Order accepted on GW01! Thanks for your purchase :)");
		//
		// } else {
		// log.severe("Order for part '"
		// + partid
		// + "' of producer '"
		// + producerid
		// + "' on platform GW01 not successful! Part not on platform GW01.");
		// }

		// Map<String, InquiryOrderPlattformService> partformsList = db
		// .getAllServices(false);
		// // TODO
		// // Call other plattforms and place orders
		// Map<String, InquiryOrderPlattformService> services = Database
		// .getInstance().getServices(false);
		//
		// // for(InquiryOrderPlattformService service : serv)
		//
		// // call other plattforms
		// Map<String, InquiryOrderPlattformService> serviceList = Database
		// .getInstance().getServices(false);
		//
		// // iterate through:
		// for (String platformName : serviceList.keySet()) {
		// serviceList.get(platformName).placeOrder(customerid, producerid,
		// partid, inquiryid, price, orderid);
		// }

	}

}
