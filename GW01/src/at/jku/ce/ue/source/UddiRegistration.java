package at.jku.ce.ue.source;

import java.util.List;

import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	UddiApp app;

	public UddiRegistration() {
		app = new UddiApp();
	}
	
//	returns list of registerd plattforms
	public List<String> getListofPlattforms(){
		return app.getListOfPlattforms();
		
	}
	
//	publishes own plattform
	public void publishPlattform(){
		
	}
	
//	returns wsdl file for a given plattform
	public String getWsdlOfPlattform(String plattformName){
		return app.getWsdlFile(plattformName);
	}
	
	

}
