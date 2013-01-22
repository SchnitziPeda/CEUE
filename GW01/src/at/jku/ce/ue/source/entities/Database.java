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
import at.jku.ce.ue.source.businessLogic.impl.BOMServiceUtilImpl;

/**
 * @author Schnitzi
 * 
 */
public class Database {

	private static final int PART_PRICE = 1000;

	private static Logger log = Logger.getLogger("Database");

	private static final int PRODUCER_COUNT = 15;

	private static Database database;

	private Map<String, Producer> producers;

	private Map<String, InquiryOrderPlattformService> services;

	private Map<String, InquiryOrderPlattformService> allServices;
	
	private Map<String, Part> partsOnPlattform;

	private Map<String, Customer> customersOnPlatform;

	private List<Offer> offersOfPlatform;

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

		producePartsForProducer();
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

	private void producePartsForProducer() {

		LinkedList<Part> parts = new LinkedList<Part>();

		BOMServiceUtil bomService = new BOMServiceUtilImpl();

		partsOnPlattform = new HashMap<String, Part>();

		// List of all parts
		List<String> productList = bomService.getAllPartsOfBOM();
		log.info("PART COUNT: " + productList.size());
		int count = 0;
		// Iterator through all parts and put every part and a list of it's
		// subparts in the map
		for (String partName : productList) {
			Random rand = new Random();

			Part part = null;
			for (Part partInList : partsOnPlattform.values()) {
				if (partInList.getName().equals(partName)) {
					part = partInList;
				}
			}

			if (part == null) {
				int prodId = rand.nextInt(PRODUCER_COUNT);
				part = new Part(count, partName, producers.get(prodId));
				count += 1;
				producers.get("GW01Producer" + prodId).addNewProduct(partName,
						rand.nextInt(PART_PRICE));
			}

			// Get all subParts of actual looked part
			List<String> subPartList = bomService
					.getAllDirectSubpartsOfPart(partName);

			// Iterate through all subParts of 'part'
			for (String subPartName : subPartList) {

				Part subPart = null;

				// Check if 'subPartName' already exists as Part in this
				// database
				for (Part partInList : partsOnPlattform.values()) {

					if (partInList.getName().equals(subPartName)) {
						subPart = partInList;
					}

				}

				if (subPart == null) {
					int prodId = rand.nextInt(PRODUCER_COUNT);
					subPart = new Part(count, subPartName,
							producers.get(prodId));
					count += 1;
					producers.get("GW01Producer" + prodId).addNewProduct(
							subPartName, rand.nextInt(PART_PRICE));
				}

				// Add 'subPart' as subpart of 'part'
				if (part != null && subPart != null) {
					part.getSubParts().add(subPart);
				}
			}

			if (part != null)
				partsOnPlattform.put(part.getIdString(), part);

		}

		printAllParts(partsOnPlattform);

	}

	private void printAllParts(Map<String, Part> allPartsWithSubParts) {

		for (Part part : allPartsWithSubParts.values()) {
			String outPut = "Part: No: " + part.getId() + part.getName();
			// System.out.println("Part: " + part.getName());

			if (part.getSubParts().size() > 0) {
				for (Part subPart : part.getSubParts()) {
					// System.out.println("\t+" + subPart.getName());
					outPut += "\n\t+ No: " + subPart.getId()
							+ subPart.getName();
				}
			} else {
				// System.out.println("\t No more subParts");
				outPut += "\n\t No more subParts";
			}
			System.out.println(outPut);
		}

	}

	/**
	 * @param producerID
	 * @return
	 */
	public Producer getProducer(int producerID) {
		return producers.get(producerID);
	}

	public Part getPart(String partID) {
		return partsOnPlattform.get(partID);
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

	/**
	 * @return the partsOnPlattform
	 */
	public Map<String, Part> getPartsOnPlattform() {
		return partsOnPlattform;
	}

	/**
	 * @param partsOnPlattform
	 *            the partsOnPlattform to set
	 */
	public void setPartsOnPlattform(Map<String, Part> partsOnPlattform) {
		this.partsOnPlattform = partsOnPlattform;
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
			
			this.services =  new UddiInteraction().generateListofEndpoints();
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
			
			this.allServices =  new UddiInteraction().generateListOfAllEndpoints();
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

}
