package at.jku.ce.ue.source;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import at.jku.ce.ue.service.InquiryOrderPlattformService;
import at.jku.ce.ue.service.InquiryOrderPlattformServiceService;
import at.jku.ce.ue.uddi.UddiApp;

public class UddiInteraction {
	
	
	private static final String QNameURL = "http://ue.ce.jku.at/";
	private static final String QNameName = "InquiryOrderPlattformServiceService";
	
	UddiApp app;
	private Map<String, String> plattforms;
	public String plattformName;


	public UddiInteraction() {
		app = new UddiApp();
	}
	
		
//	publishes own plattform
	public String publishPlattformAndService(){
		String var = null;
		var = app.publishService();
//		var = app.publishServiceAnyway();
		System.out.println("service published");
		return var;
	}
	
	/**
	 * Deletes our business 
	 */
	public void deleteService(){
		app.deleteService();
	}
	
	/*
	 * returns list of generated plattforms
	 */
	@SuppressWarnings("null")
	public List<InquiryOrderPlattformService> generateListofEndpoints(){
		List<InquiryOrderPlattformService> serviceCollection = new LinkedList<InquiryOrderPlattformService>();
		plattforms = app.getListofEndpoints();
		URL wsdlLocation = null;
		
		for(String key : plattforms.keySet()){
			String value = plattforms.get(key);
			wsdlLocation = null;
			
			try {
				wsdlLocation = new URL(value);
//				System.out.println(wsdlLocation);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				// TODO: always returns null!! 
				if(wsdlLocation != null){
					System.out.println(wsdlLocation);
					InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService"));
//					System.out.println("SS: "+ss.getWSDLDocumentLocation().toString());
					if(ss != null){
						InquiryOrderPlattformService myService = ss.getInquiryOrderPlattformServicePort();	
//						System.out.println("myService: "+myService.getAllProducersOnPlattform().toString());
						if(myService != null){
							serviceCollection.add(myService);
						}
					}
				}
				
			} catch (Exception e){
				System.out.println("error");
//				e.printStackTrace();
			}
		}
		
//		System.out.println("grš§e: "+serviceCollection.size());
		return serviceCollection;

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
