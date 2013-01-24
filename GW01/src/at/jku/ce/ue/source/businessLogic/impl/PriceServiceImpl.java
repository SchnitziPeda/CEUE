/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.log.WriteLogService;
import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.entities.Database;
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
		
		int producerPrice = 0;

		if (prod != null) {
			Map<String, Integer> parts = prod.getParts();
			if (parts.containsKey(partid)) {
				// Aufschlag auf Preis der Subparts
				producerPrice = parts.get(partid);
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
		
		int sum = 0;
		for (String subPart : subParts) {
			int cheapestSubPartPrice = -1;
			// Iterating through all platforms
			for (String platformName : serviceList.keySet()) {
				

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
//					System.out.println("Platform: "+platformName+" Producer: "+prodOfSubPart+" Part: "+subPart+" cheapest price: "+cheapestSubPartPrice+" Unser Preis: "+temp);
				}
			}
			sum += cheapestSubPartPrice;
		}

		price = sum + producerPrice;
		log.info("Current price: " + price);
		
		// LOGGING
		WriteLogService logService = new WriteLogServiceImpl();
		logService.logOffer(customerid, producerid, partid, price, inquiryid, Database.getInstance().generateOfferId());

		return price;
	}


}
