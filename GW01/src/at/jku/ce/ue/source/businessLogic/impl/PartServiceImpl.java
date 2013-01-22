package at.jku.ce.ue.source.businessLogic.impl;

import java.util.LinkedList;
import java.util.List;

import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

public class PartServiceImpl implements PartService {

	@Override
	public Part getPart(String partID) {

		return null;
	}

	@Override
	public List<Part> getAllParts() {
		Database db = Database.getInstance();
		LinkedList<Part> list = new LinkedList<Part>(db.getPartsOnPlattform()
				.values());
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
		for (Part part : getAllParts()) {
			list.add(part.getName());
		}
		return list;
	}

	@Override
	/**
	 * returns all parts for the given producer
	 */
	public List<String> getAllPartsByProducer(String producerId) {
		List<String> parts = new LinkedList<String>();

		SupplierServiceImpl supService = new SupplierServiceImpl();
		for (Producer producer : supService.getAllProducers().values()) {
			if (producer.getName().equals(producerId)) {
				for (String part : producer.getParts().keySet()) {
					parts.add(part);
				}
			}
		}

		return parts;
	}

	@Override
	public List<String> getAllDirectSubpartsOfPart(String partId) {
		List<Part> allParts = this.getAllParts();
		Part part = null;
		for (Part p : allParts) {
			if (p.getName().equals(partId)) {
				part = p;
			}
		}
		List<String> subParts = new LinkedList<String>();
		for (Part p : part.getSubParts()) {
			subParts.add(p.getName());
		}

		return subParts;
	}

}
