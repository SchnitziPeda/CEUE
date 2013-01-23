/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.Map;

import at.jku.ce.ue.source.entities.Customer;

/**
 * @author andreaspfeifer
 *
 */
public interface CustomerService {
	
	public String addCustomer(String customerName);

	public Map<String, Customer> getCustomers();
}
