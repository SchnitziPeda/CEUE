
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

	@Override
	/**
	 * returns all parts for the given producer
	 */
	public List<String> getAllPartsByProducer(String producerId) {
		List<String> parts = new LinkedList<String>();
		
		SupplierServiceImpl supService = new SupplierServiceImpl();
		for(Producer producer : supService.getAllProducers().values()){
			if(producer.getName().equals(producerId)){
				for(Part part : producer.getParts()){
					parts.add(part.getName());
				}
			}
		}
		
		return parts;
	}
	
	/**
	 * returns all producers for the given part
	 * @param partId
	 * @return
	 */
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
