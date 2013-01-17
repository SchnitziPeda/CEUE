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
		
	/**
	 * publishes own plattform including wsdl file
	 * @return void 
	 */
	public void publishPlattformAndService(){
		app.publishService();
	}
	
	/**
	 * Deletes our business 
	 */
	public void deleteService(){
		app.deleteService();
	}
	
	/**
	 * Generates and returns a list of available services 
	 * @return ServicePorts to call methods directly
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
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			
			try { 
				if(wsdlLocation != null){
					InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(wsdlLocation, new QName(QNameURL, QNameName));
					if(ss != null){
						InquiryOrderPlattformService myService = ss.getInquiryOrderPlattformServicePort();	
						if(myService != null){
							serviceCollection.add(myService);
						}
					}
				}				
			} catch (Exception e){
				System.out.println("error");
			}
		}

		return serviceCollection;

	}


	public Map<String, String> getPlattforms() {
		return plattforms;
	}


	public void setPlattforms(Map<String, String> plattforms) {
		this.plattforms = plattforms;
	}

}
