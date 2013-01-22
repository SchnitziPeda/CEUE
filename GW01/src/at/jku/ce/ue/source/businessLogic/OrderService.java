/**
 * 
 */
package at.jku.ce.ue.source.businessLogic;

/**
 * @author andreaspfeifer
 *
 */
public interface OrderService {
	
	public void placeOrder(String customerid, String producerid, String partid, String inquiryid, int price, String orderid);

}
