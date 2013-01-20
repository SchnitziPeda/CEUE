/**
 * 
 */
package at.jku.ce.ue.source.presentation.presenter;

import java.util.List;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;
import at.jku.ce.ue.source.presentation.view.AddProductView;

/**
 * @author Patrick
 * 
 */
public class AddProductPresenter implements AddProductView {
	
	private List<Part> partsList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.jku.ce.ue.source.presentation.view.AddProductView#addProducttoProducer
	 * (java.lang.String, java.util.List)
	 */
	@Override
	public boolean addProductToProducer(Producer producer, Part part) {
		SupplierService supplService = new SupplierServiceImpl();

		return supplService.addPartToProducer(producer, part);
	}

	/**
	 * @return the partsList
	 */
	public List<Part> getPartsList() {
		return partsList;
	}

	/**
	 * @param partsList the partsList to set
	 */
	public void setPartsList(List<Part> partsList) {
		this.partsList = partsList;
	}
}
