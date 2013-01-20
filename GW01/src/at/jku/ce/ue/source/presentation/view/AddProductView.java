/**
 * 
 */
package at.jku.ce.ue.source.presentation.view;

import java.util.List;

import at.jku.ce.ue.source.entities.Part;
import at.jku.ce.ue.source.entities.Producer;

/**
 * @author Schnitzi
 * 
 */
public interface AddProductView {

	public boolean addProductToProducer(Producer producer, Part parts);

	public List<Part> getPartsList();

	public void setPartsList(List<Part> partsList);

}
