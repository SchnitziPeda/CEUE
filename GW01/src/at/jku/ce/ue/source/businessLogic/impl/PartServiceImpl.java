package at.jku.ce.ue.source.businessLogic.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Producer;

public class PartServiceImpl implements PartService {

	@Override
	public List<String> getAllParts() {
		Database db = Database.getInstance();
		return new LinkedList<String>(db.getPartHierarchy().keySet());
	}

	@Override
	public List<String> getAllPartNames() {
		return getAllParts();
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
				parts = new LinkedList<String>(producer.getParts().keySet());
			}
		}

		return parts;
	}

	@Override
	public List<String> getAllDirectSubpartsOfPart(String partId) {
		Map<String, List<String>> parts = Database.getInstance().getPartHierarchy();
		return parts.get(partId);
	}

}
