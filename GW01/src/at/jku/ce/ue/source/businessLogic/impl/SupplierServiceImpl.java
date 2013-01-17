/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
	public Map<Integer, Producer> getAllProducers() {

		Database db = Database.getInstance();

		return db.getProducers();
	}

	@Override
	public List<String> getAllProducerNames() {

		Map<Integer, Producer> prodList = getAllProducers();

		Collection<Producer> values = prodList.values();
		List<String> names = new LinkedList<String>();
		
		for(Producer prod : values){
			names.add(prod.getName());
		}
		
		return names;

	}

	@Override
	public int registerSupplier(String producerName, String password,
			String adress) {

		int prodId = -1;

		Database db = Database.getInstance();
		if (producerName != null && producerName != "") {
			if (password != null && password != "") {
				prodId = db.addProducer(producerName, password, adress);
			} else {
				log.info("Password of producer is empty");
			}
		} else {
			log.info("Name of producer is empty");
		}

		return prodId;
	}

	@Override
	public boolean addPartsToProducer(int producerId, List<Part> parts) {
		
		Database db = Database.getInstance();
		
		Producer producer = null;
		
		if(producerId != 0 && producerId != -1){
			producer = db.getProducers().get(producerId);
		}else{
			log.severe("ProducerID is not valid!");
			return false;
		}
		
		if(producer == null){
			log.severe("Producer with id: "+producerId+" was not found!");
			return false;
		}
		
		List<Part> partsOfProducer = producer.getParts();
		
		for(Part part : parts){
			partsOfProducer.add(part);
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
		for(Part part : list){
			if(part.getName().equals(partId)){
				producers.add(part.getOfferedBy().getName());
			}
		}
		
		return producers;
	}
}
