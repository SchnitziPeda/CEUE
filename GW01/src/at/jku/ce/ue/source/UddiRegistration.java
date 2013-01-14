package at.jku.ce.ue.source;

import java.rmi.RemoteException;
import java.util.List;

import org.uddi.v3_service.DispositionReportFaultMessage;

import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	public static final String MY_HOSTER = "140.78.73.87";
	public static final String MY_PORT = "8090";
	
	private String wsdlLocation = "http://" + MY_HOSTER + ":" + MY_PORT +"/MN1Service/services/ProductsAndServicesImplPort?wsdl";
	private String serviceName = "gruppe 1 publisher";
	private String serviceDescription = "Webservice for managing prices of offered parts and retrieving price information.";
	
	UddiApp app;
	private List<String> plattforms;

	public UddiRegistration() {
		app = new UddiApp();
		
		if(this.isRegistered(serviceName))
			this.publishPlattform(serviceName);
	}
	
	public boolean isRegistered(String namestring){
		String var = null;
		try {
			var = app.isRegistered(namestring);
		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(var==null)
			return false;
		else
			return true;
		
	}
	
//	returns list of registered plattforms
	public void generateListOfPlattforms(){
		setPlattforms(app.getListOfPlattforms());
	}
	
//	publishes own plattform
	public String publishPlattform(String plattformName){
		/*
		 * checken ob wir schon gepublished sind
		 * wenn nicht -> publishen
		 * ansonsten -> passt 
		 */
		
		
		
		try {
			return app.publish(plattformName);
		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plattformName;
	}
	
//	returns wsdl file for a given plattform
	public String getWsdlOfPlattform(String plattformName){
		return app.getWsdlFile(plattformName);
	}

	public List<String> getPlattforms() {
		return plattforms;
	}

	public void setPlattforms(List<String> plattforms) {
		this.plattforms = plattforms;
	}
	
	

}
