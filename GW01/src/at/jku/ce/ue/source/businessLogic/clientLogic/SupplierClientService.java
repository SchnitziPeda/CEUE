/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.clientLogic;

import java.util.List;
import java.util.Map;

import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;
import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 *
 */
public class SupplierClientService implements SupplierService{
	
	@Override
	public Producer getProducer(int producerID) {
		
		UddiInteraction uddi = new UddiInteraction();
		
		
		SupplierService service = new SupplierServiceImpl();
		
		
		
		return null;
	}

	@Override
	public Map<Integer, Producer> getAllProducers() {
		// TODO Auto-generated method stub
		return null;
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
	
	
	
}
