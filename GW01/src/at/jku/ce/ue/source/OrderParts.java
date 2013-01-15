package at.jku.ce.ue.source;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import at.jku.ce.ue.bom.BOMService;
import at.jku.ce.ue.bom.BOMServiceService;
import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.service.InquiryOrderPlattformServiceService;

public class OrderParts {
	
	List<String> list = new ArrayList();
	
	public List<String> testBom(){
		BOMServiceService ss = new BOMServiceService(BOMServiceService.WSDL_LOCATION, BOMServiceService.SERVICE);
		BOMService port = ss.getBOMServicePort();
		
		//String output = port.getAllParts().toString();
		list.addAll(port.getAllParts());
		return list;
	}
	
	public List<String> testInqiury() throws MalformedURLException{
		URL wsdlLocation = new URL("http://140.78.73.87:8085/GW01/services/InquiryOrderPlattformServicePort?wsdl");
		QName service = new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService");
		InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, service);
		InquiryOrderPlattformService test = ss.getInquiryOrderPlattformServicePort();

		list.addAll(test.getAllProducersOnPlattform());
//		list.addAll(test.getAllPartsOnPlattform());
		return list;
		
	}
	
	

}