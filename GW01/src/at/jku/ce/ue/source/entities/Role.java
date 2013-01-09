/**
 * 
 */
package at.jku.ce.ue.source.entities;


/**
 * @author Schnitzi
 * 
 */
public abstract class Role {

	private int roleId;
	private boolean isSupplier;
	private String name;
	private String adress;
	
	/**
	 * @param roleId
	 * @param isSupplier
	 * @param name
	 * @param adress
	 */
	public Role(int roleId, boolean isSupplier, String name, String adress) {
		super();
		this.roleId = roleId;
		this.isSupplier = isSupplier;
		this.name = name;
		this.adress = adress;
	}

	abstract boolean storeRole();
	
}
