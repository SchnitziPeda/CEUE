/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;

import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public interface PartService {

	/**
	 * Gets a producer by the producerIDof our platform
	 * 
	 * @param producerID
	 * @return
	 */
	public Part getPart(String PartID);

	/**
	 * Gets all producers of our platform
	 * 
	 * @return
	 */
	public List<Part> getAllParts();
	
	/**
	 * @return
	 */
	public List<String> getAllPartKeys();
	
	public List<String> getAllPartNames();
	
	public List<String> getAllPartsByProducer(String producerId);
	
	public List<String> getAllDirectSubpartsOfPart(String partId);
	
	
}
