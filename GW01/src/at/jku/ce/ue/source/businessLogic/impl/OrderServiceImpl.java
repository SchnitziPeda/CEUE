package at.jku.ce.ue.source.businessLogic.impl;

import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.businessLogic.OrderService;
import at.jku.ce.ue.source.entities.Database;

public class OrderServiceImpl implements OrderService {

	@Override
	public void placeOrder(String customerid, String producerid,
			String partid, String inquiryid, int price, String orderid) {
		
		System.out.println("Order accepted on GW01! Thanks for your purchase :)");
		// TODO
		// Call other plattforms and place orders
		Map<String, InquiryOrderPlattformService> services = Database.getInstance().getServices(false);
		
//		for(InquiryOrderPlattformService service : serv)
		
		// call other plattforms
		Map<String, InquiryOrderPlattformService> serviceList = Database.getInstance().getServices(false);
		
		// iterate through:
		for (String platformName : serviceList.keySet()) {
			serviceList.get(platformName).placeOrder(customerid, producerid, partid, inquiryid, price, orderid);
		}
		
	}

}
