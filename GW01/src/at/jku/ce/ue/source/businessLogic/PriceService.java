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
	
	public Map<String, Integer> getPriceForProducers(List<String> producer, String partid);
	
	public List<Offer> getSupplyChains(String customerid, String partid, String inquiryid);

}
