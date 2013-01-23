/**
 * 
 */
package at.jku.ce.ue.source.presentation.presenter;

import java.util.List;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.entities.Producer;
import at.jku.ce.ue.source.presentation.view.AddProductView;

/**
 * @author Patrick
 * 
 */
public class AddProductPresenter implements AddProductView {
	
	private List<String> partsList;

	/**
	 * @return the partsList
	 */
	public List<String> getPartsList() {
		return partsList;
	}

	/**
	 * @param partsList the partsList to set
	 */
	public void setPartsList(List<String> partsList) {
		this.partsList = partsList;
	}
}
