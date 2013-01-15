package at.jku.ce.ue.source;

import java.util.List;
import java.util.Map;

import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	UddiApp app;
	private Map<String, String> plattforms;
	public String plattformName;


	public UddiRegistration() {
		app = new UddiApp();
	}
	
		
//	publishes own plattform
	public String publishPlattformAndService(){
		String var = null;
//		var = app.publishService();
		var = app.publishServiceAnyway();

		return var;
	}
	
//	returns list of registered plattforms
	public Map<String, String> generateListofEndpoints(){
		this.setPlattforms(app.getListofEndpoints());
		return this.getPlattforms();
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
