/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
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
	public Producer getProducer(int producerID) {
		
		Database database = Database.getInstance();
		
		Producer prod = database.getProducer(producerID);
		
		if(prod == null){
			log.info("No producer with id: "+producerID+" found!");
		}
		
		return prod;
	}



	@Override
	public List<Producer> getAllProducers() {
		// TODO Auto-generated method stub
		return null;
	}
}
