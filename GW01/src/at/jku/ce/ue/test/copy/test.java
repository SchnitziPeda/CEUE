package at.jku.ce.ue.test.copy;

import at.jku.ce.ue.bom.BOMService;
import at.jku.ce.ue.bom.BOMServiceService;

public class test {

	public String testBom(){
		BOMServiceService ss = new BOMServiceService(BOMServiceService.WSDL_LOCATION, BOMServiceService.SERVICE);
		BOMService port = ss.getBOMServicePort();
		
		String output = port.getAllParts().toString();
		return output;
	}
	
}
