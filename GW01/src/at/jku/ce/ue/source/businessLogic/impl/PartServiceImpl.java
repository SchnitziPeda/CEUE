package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;

import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

public class PartServiceImpl implements PartService {

	@Override
	public Part getPart(String PartID) {
		// TODO Auto-generated method stub

		Database database = Database.getInstance();
		database.getPart(partID);		
		
		return null;
	}

	@Override
	public List<Part> getAllParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllPartKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
