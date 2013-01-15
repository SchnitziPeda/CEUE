/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;

/**
 * @author Schnitzi
 *
 */
public interface BOMServiceUtil {

	public List<String> getAllPartsOfBOM();
	
	public List<String> getAllDirectSubpartsOfPart(String superPart);
	
}
