/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;

/**
 * @author Schnitzi
 * 
 */
public interface PartService {

	/**
	 * Gets all producers of our platform
	 * 
	 * @return
	 */
	public List<String> getAllParts();
	
	public List<String> getAllPartNames();
	
	public List<String> getAllPartsByProducer(String producerId);
	
	public List<String> getAllDirectSubpartsOfPart(String partId);
	
	
}
