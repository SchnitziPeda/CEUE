/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

/**
 * @author andreaspfeifer
 *
 */
public interface OrderService {
	
	public String placeOrder(String customerid, String producerid, String partid, String inquiryid, String price, String orderId);

}
