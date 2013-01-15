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
	 * Gets a producer by the producerIDof our platform
	 * 
	 * @param producerID
	 * @return
	 */
	public Producer getProducer(int producerID);

	/**
	 * Gets all producers of our platform
	 * 
	 * @return
	 */
	public List<Producer> getAllProducers();

	/**
	 * @return
	 */
	public List<String> getAllProducerKeys();
	
	
}
