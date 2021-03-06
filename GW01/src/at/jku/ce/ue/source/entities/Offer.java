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

	private String partName;
	private String supplierOfOffer;
	private String customerOfOffer;
	private String inquiryOfOffer;
	private String platformName;

	
	private int price;

	/**
	 * @param offerID
	 * @param subPart
	 * @param prod
	 * @param customerid
	 * @param inquiryid
	 * @param price
	 */
	public Offer(String offerID, String subPart, String prod,
			String customerid, String inquiryid, int price, String platformName) {
		super();
		this.offerID = offerID;
		this.partName = subPart;
		this.supplierOfOffer = prod;
		this.customerOfOffer = customerid;
		this.inquiryOfOffer = inquiryid;
		this.price = price;
		this.setPlatformName(platformName);
	}

	/**
	 * @return the offerID
	 */
	public String getOfferID() {
		return offerID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Offer [offerID=" + offerID + ", partName=" + partName
				+ ", supplierOfOffer=" + supplierOfOffer + ", customerOfOffer="
				+ customerOfOffer + ", inquiryOfOffer=" + inquiryOfOffer
				+ ", price=" + price + "]";
	}

	/**
	 * @param offerID the offerID to set
	 */
	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return the supplierOfOffer
	 */
	public String getSupplierOfOffer() {
		return supplierOfOffer;
	}

	/**
	 * @param supplierOfOffer the supplierOfOffer to set
	 */
	public void setSupplierOfOffer(String supplierOfOffer) {
		this.supplierOfOffer = supplierOfOffer;
	}

	/**
	 * @return the customerOfOffer
	 */
	public String getCustomerOfOffer() {
		return customerOfOffer;
	}

	/**
	 * @param customerOfOffer the customerOfOffer to set
	 */
	public void setCustomerOfOffer(String customerOfOffer) {
		this.customerOfOffer = customerOfOffer;
	}

	/**
	 * @return the inquiryOfOffer
	 */
	public String getInquiryOfOffer() {
		return inquiryOfOffer;
	}

	/**
	 * @param inquiryOfOffer the inquiryOfOffer to set
	 */
	public void setInquiryOfOffer(String inquiryOfOffer) {
		this.inquiryOfOffer = inquiryOfOffer;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the platformName
	 */
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * @param platformName the platformName to set
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

}
