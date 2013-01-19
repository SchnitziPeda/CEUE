/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierServiceImpl implements SupplierService {

	private static Logger log = Logger.getLogger("SupplierServiceImpl");

	@Override
	public Producer getProducer(int producerID) {

		Database database = Database.getInstance();

		Producer prod = database.getProducer(producerID);

		if (prod == null) {
			log.info("No producer with id: " + producerID + " found!");
		}

		return prod;
	}

	@Override
	public Map<String, Producer> getAllProducers() {

		Database db = Database.getInstance();

		return db.getProducers();
	}

	@Override
	public List<String> getAllProducerNames() {

		Map<String, Producer> prodList = getAllProducers();

		Collection<Producer> values = prodList.values();
		List<String> names = new LinkedList<String>();

		for (Producer prod : values) {
			if (prod.getPlattform() == "" || prod.getPlattform() == null)
				names.add(prod.getName());
		}

		return names;

	}

	@Override
	public String registerSupplier(String producerName, String password) {

		String prodId = "-1";

		Database db = Database.getInstance();
		if (producerName != null && producerName != "") {
			if (password != null && password != "") {
				prodId = db.registerProducer(producerName, password);
			} else {
				log.info("Password of producer is empty");
			}
		} else {
			log.info("Name of producer is empty");
		}

		return prodId;
	}

	/**
	 * authentificates a supplier
	 * 
	 * @param producerName
	 * @return
	 */
	public boolean authentificateSupplier(String producerName) {
		Database db = Database.getInstance();
		for (Producer pd : db.getProducers().values()) {
			System.out.println(pd.getName() + " " + producerName);
			if (pd.getName().equals(producerName)) {
				return true;
			} else
				return false;
		}
		return false;
	}

	@Override
	public boolean addPartsToProducer(String producerId, List<String> parts) {

		Database db = Database.getInstance();

		Producer producer = null;

		if (!producerId.equals("") && !producerId.equals("-1")) {
			producer = db.getProducers().get(producerId);
		} else {
			log.severe("ProducerID is not valid!");
			return false;
		}

		if (producer == null) {
			log.severe("Producer with id: " + producerId + " was not found!");
			return false;
		}

		List<Part> partsOfProducer = producer.getParts();
		List<String> partNames = producer.getPartNames();

		for (String newPartName : parts) {
			if (partNames.contains(newPartName)) {
				return false;
			}
		}
		for (String newPartName : parts) {
			Part p = new Part(newPartName, producer);
			partsOfProducer.add(p);
		}
		return true;
	}

	/**
	 * returns all producers for the given part name
	 */
	@Override
	public List<String> getAllProducersForPart(String partId) {
		List<String> producers = new LinkedList<String>();
		
		PartServiceImpl partService = new PartServiceImpl();
		List<Part> list = partService.getAllParts();
		for (Part part : list) {
			System.out.println(part.getName());
			if(part.getName().equals(partId)){
				/*
				 * TODO: getOfferedBy().getName() -> returns null! 
				 * instead: getId() is used -> doesnt work either
				 */
				if(part.getOfferedBy() != null)
					producers.add(part.getOfferedBy().getId());
				else 
					producers.add("Producer is missing!");
			}
		}

		return producers;
	}
}
