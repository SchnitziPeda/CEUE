/**
 * 
 */
package at.jku.ce.ue.source.businessLogic.impl;

import java.util.List;
import java.util.logging.Logger;

import at.jku.ce.ue.bom.BOMService;
import at.jku.ce.ue.bom.BOMServiceService;
import at.jku.ce.ue.source.businessLogic.BOMServiceUtil;

/**
 * @author Schnitzi
 *
 */
public class BOMServiceUtilImpl implements BOMServiceUtil {

	private static Logger log = Logger.getLogger("BOMServiceUtilImpl");
	private BOMServiceService ss;
	private BOMService port;
	
	public BOMServiceUtilImpl() {
		this.ss = new BOMServiceService(
				BOMServiceService.WSDL_LOCATION, BOMServiceService.SERVICE);;
		this.port = ss.getBOMServicePort();
	}

	@Override
	public List<String> getAllPartsOfBOM() {
		
		List<String> productList = this.port.getAllParts();
		
		if(productList == null){
			log.severe("Productlist of BOM is null!");
		}
		
		return productList;
	}

	@Override
	public List<String> getAllDirectSubpartsOfPart(String superPart) {
		
		List<String> subProductList = this.port.getDirectSubPartsOf(superPart);
		
		if(subProductList == null){
			log.severe("DirectSubProducts of part "+superPart+" is null!");
		}
		
		return subProductList;
	}

}
