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

	/**
	 * 
	 * 
	 * @param producerID
	 * @return
	 */
	public Producer getProducer(int producerID);
	
	public List<Producer> getAllProducers();

}
