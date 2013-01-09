/**
 * 
 */
package at.jku.ce.ue.source.entities;

/**
 * @author Schnitzi
 *
 */
public class Inquiry {

	private int id;
	private Part part;
	private Role supplier;
	private Role customer;
	
	/**
	 * @param id
	 * @param part
	 * @param supplier
	 * @param customer
	 */
	public Inquiry(int id, Part part, Role supplier, Role customer) {
		super();
		this.id = id;
		this.part = part;
		this.supplier = supplier;
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	
}
