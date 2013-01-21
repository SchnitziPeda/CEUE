/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Schnitzi
 *
 */
public class Producer extends Role {
	
	private Map<String, Integer> parts;
	private String plattform;
	private String level;
	
	/**
	 * @param roleId
	 * @param name
	 */
	public Producer(String roleId, String name) {
		super(roleId, true, name);
		this.parts = new HashMap<String, Integer>();
		this.level = "1";
	}
	
	public boolean addNewProduct(String name, int price){
		
		parts.put(name, price);
		
		return true;
	}
	
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return super.getId();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		super.setId(id);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		super.setName(name);
	}

	/**
	 * @return the parts
	 */
	public Map<String, Integer> getParts() {
		return parts;
	}
	/**
	 * @return the parts names
	 */
	public List<String> getPartNames() {
		return new LinkedList<String>(parts.keySet());
	}

	/**
	 * @return the plattform
	 */
	public String getPlattform() {
		return plattform;
	}

	/**
	 * @param plattform the plattform to set
	 */
	public void setPlattform(String plattform) {
		this.plattform = plattform;
	}
	
}
