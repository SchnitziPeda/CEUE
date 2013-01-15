package at.jku.ce.ue.source;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.service.InquiryOrderPlattformServiceService;
import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	
	private static final String QNameURL = "http://ue.ce.jku.at/";
	private static final String QNameName = "InquiryOrderPlattformServiceService";
	
	UddiApp app;
	private Map<String, String> plattforms;
	public String plattformName;


	public UddiRegistration() {
		app = new UddiApp();
	}
	
		
//	publishes own plattform
	public String publishPlattformAndService(){
		String var = null;
		var = app.publishService();
//		var = app.publishServiceAnyway();

		return var;
	}
	
	/*
	 * returns list of generated plattforms
	 */
	public List<InquiryOrderPlattformService> generateListofEndpoints(){
		List<InquiryOrderPlattformService> serviceCollection = null;
		plattforms = app.getListofEndpoints();
		URL wsdlLocation = null;
		
		for(String key : plattforms.keySet()){
			String value = plattforms.get(key);
			
			try {
				wsdlLocation = new URL(value);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService"));
			if(ss != null){
				String var = ss.getWSDLDocumentLocation().toString();
				// TODO: always returns null!! 
				InquiryOrderPlattformService myService = ss.getInquiryOrderPlattformServicePort();
				serviceCollection.add(myService); 
				System.out.println(var);
			}
			
		}
		
//		for(String key : plattforms.keySet()){
//			String value = plattforms.get(key);
//			try {
//				wsdlLocation = new URL(value);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			};
//			InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService"));
//			if(ss != null){				
//				String var = ss.getWSDLDocumentLocation().toString();
//				System.out.println(var);
//				if(var.contains("PS24")){
//					InquiryOrderPlattformService myService = ss.getInquiryOrderPlattformServicePort();
//				}
////				serviceCollection.addAll(myService.getAllProducersOnPlattform());
//			}
//		}
		return serviceCollection;
//		
//		
//		URL wsdlLocation = new URL("http://140.78.73.87:8085/PS24/services/InquiryOrderPlattformServicePort?wsdl");
//		QName service = new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService");
//		InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, service);
//		InquiryOrderPlattformService test = ss.getInquiryOrderPlattformServicePort();
//
//		list.addAll(test.getAllProducersOnPlattform());
////		list.addAll(test.getAllPartsOnPlattform());
//		return list;
//		
//		return this.getPlattforms();
	}
	
//	returns wsdl file for a given plattform
	public String getWsdlOfPlattform(String plattformName){
		return app.getWsdlFile(plattformName);
	}


	public Map<String, String> getPlattforms() {
		return plattforms;
	}


	public void setPlattforms(Map<String, String> plattforms) {
		this.plattforms = plattforms;
	}

}
