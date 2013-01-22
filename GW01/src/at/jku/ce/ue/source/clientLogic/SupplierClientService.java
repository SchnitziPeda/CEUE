package at.jku.ce.ue.source.clientLogic;

import java.util.List;
import java.util.Map;

import at.jku.ce.ue.source.entities.Customer;
import at.jku.ce.ue.source.entities.Producer;

/**
 * 
 * @author andreaspfeifer
 * 
 */

public interface SupplierClientService {

	public Map<String, Producer> getAllProducers();

	public List<String> getAllProducerNames();

	public String registerSupplier(String producerName, String password);

	public List<String> getAllProducersForPart(String partId);

	public List<String> getAllPartNames();

	public List<String> getDirectSubPartsOf(String partId);

	public Map<String, Integer> getOffersForPart(String partId,
			String customerId);

	public List<String> getAllPartsByProducer(String producerId);

	public int getPrice(String customerId, String producerId, String partId,
			String inquiryId);

	public void saveOrders(String customerId, String partId, String[] orders,
			String[] producers, String[] prices);

	public List<String> getAllCustomerNames();

	public Map<String, Customer> getAllCustomers();

}
