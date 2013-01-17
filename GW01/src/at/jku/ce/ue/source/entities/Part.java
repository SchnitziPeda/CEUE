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
public class Part {

	private int id;
	private String name;
	private Producer offeredBy;
	private List<Part> subParts;
	private int price;

	/**
	 * @param id
	 * @param name
	 * @param offeredBy
	 * @param subParts
	 */
	public Part(int id, String name, Producer offeredBy) {
		super();
		this.id = id;
		this.name = name;
		this.offeredBy = offeredBy;
		this.subParts = new LinkedList<Part>();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param offeredBy
	 * @param subParts
	 */
	public Part(String name, Producer offeredBy) {
		super();
		this.id = 0;
		this.name = name;
		this.offeredBy = offeredBy;
		this.subParts = new LinkedList<Part>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the offeredBy
	 */
	public Producer getOfferedBy() {
		return offeredBy;
	}

	/**
	 * @param offeredBy
	 *            the offeredBy to set
	 */
	public void setOfferedBy(Producer offeredBy) {
		this.offeredBy = offeredBy;
	}

	/**
	 * @return the subParts
	 */
	public List<Part> getSubParts() {
		return subParts;
	}

	/**
	 * @param subParts
	 *            the subParts to set
	 */
	public void setSubParts(List<Part> subParts) {
		this.subParts = subParts;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public String getIdString() {
		return id + "";
	}

}
