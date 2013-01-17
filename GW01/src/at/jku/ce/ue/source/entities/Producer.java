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
		this.id = roleId;
		this.name = name;
		this.adress = adress;
		this.parts = new LinkedList<Part>();
	}
	
//	@Override
//	public boolean storeRole() {
//		
//		// add new data to xml file:
//		if (supplierList != null && supplierList.getLength() > 0) {
//
//			// read current id:
//			Node node = null;
//			for (int i = 0; i < supplierList.getLength(); i++) {
//				node = supplierList.item(i);
//			}
//			if (node.getNodeType() == Node.ELEMENT_NODE) {
//				Element e = (Element) node;
//				NodeList ndList = e.getElementsByTagName("id");
//				NodeList elementValues = ndList.item(0).getChildNodes();
//				curId = Integer.parseInt(elementValues.item(0)
//						.getNodeValue());
//				// raise ID one up:
//				curId = curId + 1;
//			}
//
//			NodeList ndList = doc.getElementsByTagName("listOfSuppliers");
//			node = null;
//			for (int i = 0; i < ndList.getLength(); i++) {
//				node = ndList.item(i);
//			}
//			Element e = (Element) node;
//
//			// create new element:
//			Element newId = doc.createElement("id");
//			newId.appendChild(doc.createTextNode(Integer.toString(curId)));
//
//			Element name = doc.createElement("name");
//			name.appendChild(doc.createTextNode(supplierName));
//
//			Element newSupplier = doc.createElement("supplier");
//			newSupplier.appendChild(newId);
//			newSupplier.appendChild(name);
//
//			// add parts
//			Element newParts = doc.createElement("parts");
//			if (part1.length() != 0) {
//				Element newPart = doc.createElement("part");
//				newPart.appendChild(doc.createTextNode(part1));
//				newParts.appendChild(newPart);
//			}
//			if (part2.length() != 0) {
//				Element newPart = doc.createElement("part");
//				newPart.appendChild(doc.createTextNode(part2));
//				newParts.appendChild(newPart);
//			}
//			if (part3.length() != 0) {
//				Element newPart = doc.createElement("part");
//				newPart.appendChild(doc.createTextNode(part3));
//				newParts.appendChild(newPart);
//			}
//
//			newSupplier.appendChild(newParts);
//
//			// add to list of suppliers
//			rootElement.appendChild(newSupplier);
//
//			DOMSource source = new DOMSource(doc);
//
//			// write everything to xml file:
//			Transformer transformer = TransformerFactory.newInstance()
//					.newTransformer();
//			FileOutputStream fos = new FileOutputStream(xmlFile);
//			StreamResult result = new StreamResult(fos);
//			transformer.transform(source, result);
//			fos.flush();
//			fos.close();
//		
//		return false;
//	}

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
