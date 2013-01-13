package at.jku.ce.ue.uddi;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.juddi.v3.client.ClassUtil;
import org.apache.juddi.v3.client.config.UDDIClerkManager;
import org.apache.juddi.v3.client.config.UDDIClientContainer;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.Description;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.GetServiceDetail;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.SaveBusiness;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;

public class UddiApp {

	private static final Logger log = Logger.getLogger(UddiApp.class.getName());

	protected UDDISecurityPortType security = null;
	protected UDDIPublicationPortType publish = null;
	protected UDDIInquiryPortType inquiry = null;

	public UddiApp() {
		init();
	}

	private void init() {
		String uddifile = getResource("uddi.xml");
		try {
			UDDIClerkManager manager = new UDDIClerkManager(uddifile);
			UDDIClientContainer.addClerkManager(manager);
			manager.start();
			String clazz = manager.getClientConfig().getUDDINode("default")
					.getProxyTransport();
			Class<?> transportClass = ClassUtil.forName(clazz, Transport.class);
			if (transportClass != null) {
				Transport transport = (Transport) transportClass
						.getConstructor(String.class).newInstance("default");

				try {
					security = transport.getUDDISecurityService();
					publish = transport.getUDDIPublishService();
					inquiry = transport.getUDDIInquiryService();
				} catch (Exception ee) {
					log.severe(ee.getLocalizedMessage());
				}
			}
		} catch (Exception e) {
			log.severe(e.getLocalizedMessage());
		}
		log.exiting("UDDI Wrapper", "init<");
	}

	public String isRegistered(String namestring)
			throws DispositionReportFaultMessage, RemoteException {
		FindBusiness fb = new FindBusiness();
		// fb.setAuthInfo(myAuth);
		Name name = new Name();
		name.setValue(namestring);
		fb.getName().add(name);
		// fb.setFindQualifiers(value)
		BusinessList bl = inquiry.findBusiness(fb);
		if (bl != null
				&& bl.getBusinessInfos() != null
				&& bl.getBusinessInfos().getBusinessInfo().size() > 0
				&& bl.getBusinessInfos().getBusinessInfo().get(0).getName()
						.size() > 0)
			return bl.getBusinessInfos().getBusinessInfo().get(0).getName()
					.get(0).getValue();
		else
			return null;
	}

	public String getAuth() throws DispositionReportFaultMessage,
			RemoteException {
		GetAuthToken gat = new GetAuthToken();
		gat.setUserID("gruppe1");
		gat.setCred("");
		return security.getAuthToken(gat).getAuthInfo();
	}

	public String publish(String namestr) throws DispositionReportFaultMessage,
			RemoteException {
		if (isRegistered(namestr) == null) {
			SaveBusiness saveB = new SaveBusiness();

			saveB.setAuthInfo(getAuth());

			BusinessEntity businessEntity = new BusinessEntity();
			Name myName = new Name();
			myName.setValue(namestr);
			
			Description desc = new Description();
			desc.setValue("Webservice for some products");
						
			businessEntity.getName().add(myName);
			businessEntity.getDescription().add(desc);
			 			
			saveB.getBusinessEntity().add(businessEntity);
			if (publish.saveBusiness(saveB).getBusinessEntity().size() > 0)
				return publish.saveBusiness(saveB).getBusinessEntity().get(0)
						.getBusinessKey();
		}
		return null;
	}

	public static void main(String[] args) {
		UddiApp app = new UddiApp();
	
		String plattformName = "gruppe4"; // for testing
		app.getWsdlFile(plattformName);
		
//		try {
//			System.out.println("RESULT: " + app.publish("gruppe 1 publisher"));
//			System.out.println("RESULT: " + app.isRegistered("hi there!"));
			
//			String namestring = "gruppe4"; // for testing
//			
//			FindBusiness fb = new FindBusiness();
//			// fb.setAuthInfo(myAuth);
//			Name name = new Name();
//			name.setValue(namestring);
//			fb.getName().add(name);
//			// fb.setFindQualifiers(value)
//			BusinessList bl = app.inquiry.findBusiness(fb);
//						
//			
//			String servicekey = bl.getBusinessInfos().getBusinessInfo().get(0).getServiceInfos().getServiceInfo().get(0).getServiceKey();
//			
////			System.out.println(bl.getBusinessInfos().getBusinessInfo().get(0).getServiceInfos().getServiceInfo().get(0));
////			System.out.println(bl.getBusinessInfos().getBusinessInfo().get(0).getServiceInfos().getServiceInfo().get(0).getName().get(0).getValue());
//			
//			GetServiceDetail service = new GetServiceDetail();
//			service.setAuthInfo(app.getAuth());
//			service.getServiceKey().add(servicekey);
//			ServiceDetail serviceInfo = app.inquiry.getServiceDetail(service);
//			List<BusinessService> services = serviceInfo.getBusinessService();
//			String endpoint = null;
//			if(services.size()>0){
//				BusinessService bs = services.get(0);
//				AccessPoint ap = bs.getBindingTemplates().getBindingTemplate().get(0).getAccessPoint();
//				endpoint = ap.getValue();
//				System.out.print(endpoint);
//			}

			
//			der methoden aufruf konkret geht ungefähr so:
//
//			servicekey ... ist der unique key / die id des services....

//			 GetServiceDetail service = new GetServiceDetail();
//			 service.setAuthInfo(tokenPublish.getAuthInfo());
//			 service.getServiceKey().add(servicekey);
//			 ServiceDetail serviceInfo = inquiry.getServiceDetail(service);
//			 List<BusinessService> services = serviceInfo.getBusinessService();
//			 String endpoint = null;
//			 if (services.size() > 0) {
//			 BusinessService businessS = services.get(0);
//			 AccessPoint ap = businessS.getBindingTemplates()
//			    .getBindingTemplate().get(0).getAccessPoint();
//			 endpoint = ap.getValue();
//			
//			 }
//			
//		} catch (DispositionReportFaultMessage e) {
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
	
//	returns a list of registered plattforms
	public List<String> getListOfPlattforms(){
		List<String> elements = null;
		return elements;
	}
	
//	returns plattform depending WSDL file
	public String getWsdlFile(String plattformName){

		plattformName = "gruppe4"; // for testing
		
		FindBusiness fb = new FindBusiness();
		// fb.setAuthInfo(myAuth);
		Name name = new Name();
		name.setValue(plattformName);
		fb.getName().add(name);
		// fb.setFindQualifiers(value)
		BusinessList bl = null;
		String serviceKey = null;
		String endpoint = null;
		try {
			bl = inquiry.findBusiness(fb);
			serviceKey = bl.getBusinessInfos().getBusinessInfo().get(0).getServiceInfos().getServiceInfo().get(0).getServiceKey();
			
			GetServiceDetail service = new GetServiceDetail();
			service.setAuthInfo(getAuth());
			service.getServiceKey().add(serviceKey);
			ServiceDetail serviceInfo = inquiry.getServiceDetail(service);
			List<BusinessService> services = serviceInfo.getBusinessService();
			endpoint = null;
			if(services.size()>0){
				BusinessService bs = services.get(0);
				AccessPoint ap = bs.getBindingTemplates().getBindingTemplate().get(0).getAccessPoint();
				endpoint = ap.getValue();
			}
//			return endpoint;
			
			
		} catch (DispositionReportFaultMessage e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// check, if "wsdl" is at the end
		if(!endpoint.endsWith("?wsdl"))
				endpoint = endpoint+"?wsdl";
				
		return endpoint;

	}

	public String getResource(String name) {
		String result = null;
		/*
		 * find resource requires CXF 2.5; jUddi uses cxf 2.1 try { result =
		 * org.apache.cxf.bus.spring.BusApplicationContext
		 * .findResource(name).getFile().getAbsolutePath(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */
		if (result == null) {
			ClassLoader threadClassLoader = Thread.currentThread()
					.getContextClassLoader();
			if (threadClassLoader != null) {
				URL url = threadClassLoader.getResource(name);
				if (url != null) {
					try {
						result = new File(url.toURI()).getAbsolutePath();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (result == null) {
			ClassLoader callerClassLoader = this.getClass().getClassLoader();
			URL url = callerClassLoader.getResource(name);
			if (url != null) {
				try {
					result = new File(url.toURI()).getAbsolutePath();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
