/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 *
 */
public class SupplierServiceImpl implements SupplierService {

	/* (non-Javadoc)
	 * @see at.jku.ce.ue.source.businessLogic.SupplierService#getAllPartsByProducer(java.lang.String)
	 */
	@Override
	public List<String> getAllPartsByProducer(String producerid) {
		
		Producer producer = getProducer(producerid);
		
		return null;
	}

	@Override
	public Producer getProducer(String producerID) {

		
		
		return null;
	}

}
