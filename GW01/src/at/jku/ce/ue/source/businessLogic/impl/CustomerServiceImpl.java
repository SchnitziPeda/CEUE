/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.source.businessLogic.CustomerService;
import at.jku.ce.ue.source.entities.Customer;
import at.jku.ce.ue.source.entities.Database;

/**
 * @author andreaspfeifer
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger log = Logger.getLogger("CustomerServiceImpl");



	/* (non-Javadoc)
	 * @see at.jku.ce.ue.source.businessLogic.CustomerService#addCustomer(java.lang.String)
	 */
	@Override
	public String addCustomer(String customerName) {
		
		String customerId = "-1";
		
		Database db = Database.getInstance();
		if(customerName != null && customerName != ""){
			customerId = db.registerCustomer(customerName);
		} else {
			log.info("Name of customer is empty");
		}
		
		return customerId;
	}
	

}
