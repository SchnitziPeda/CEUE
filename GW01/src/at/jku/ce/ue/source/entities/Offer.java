/**
 * 
 */
package at.jku.ce.ue.source.entities;

/**
 * @author Schnitzi
 *
 */
public class Offer {

	private String offerID;

	private Part part;
	private Role supplierOfOffer;
	private Role customerOfOffer;
	private Inquiry inquiryOfOffer;
	
	private double price;

	/**
	 * @param offerID
	 * @param part
	 * @param supplierOfOffer
	 * @param customerOfOffer
	 * @param inquiryOfOffer
	 * @param price
	 */
	public Offer(String offerID, Part part, Role supplierOfOffer,
			Role customerOfOffer, Inquiry inquiryOfOffer, double price) {
		super();
		this.offerID = offerID;
		this.part = part;
		this.supplierOfOffer = supplierOfOffer;
		this.customerOfOffer = customerOfOffer;
		this.inquiryOfOffer = inquiryOfOffer;
		this.price = price;
	}

	/**
	 * @return the offerID
	 */
	public String getOfferID() {
		return offerID;
	}

	/**
	 * @param offerID the offerID to set
	 */
	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	/**
	 * @return the part
	 */
	public Part getPart() {
		return part;
	}

	/**
	 * @param part the part to set
	 */
	public void setPart(Part part) {
		this.part = part;
	}

	/**
	 * @return the supplierOfOffer
	 */
	public Role getSupplierOfOffer() {
		return supplierOfOffer;
	}

	/**
	 * @param supplierOfOffer the supplierOfOffer to set
	 */
	public void setSupplierOfOffer(Role supplierOfOffer) {
		this.supplierOfOffer = supplierOfOffer;
	}

	/**
	 * @return the customerOfOffer
	 */
	public Role getCustomerOfOffer() {
		return customerOfOffer;
	}

	/**
	 * @param customerOfOffer the customerOfOffer to set
	 */
	public void setCustomerOfOffer(Role customerOfOffer) {
		this.customerOfOffer = customerOfOffer;
	}

	/**
	 * @return the inquiryOfOffer
	 */
	public Inquiry getInquiryOfOffer() {
		return inquiryOfOffer;
	}

	/**
	 * @param inquiryOfOffer the inquiryOfOffer to set
	 */
	public void setInquiryOfOffer(Inquiry inquiryOfOffer) {
		this.inquiryOfOffer = inquiryOfOffer;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
