/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.List;

/**
 * @author Schnitzi
 *
 */
public class Customer extends Role {

	private List<Inquiry> inquiries;
	
	/**
	 * @param roleId
	 * @param name
	 * @param adress
	 */
	public Customer(int roleId, String name, String adress) {
		super(roleId, false, name, adress);
		
	}

	@Override
	boolean storeRole() {
		
		
		return false;
	}

	/**
	 * @return the inquiries
	 */
	public List<Inquiry> getInquiries() {
		return inquiries;
	}

	/**
	 * @param inquiries the inquiries to set
	 */
	public void setInquiries(List<Inquiry> inquiries) {
		this.inquiries = inquiries;
	}
	
}
