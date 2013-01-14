/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Schnitzi
 * 
 */
public class Database {

	private static final int PRODUCER_COUNT = 15;

	private static final int PART_COUNT = 15;

	private static List<Producer> producers;

	private static List<Part> parts;

	private static Database database;

	public Database() {

		setProducers(new LinkedList<Producer>());

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

			getProducers().add(prod);

		}
	}

	private void producePartsForProducer() {

		LinkedList<Part> parts = new LinkedList<Part>();

		for (int i = 0; i < PART_COUNT; i++) {
			Part schlauch = new Part(i, "gw01SchlauchPR" + i, getProducers().get(i));
			Part motor = new Part(i, "gw01MotorPR" + i, getProducers().get(i));

			Part pumpe = new Part(i, "gw01PumpePR" + i, getProducers().get(i));

			Part tank = new Part(i, "gw01TankPR" + i, getProducers().get(i));

			Part wassertank = new Part(i, "gw01WassertankPR" + i,
					getProducers().get(i));

			// Building pumpe
			pumpe.getSubParts().add(schlauch);
			pumpe.getSubParts().add(motor);

			// Building wassertank
			wassertank.getSubParts().add(pumpe);
			wassertank.getSubParts().add(tank);

			// Put into
			parts.add(schlauch);
			parts.add(motor);
			parts.add(pumpe);
			parts.add(tank);
			parts.add(wassertank);
		}

	}

	/**
	 * @return the parts
	 */
	public List<Part> getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(List<Part> parts) {
		Database.parts = parts;
	}

	/**
	 * @return the producers
	 */
	public List<Producer> getProducers() {
		return producers;
	}

	/**
	 * @param producers the producers to set
	 */
	public void setProducers(List<Producer> producers) {
		Database.producers = producers;
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
	
}
