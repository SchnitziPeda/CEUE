package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.OrderService;
import at.jku.ce.ue.source.entities.Database;

public class OrderServiceImpl implements OrderService {

	@Override
	public void placeOrder(String customerid, String producerid,
			String partid, String inquiryid, int price, String orderid) {
		
		
		// TODO
		// Call other plattforms and place orders

		
		// call other plattforms
		Map<String, InquiryOrderPlattformService> serviceList = Database.getInstance().getServices(false);
		
		// iterate through:
		for (String platformName : serviceList.keySet()) {
			serviceList.get(platformName).placeOrder(customerid, producerid, partid, inquiryid, price, orderid);
		}
		
	}

}
