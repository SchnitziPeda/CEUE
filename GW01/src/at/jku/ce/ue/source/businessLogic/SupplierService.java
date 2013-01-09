/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;

import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 *
 */
public interface SupplierService {

	public List<String> getAllPartsByProducer(String producerid);
	
	public Producer getProducer(String producerID);
	
	
}
