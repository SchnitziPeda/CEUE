/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;
import java.util.Map;

/**
 * @author andreaspfeifer
 *
 */
public interface PriceService {
	
	public int getPrice(String customerid, String producerid, String partid, String inquiryid);
	
	public Map<String, Integer> getPriceForProducers(List<String> producer, String partid);
	
}
