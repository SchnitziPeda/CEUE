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

import at.jku.ce.ue.source.businessLogic.BOMServiceUtil;
import at.jku.ce.ue.source.businessLogic.impl.BOMServiceUtilImpl;

/**
 * @author Schnitzi
 * 
 */
public class Database {

	private static Logger log = Logger.getLogger("Database");

	private static final int PRODUCER_COUNT = 15;

	private Map<Integer, Producer> producers;

	private static Database database;

	public Database() {

		this.producers = new HashMap<Integer, Producer>();

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
	}

	private void createProducers() {
		for (int i = 0; i < PRODUCER_COUNT; i++) {

			Producer prod = new Producer(i, "gw01Producer " + i, "Prod Street "
					+ i);

			this.producers.put(i, prod);

		}
	}

	private void producePartsForProducer() {

		LinkedList<Part> parts = new LinkedList<Part>();

		BOMServiceUtil bomService = new BOMServiceUtilImpl();

		// Map for all parts with a List of their subParts
		List<Part> allPartsWithSubParts = new LinkedList<Part>();

		// List of all parts
		List<String> productList = bomService.getAllPartsOfBOM();
		log.severe("PART COUNT: " + productList.size());
		int count = 0;
		// Iterator through all parts and put every part and a list of it's
		// subparts in the map
		for (String partName : productList) {
			Random rand = new Random();

			Part part = null;
			for (Part partInList : allPartsWithSubParts) {
				if (partInList.getName().equals(partName)) {
					part = partInList;
				}
			}

			if (part == null) {
				int prodId = rand.nextInt(PRODUCER_COUNT);
				part = new Part(count, partName, producers.get(prodId));
				count += 1;
				producers.get(prodId).getParts().add(part);
			}

			// Get all subParts of actual looked part
			List<String> subPartList = bomService
					.getAllDirectSubpartsOfPart(partName);

			// Iterate through all subParts of 'part'
			for (String subPartName : subPartList) {

				Part subPart = null;

				// Check if 'subPartName' already exists as Part in this
				// database
				for (Part partInList : allPartsWithSubParts) {

					if (partInList.getName().equals(subPartName)) {
						subPart = partInList;
					}

				}

				if (subPart == null) {
					int prodId = rand.nextInt(PRODUCER_COUNT);
					subPart = new Part(count, subPartName,
							producers.get(prodId));
					count += 1;
					producers.get(prodId).getParts().add(part);
				}

				// Add 'subPart' as subpart of 'part'
				if (part != null && subPart != null) {
					part.getSubParts().add(subPart);
				}
			}

			if (part != null)
				allPartsWithSubParts.add(part);

		}

		printAllParts(allPartsWithSubParts);

	}

	// for (int i = 0; i < PART_COUNT; i++) {
	// Part schlauch = new Part(i, "gw01SchlauchPR" + i,
	// getProducers().get(i));
	// Part motor = new Part(i, "gw01MotorPR" + i, getProducers().get(i));
	//
	// Part pumpe = new Part(i, "gw01PumpePR" + i, getProducers().get(i));
	//
	// Part tank = new Part(i, "gw01TankPR" + i, getProducers().get(i));
	//
	// Part wassertank = new Part(i, "gw01WassertankPR" + i,
	// getProducers().get(i));
	//
	// // Building pumpe
	// pumpe.getSubParts().add(schlauch);
	// pumpe.getSubParts().add(motor);
	//
	// // Building wassertank
	// wassertank.getSubParts().add(pumpe);
	// wassertank.getSubParts().add(tank);
	//
	// // Put into
	// parts.add(schlauch);
	// parts.add(motor);
	// parts.add(pumpe);
	// parts.add(tank);
	// parts.add(wassertank);
	// }

	private void printAllParts(List<Part> allPartsWithSubParts) {

		for (Part part : allPartsWithSubParts) {
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

	public Producer getPart(int partID) {
		return producers.get(partID);
	}

	public int addProducer(String producerName, String password, String adress) {

		int prodId = producerName.hashCode();

		Producer producer = new Producer(prodId, producerName, adress);

		if (!producers.containsKey(prodId))
			producers.put(prodId, producer);
		else
			log.info("Producer was not able to be registered!");
		
		return prodId;

	}

	public Producer getProducer(String prodId) {
		return null;
	}

	/**
	 * @return the producers
	 */
	public Map<Integer, Producer> getProducers() {
		return producers;
	}

	/**
	 * @param producers the producers to set
	 */
	public void setProducers(Map<Integer, Producer> producers) {
		this.producers = producers;
	}

}
