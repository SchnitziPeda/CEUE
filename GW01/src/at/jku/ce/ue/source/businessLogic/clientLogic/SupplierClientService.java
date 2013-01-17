/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.clientLogic;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierClientService implements SupplierService, PartService {

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
		for (String plattformName : plattforms.keySet()) {
			// Getting all producers of other platforms
			List<String> prods = plattforms.get(plattformName)
					.getAllProducersOnPlattform();

			// Iterating through all Producers of platform 'plattform'
			for (String name : prods) {
				// If not already stored in our database, store it
				if (!storedPoducers.containsKey(name)) {
					Producer prod = new Producer(name, name);
					prod.setPlattform(plattformName);
					storedPoducers.put(name, prod);
				}
			}
		}

		return storedPoducers;
	}

	@Override
	public List<String> getAllProducerNames() {

		Map<String, Producer> producers = getAllProducers();
		List<Producer> prodList = new LinkedList(producers.values());
		List<String> prodNames = new LinkedList<String>();

		for (Producer producer : prodList) {
			prodNames.add(producer.getName());
		}

		return prodNames;
	}

	@Override
	public String registerSupplier(String producerName, String password) {

		return "-1";
	}

	@Override
	public List<String> getAllProducersForPart(String partId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authentificateSupplier(String supplierName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPartsToProducer(String producerId, List<String> parts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Part getPart(String PartID) {
		// TODO Auto-generated method stub
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

	@Override
	public List<String> getAllPartNames() {
		Database db = Database.getInstance();
		List<String> storedParts = new LinkedList<String>();
		Map<String, Part> ownParts = db.getPartsOnPlattform();
		
		// adding own parts to list
		for(String key : ownParts.keySet()){
			Part partname = ownParts.get(key);
			storedParts.add(partname.getName());
		}
		
		// adding foreign parts to list
		// Managing UDDI Stuff
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi.generateListofEndpoints();

		// Iterating through all platforms
		for (String plattformName : plattforms.keySet()) {
			// Getting all parts of other platforms
			List<String> parts = plattforms.get(plattformName).getAllPartsOnPlattform();

			// Iterating through all parts of platform 'plattform'
			for (String name : parts) {
				// add parts to current list
				storedParts.add(name);
			}
		}

		return storedParts;

	}

	@Override
	public List<String> getAllPartsByProducer(String producerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
