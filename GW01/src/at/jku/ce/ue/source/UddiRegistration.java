package at.jku.ce.ue.source;

import java.rmi.RemoteException;
import java.util.List;

import org.uddi.v3_service.DispositionReportFaultMessage;

import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	UddiApp app;
	private List<String> plattforms;
	public String plattformName;


	public UddiRegistration() {
		app = new UddiApp();
	}
	
//	publishes service inlcuding wsdl file 
	public String publishService(){
		return app.publishService();
	}
		
//	publishes own plattform
	public String publishPlattform(String plattformName){
		String var = null;
		try {
			var = app.publish(plattformName);
		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var;
	}
	
//	returns wsdl file for a given plattform
	public String getWsdlOfPlattform(String plattformName){
		return app.getWsdlFile(plattformName);
	}
	
//	returns list of registered plattforms
	public void generateListofEndpoints(){
		try {
			app.getListofEndpoints(app.findServicesBy("BOMServiceService"));
		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getPlattforms() {
		return plattforms;
	}

	public void setPlattforms(List<String> plattforms) {
		this.plattforms = plattforms;
	}

	
	

}
