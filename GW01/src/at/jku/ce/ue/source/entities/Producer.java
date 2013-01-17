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
public class Producer extends Role {
	
	private List<Part> parts;
	private String plattform;
	
	/**
	 * @param roleId
	 * @param name
	 */
	public Producer(String roleId, String name) {
		super(roleId, true, name);
		this.parts = new LinkedList<Part>();
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
	public List<Part> getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Producer [id=" + getId() + ", name=" + getName() + ", parts=" + parts
				+ "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((parts == null) ? 0 : parts.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producer other = (Producer) obj;
		if (getId() != other.getId())
			return false;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (parts == null) {
			if (other.parts != null)
				return false;
		} else if (!parts.equals(other.parts))
			return false;
		return true;
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
