/**
 * 
 */
package at.jku.ce.ue.source.entities;


/**
 * @author Schnitzi
 * 
 */
public abstract class Role {

	private String id;
	private boolean isSupplier;
	private String name;
	
	/**
	 * @param roleId
	 * @param isSupplier
	 * @param name
	 * @param adress
	 */
	public Role(String roleId, boolean isSupplier, String name) {
		if(isSupplier)
			this.id = "GW01Producer"+name;
		else 
			this.id = "GW01Customer"+name;
		
		this.isSupplier = isSupplier;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the isSupplier
	 */
	public boolean isSupplier() {
		return isSupplier;
	}

	/**
	 * @param isSupplier the isSupplier to set
	 */
	public void setSupplier(boolean isSupplier) {
		this.isSupplier = isSupplier;
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

}
