/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

/**
 * @author andreaspfeifer
 *
 */
public interface PriceService {
	
	public int getPrice(String customerid, String producerid, String partid, String inquiryid);

}
