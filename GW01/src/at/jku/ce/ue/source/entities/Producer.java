/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.List;

/**
 * @author Schnitzi
 *
 */
public class Producer extends Role {
	
	private int id;
	private String name;
	private List<Part> parts;
	
	/**
	 * @param roleId
	 * @param name
	 * @param adress
	 */
	public Producer(int roleId, String name, String adress) {
		super(roleId, true, name, adress);
	}
	
	@Override
	public boolean storeRole() {
		
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
		return false;
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

}
