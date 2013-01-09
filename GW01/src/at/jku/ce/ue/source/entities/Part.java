/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.List;

/**
 * @author Schnitzi
 *
 */
public class Part {

	private int id;
	private String name;
	private Supplier offeredBy;
	private List<Part> subParts;
	
	/**
	 * @param id
	 * @param name
	 * @param offeredBy
	 * @param subParts
	 */
	public Part(int id, String name, Supplier offeredBy, List<Part> subParts) {
		super();
		this.id = id;
		this.name = name;
		this.offeredBy = offeredBy;
		this.subParts = subParts;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the offeredBy
	 */
	public Supplier getOfferedBy() {
		return offeredBy;
	}

	/**
	 * @param offeredBy the offeredBy to set
	 */
	public void setOfferedBy(Supplier offeredBy) {
		this.offeredBy = offeredBy;
	}

	/**
	 * @return the subParts
	 */
	public List<Part> getSubParts() {
		return subParts;
	}

	/**
	 * @param subParts the subParts to set
	 */
	public void setSubParts(List<Part> subParts) {
		this.subParts = subParts;
	}
	
	
}
