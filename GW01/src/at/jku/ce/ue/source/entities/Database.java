/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.source.UddiInteraction;
import at.jku.ce.ue.source.businessLogic.BOMServiceUtil;
import at.jku.ce.ue.source.businessLogic.PartService;
import at.jku.ce.ue.source.businessLogic.impl.BOMServiceUtilImpl;
import at.jku.ce.ue.source.businessLogic.impl.PartServiceImpl;

/**
 * @author Schnitzi
 * 
 */
public class Database {

	private static final int PART_PRICE = 1000;

	private static Logger log = Logger.getLogger("Database");

	private static final int PRODUCER_COUNT = 5;

	private static Database database;

	private Map<String, Producer> producers;

	private Map<String, InquiryOrderPlattformService> services;

	private Map<String, InquiryOrderPlattformService> allServices;

	private List<String> partsOnPlattform;

	private Map<String, Customer> customersOnPlatform;

	private List<Offer> offersOfPlatform;

	private Map<String, List<String>> partHierarchy;

	public Database() {

		this.producers = new HashMap<String, Producer>();
		this.customersOnPlatform = new HashMap<String, Customer>();

		fillWithData();

	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}

		return database;
	}

	private void fillWithData() {

		createProducers();

		produceParts();
		createCustomer();

	}

	private void createCustomer() {
		for (int i = 0; i < 5; i++) {
			Customer c = new Customer("" + i, "" + i);
			this.customersOnPlatform.put(c.getId(), c);
		}
	}

	private void createProducers() {
		for (int i = 0; i < PRODUCER_COUNT; i++) {

			Producer prod = new Producer("" + i, "" + i);

			this.producers.put(prod.getId(), prod);

		}
	}

	private void produceParts() {

		BOMServiceUtil bomService = new BOMServiceUtilImpl();

		partsOnPlattform = new LinkedList<String>();

		// List of all parts
		partsOnPlattform = bomService.getAllPartsOfBOM();
		log.info("PART COUNT: " + partsOnPlattform.size());

		partHierarchy = new HashMap<String, List<String>>();
		for (String s : partsOnPlattform) {
			if (bomService.getAllDirectSubpartsOfPart(s) == null) {
				partHierarchy.put(s, new LinkedList<String>());
			} else {
				partHierarchy.put(s, bomService.getAllDirectSubpartsOfPart(s));
			}
		}
		
		addPartsToProducers();
	}

	private void addPartsToProducers() {
		int i = 0;
		int j = 0;
		for (Producer p : producers.values()) {
			i = 0;
			while (i < 5 && j < partsOnPlattform.size()) {
				p.addNewPart(partsOnPlattform.get(j),
						(int) (Math.random() * 100));
				i++;
				j++;
			}
		}
	}

	/**
	 * @param producerID
	 * @return
	 */
	public Producer getProducer(int producerID) {
		return producers.get(producerID);
	}


	public String registerProducer(String producerName, String password) {

		String prodId = producerName;

		Producer producer = new Producer(prodId, producerName);

		if (!producers.containsKey(producer.getId()))
			producers.put(producer.getId(), producer);
		else {
			log.info("Producer was not able to be registered!");
			return "-1";
		}

		return producer.getId();

	}

	public Producer getProducer(String prodId) {
		return producers.get(prodId);
	}

	/**
	 * registers a new customer
	 * 
	 * @param customerName
	 * @return
	 */
	public String registerCustomer(String customerName) {
		String customerId = customerName;
		Customer customer = new Customer(customerId, customerName);

		if (!customersOnPlatform.containsKey(customer.getId()))
			customersOnPlatform.put(customer.getId(), customer);
		else {
			log.info("Customer was not able to be registered!");
			return "-1";
		}

		return customer.getId();
	}

	/**
	 * generates a random inquiryid
	 * 
	 * @return String
	 */
	public String generateInquiryId() {
		Random rdm = new Random();
		int rndm = rdm.nextInt(20000);

		String inquiryid = "GW01Inq" + rndm;
		return inquiryid;
	}

	/**
	 * generates a random offer id
	 * 
	 * @return String
	 */
	public String generateOfferId() {
		Random rdm = new Random();
		int rndm = rdm.nextInt(20000);

		String offerid = "GW01Offer" + rndm;
		return offerid;
	}

	/**
	 * generates a random order id
	 * 
	 * @return String
	 */
	public String generateOrderId() {
		Random rdm = new Random();
		int rndm = rdm.nextInt(20000);

		String orderid = "GW01Order" + rndm;
		return orderid;
	}

	/**
	 * saves a given order
	 * 
	 * @param order
	 * @param producer
	 * @param price
	 */
	public void saveOrder(String order, String producer, int price) {
		// TODO
	}

	/**
	 * @return the producers
	 */
	public Map<String, Producer> getProducers() {
		return producers;
	}

	/**
	 * @param producers
	 *            the producers to set
	 */
	public void setProducers(Map<String, Producer> producers) {
		this.producers = producers;
	}

	public Map<String, Customer> getCustomersOnPlatform() {
		return customersOnPlatform;
	}

	public void setCustomersOnPlatform(Map<String, Customer> customersOnPlatform) {
		this.customersOnPlatform = customersOnPlatform;
	}

	/**
	 * @return the services
	 */
	public Map<String, InquiryOrderPlattformService> getServices(
			boolean withUpdate) {
		if (services == null || withUpdate) {
			// Managing UDDI Stuff

			this.services = new UddiInteraction().generateListofEndpoints();
		}

		return this.services;
	}

	/**
	 * @return the allServices
	 */
	public Map<String, InquiryOrderPlattformService> getAllServices(
			boolean withUpdate) {
		if (allServices == null || withUpdate) {
			// Managing UDDI Stuff

			this.allServices = new UddiInteraction()
					.generateListOfAllEndpoints();
		}

		return this.allServices;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(Map<String, InquiryOrderPlattformService> services) {
		this.services = services;
	}

	/**
	 * @return the partHierarchy
	 */
	public Map<String, List<String>> getPartHierarchy() {
		return partHierarchy;
	}

	/**
	 * @param partHierarchy the partHierarchy to set
	 */
	public void setPartHierarchy(Map<String, List<String>> partHierarchy) {
		this.partHierarchy = partHierarchy;
	}

}
