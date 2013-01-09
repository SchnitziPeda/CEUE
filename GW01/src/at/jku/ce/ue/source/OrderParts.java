package at.jku.ce.ue.source;

import java.util.ArrayList;
import java.util.List;

import at.jku.ce.ue.bom.BOMService;
import at.jku.ce.ue.bom.BOMServiceService;

public class OrderParts {
	
	List<String> list = new ArrayList();
	
	public List<String> testBom(){
		BOMServiceService ss = new BOMServiceService(BOMServiceService.WSDL_LOCATION, BOMServiceService.SERVICE);
		BOMService port = ss.getBOMServicePort();
		
		//String output = port.getAllParts().toString();
		list.addAll(port.getAllParts());
		return list;
	}

}
