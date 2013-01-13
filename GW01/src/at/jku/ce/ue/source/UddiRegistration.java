package at.jku.ce.ue.source;

import java.rmi.RemoteException;
import java.util.List;

import org.uddi.v3_service.DispositionReportFaultMessage;

import at.jku.ce.ue.uddi.UddiApp;

public class UddiRegistration {
	
	UddiApp app;
	private List<String> plattforms;

	public UddiRegistration() {
		app = new UddiApp();
		
	}
	
//	returns list of registered plattforms
	public void generateListOfPlattforms(){
		setPlattforms(app.getListOfPlattforms());
	}
	
//	publishes own plattform
	public String publishPlattform(String plattformName){
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
