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
		
		Database db = Database.getInstance();
		Map<String, Producer> producerFromDatabase = db.getProducers();
		for(Producer prod : producerFromDatabase.values()){
			for(String pd : producer){
				// check if given producer matches with database
				if(prod.getName().equals(pd)){
					// check, if producer has the given product
					for(Part part : prod.getParts()){
						if(part.getName().equals(partid)){
							// if equal, add to list
							prices.put(prod.getName(), part.getPrice());
						}
					}
					
				}
			}
		}
		
		return prices;
	}

	
}
