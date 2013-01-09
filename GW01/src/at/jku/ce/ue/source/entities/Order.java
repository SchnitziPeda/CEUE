/**
 * 
 */
package at.jku.ce.ue.source.entities;

/**
 * @author Schnitzi
 *
 */
public class Order {

	private int orderID;
	
	private Role customer;
	private Role supplier;
	
	private Offer offer;

	/**
	 * @param orderID
	 * @param customer
	 * @param supplier
	 * @param offer
	 */
	public Order(int orderID, Role customer, Role supplier, Offer offer) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.supplier = supplier;
		this.offer = offer;
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/**
	 * @return the customer
	 */
	public Role getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Role customer) {
		this.customer = customer;
	}

	/**
	 * @return the supplier
	 */
	public Role getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Role supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the offer
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * @param offer the offer to set
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	
}
