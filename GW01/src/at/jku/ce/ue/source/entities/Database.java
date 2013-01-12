/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Schnitzi
 *
 */
public class Database {
	
	private static final int PRODUCER_COUNT = 15;
	
	private List<Producer> producers;
	
	public Database() {
		
		producers = new LinkedList<Producer>();
		
		fillWithData();
		
	}

	private void fillWithData() {
		
		for (int i = 0; i < PRODUCER_COUNT; i++) {
			
			Producer prod = new Producer(i, "Producer "+i, "Prod Street "+i);
			
			List<Part> parts = producePartsForProducer(prod);
			
			prod.setParts(parts);
			
		}
		
	}

	private List<Part> producePartsForProducer(Producer prod) {
		
		LinkedList<Part> parts = new LinkedList<Part>();
		
		for (Iterator iterator = parts.iterator(); iterator.hasNext();) {
			Part part = (Part) iterator.next();
			
		}
		
//		Part part = new Part(id, name, offeredBy, subParts)
		
//		parts.add(arg0);
		
		return parts;
	}
	
}
