/**
 * 
 */
package at.jku.ce.ue.source.clientLogic.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.clientLogic.SupplierClientService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public class SupplierClientServiceImpl implements SupplierClientService {


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
		List<String> producers = new LinkedList<String>();
		
		// get own producers
		SupplierServiceImpl supService = new SupplierServiceImpl();
		for(Producer prod : supService.getAllProducers().values()){
			if(prod.getLevel() != null && prod.getLevel() == "1"){  //TODO: level's missing, nothing intelligent getting back (all producers are level 1)
				for(Part part : prod.getParts()){
					if(part.getName().equals(partId)){
						producers.add(prod.getName());
					}
				}
			}
		}
					
		
		// get foreign producers
		UddiInteraction uddi = new UddiInteraction();
		Map<String, InquiryOrderPlattformService> plattforms = uddi.generateListofEndpoints();
		// Iterating through all platforms
		for (String plattformName : plattforms.keySet()) {
			// Getting all parts of other platforms
			List<String> prods = plattforms.get(plattformName).getAllProducersForPart(partId);
			
			// Iterating through all parts of platform 'plattform'
			for (String name : prods){
				// add parts to current list
				producers.add(name);
			}
		}
		
		
		return producers;
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
	public List<String> getDirectSubPartsOf(String partId) {
		// TODO Auto-generated method stub
		return null;
	}

}
