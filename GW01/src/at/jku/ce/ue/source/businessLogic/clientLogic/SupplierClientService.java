/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.clientLogic;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierClientService implements SupplierService {

	@Override
	public Producer getProducer(int producerID) {

		return null;
	}

	@Override
	public Map<String, Producer> getAllProducers() {

		Database db = Database.getInstance();
		Map<String, Producer> storedPoducers = db.getProducers();
		List<Producer> producers = new LinkedList<Producer>();

		// Managing UDDI Stuff
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi
				.generateListofEndpoints();

		// Iterating through all platforms
		for (InquiryOrderPlattformService plattform : plattforms.values()) {
			// Getting all producers of other platforms
			List<String> prods = plattform.getAllProducersOnPlattform();
			
			// Iterating through all Producers of platform 'plattform'
			for (String name : prods) {
				// If not already stored in our database, store it
				if(!storedPoducers.containsKey(name)){
					Producer prod = new Producer(name, name);
					storedPoducers.put(name, prod);
				}
			}
		}

		return storedPoducers;
	}

	@Override
	public List<String> getAllProducerNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerSupplier(String producerName, String password,
			String adress) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addPartsToProducer(int producerId, List<Part> parts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getAllProducersForPart(String partId) {
		// TODO Auto-generated method stub
		return null;
	}

}
