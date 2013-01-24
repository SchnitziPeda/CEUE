package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.log.WriteLogServiceImpl;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.OrderService;
import at.jku.ce.ue.source.clientLogic.SupplierClientService;
import at.jku.ce.ue.source.clientLogic.impl.SupplierClientServiceImpl;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Offer;

public class OrderServiceImpl implements OrderService {

	private static Logger log = Logger.getLogger("OrderServiceImpl");

	@Override
	public void placeOrder(String customerid, String producerid, String partid,
			String inquiryid, int price, String orderid) throws Exception {
		Database db = Database.getInstance();
		Map<String, List<String>> partsOnPlatform = db.getPartHierarchy();
		SupplierClientService clientService = new SupplierClientServiceImpl();
		Map<String, InquiryOrderPlattformService> serviceList = db
				.getAllServices(false);

		List<String> subParts = partsOnPlatform.get(partid);
		if (subParts.size() > 0) {
			for (String subPart : subParts) {

				List<Offer> offersForSubPart = clientService.getOffersForPart(
						subPart, producerid);

				int cheapestPrice = 0;
				Offer cheapestOffer = null;

				for (Offer o : offersForSubPart) {
					if (cheapestPrice > o.getPrice() || cheapestOffer == null) {
						cheapestPrice = o.getPrice();
						cheapestOffer = o;
					}
				}
				// log.info(cheapestOffer.toString());

				String cheapestOrderId = db.generateOrderId();
				InquiryOrderPlattformService cheapestPlatform = serviceList
						.get(cheapestOffer.getPlatformName());
				cheapestPlatform.placeOrder(cheapestOffer.getCustomerOfOffer(),
						cheapestOffer.getSupplierOfOffer(),
						cheapestOffer.getPartName(),
						cheapestOffer.getInquiryOfOffer(),
						cheapestOffer.getPrice(), cheapestOrderId);
			}
		}
		WriteLogServiceImpl logService = new WriteLogServiceImpl();
		logService.logOrder(customerid, producerid, partid, price, inquiryid,
				orderid, "OfferToGW01");

		// Order accepted
		log.info("Order successfully completed on GW01! Thanks for your purchase!");
	}
}
