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
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierServiceImpl implements SupplierService {

	private static Logger log = Logger.getLogger("SupplierServiceImpl");

	@Override
	public Producer getProducer(String producerID) {

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
	 * returns all producers for the given part name
	 */
	@Override
	public List<String> getAllProducersForPart(String partName) {
		List<String> producers = new LinkedList<String>();
		
		Map<String, Producer> producerList = getAllProducers();
		
		for(Producer prod : producerList.values()){
			List<String> partNames = prod.getPartNames();
			
			for (String string : partNames) {
				if(partName.contains(string)){
					producers.add(prod.getName());
				}
			}
		}

		return producers;
	}

}
