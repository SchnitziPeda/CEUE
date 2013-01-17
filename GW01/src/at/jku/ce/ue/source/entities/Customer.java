/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.LinkedList;
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
	public Customer(String roleId, String name) {
		super(roleId, false, name);
		this.inquiries = new LinkedList<Inquiry>();
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
