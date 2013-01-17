
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.LinkedList;
import java.util.List;

import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;

public class PartServiceImpl implements PartService {

	@Override
	public Part getPart(String partID) {

		return null;
	}

	@Override
	public List<Part> getAllParts() {
		Database db = Database.getInstance();
		LinkedList<Part> list = new LinkedList<Part>(db.getPartsOnPlattform().values());
		return list; 
	}

	@Override
	public List<String> getAllPartKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllPartNames() {
		List<String> list = new LinkedList<String>();
		for(Part part : getAllParts()){
			list.add(part.getName());
		}
		return list;
	}


}
