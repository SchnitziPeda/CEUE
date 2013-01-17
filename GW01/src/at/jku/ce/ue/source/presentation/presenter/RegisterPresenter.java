/**
 * 
 */
package at.jku.ce.ue.source.presentation.presenter;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.CustomerServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.presentation.view.RegisterView;

/**
 * @author Schnitzi
 *
 */
public class RegisterPresenter implements RegisterView {

	/* (non-Javadoc)
	 * @see at.jku.ce.ue.source.presentation.view.RegisterView#registerProducer(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String registerProducer(String producerName, String password) {

		SupplierService supplService = new SupplierServiceImpl();
		
		return supplService.registerSupplier(producerName, password);
		
	}

	@Override
	public String registerCustomer(String customerName) {		
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		System.out.println(""+customerName);
		return customerService.addCustomer(customerName);
	}

}
