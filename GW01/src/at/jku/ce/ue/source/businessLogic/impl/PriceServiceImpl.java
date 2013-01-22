/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.BOMServiceUtil;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author andreaspfeifer
 * 
 */
public class PriceServiceImpl implements PriceService {

	@Override
	public int getPrice(String customerid, String producerid, String partid,
			String inquiryid) {
		// generates an inquiryid
		WriteLogServiceImpl logService = new WriteLogServiceImpl();
		logService.logInquiry(customerid, producerid, producerid, inquiryid);


		// get data of foreign plattforms
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();

		int price = 0;
		PartService partService = new PartServiceImpl();
		try {
			if (partService.getAllDirectSubpartsOfPart(partid).size() > 0) {
				for (String subPart : partService
						.getAllDirectSubpartsOfPart(partid)) {
					price += calcPrice(customerid, inquiryid, plattforms,
							price, subPart);

				}
			} else {
				price = calcPrice(customerid, inquiryid, plattforms, price,
						partid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return price;
	}

	/**
	 * @param customerid
	 * @param inquiryid
	 * @param plattforms
	 * @param price
	 * @param subPart
	 * @return
	 */
	private int calcPrice(String customerid, String inquiryid,
			Map<String, InquiryOrderPlattformService> plattforms, int price,
			String subPart) {
		int helpprice = 0;
		for (String platformName : plattforms.keySet()) {
			int innerprice = 0;
			List<String> producersForeignPlatform = plattforms
					.get(platformName).getAllProducersForPart(subPart);
			for (String prod : producersForeignPlatform) {
				innerprice = plattforms.get(platformName).getPrice(customerid,
						prod, subPart, inquiryid);
				if (innerprice < helpprice && innerprice > 0) { // bei
																// allen
																// ab
																// dem
																// zweiten
					helpprice = innerprice;
				} else if (helpprice == 0 && innerprice > 0) { // beim
																// ersten
																// durchlauf
																// dieser
																// code
					helpprice = innerprice;
				}
			}

		}
		price += helpprice;
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
