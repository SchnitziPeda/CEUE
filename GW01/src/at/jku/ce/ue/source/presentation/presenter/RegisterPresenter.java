/**
 * 
 */
package at.jku.ce.ue.source.presentation.presenter;

import at.jku.ce.ue.source.businessLogic.SupplierService;
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
	public int registerProducer(String producerName, String password,
			String adress) {

		SupplierService supplService = new SupplierServiceImpl();
		
		return supplService.registerSupplier(producerName, password, adress);
		
	}

}
