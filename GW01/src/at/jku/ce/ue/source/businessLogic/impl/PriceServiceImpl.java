/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.source.businessLogic.PriceService;
import at.jku.ce.ue.source.entities.Database;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author andreaspfeifer
 *
 */
public class PriceServiceImpl implements PriceService {

	@Override
	public int getPrice(String customerid, String producerid, String partid,
			String inquiryid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<String, Integer> getPriceForProducers(List<String> producer, String partid) {
		Map<String, Integer> prices = new HashMap<String, Integer>();
		
		/*
		 * TODO
		 * price logic for calculating end prices should go here 
		 */
		
		Database db = Database.getInstance();
		Map<String, Producer> producerFromDatabase = db.getProducers();

		for (Producer prod : producerFromDatabase.values()) {

			Map<String, Integer> partsOfProd = prod.getParts();
		
			if(partsOfProd.containsKey(partid)){
				prices.put(prod.getName(), partsOfProd.get(partid));
			}
			
		}
		
		return prices;
		
//		for(Producer prod : producerFromDatabase.values()){
//			for(String pd : producer){
//				// check if given producer matches with database
//				if(prod.getName().equals(pd)){
//					// check, if producer has the given product
////					for(String part : prod.getParts()){
////						if(part.getName().equals(partid)){
////							// if equal, add to list
////							prices.put(prod.getName(), part.getPrice());
////						}
////					}
//					
//					List<String> partNames = prod.getPartNames();
//					
//					if(partNames.contains(partid)){
//						prices.put(partid, part);
//					}
//					
//				}
//			}
//		}
		
	}

	
}
