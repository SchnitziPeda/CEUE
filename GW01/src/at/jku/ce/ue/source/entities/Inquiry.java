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
	private String part;
	private String supplier;
	private String customer;
	
	/**
	 * @param id
	 * @param part
	 * @param supplier
	 * @param customer
	 */
	public Inquiry(int id, String part, String supplier, String customer) {
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

	
}
