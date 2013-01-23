/**
 * 
 */
package at.jku.ce.ue.source.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import at.jku.ce.ue.service.InquiryOrderPlattformService;

/**
 * @author Schnitzi
 *
 */
public class Producer extends Role {
	
	private Map<String, Integer> parts;
	private String plattform;
	private InquiryOrderPlattformService producerService;
	
	/**
	 * @param roleId
	 * @param name
	 */
	public Producer(String roleId, String name) {
		super(roleId, true, name);
		this.parts = new HashMap<String, Integer>();
	}
	
	public boolean addNewPart(String name, int price){
		
		parts.put(name, price);
		
		return true;
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return super.getId();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		super.setId(id);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		super.setName(name);
	}

	/**
	 * @return the parts
	 */
	public Map<String, Integer> getParts() {
		return parts;
	}
	/**
	 * @return the parts names
	 */
	public List<String> getPartNames() {
		return new LinkedList<String>(parts.keySet());
	}

	/**
	 * @return the plattform
	 */
	public String getPlattform() {
		return plattform;
	}

	/**
	 * @param plattform the plattform to set
	 */
	public void setPlattform(String plattform) {
		this.plattform = plattform;
	}

	/**
	 * @return the producerService
	 */
	public InquiryOrderPlattformService getProducerService() {
		return producerService;
	}

	/**
	 * @param producerService the producerService to set
	 */
	public void setProducerService(InquiryOrderPlattformService producerService) {
		this.producerService = producerService;
	}
	
}
