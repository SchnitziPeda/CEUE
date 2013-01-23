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

	
	/**
	 * @param roleId
	 * @param name
	 * @param adress
	 */
	public Customer(String roleId, String name) {
		super(roleId, false, name);
	}
	
}
