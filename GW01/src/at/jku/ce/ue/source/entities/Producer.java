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
public class Producer {
	
	private String id;
	private String name;
	private List<Part> parts;
	private String adress;
	private String plattform;
	
	/**
	 * @param roleId
	 * @param name
	 */
	public Producer(String roleId, String name) {
		this.id = "GW01Producer"+roleId;
		this.name = name;
		this.adress = adress;
		this.parts = new LinkedList<Part>();
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
	 * @return the parts
	 */
	public List<Part> getParts() {
		return parts;
	}
	/**
	 * @return the parts names
	 */
	public List<String> getPartNames() {
		List<String> names = new LinkedList<String>();
		for(Part p: parts){
			names.add(p.getName());			
		}
		return names;
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
		return "Producer [id=" + id + ", name=" + name + ", parts=" + parts
				+ "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
