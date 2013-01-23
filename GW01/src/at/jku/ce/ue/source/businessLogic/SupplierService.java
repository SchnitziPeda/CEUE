/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;
import java.util.Map;

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
	public Producer getProducer(String producerID);

	/**
	 * Gets all producers of our platform
	 * 
	 * @return
	 */
	public Map<String, Producer> getAllProducers();

	/**
	 * Returns names of all Producers on our Platform
	 * 
	 * @return
	 */
	public List<String> getAllProducerNames();

	/**
	 * Registers a producer
	 * 
	 * Returns -1 if error occurred
	 * 
	 * @return producerID
	 */
	public String registerSupplier(String producerName, String password);

	public List<String> getAllProducersForPart(String partName);
		
}
