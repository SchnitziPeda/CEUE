/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

import java.util.List;
import java.util.Map;

import at.jku.ce.ue.source.entities.Offer;

/**
 * @author andreaspfeifer
 *
 */
public interface PriceService {
	
	public int getPrice(String customerid, String producerId, String partid, String inquiryid);
		
}
