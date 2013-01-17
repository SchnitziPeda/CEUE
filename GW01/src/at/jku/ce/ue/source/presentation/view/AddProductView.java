/**
 * 
 */
package at.jku.ce.ue.source.presentation.view;

import java.util.List;

/**
 * @author Schnitzi
 * 
 */
public interface AddProductView {

	public boolean addProductToProducer(String producerId, List<String> parts);

}
