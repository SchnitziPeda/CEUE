package at.jku.ce.ue.uddi;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.juddi.v3.client.ClassUtil;
import org.apache.juddi.v3.client.config.UDDIClerkManager;
import org.apache.juddi.v3.client.config.UDDIClientContainer;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.DeleteBusiness;
import org.uddi.api_v3.Description;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.FindQualifiers;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.GetServiceDetail;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.SaveBusiness;
import org.uddi.api_v3.SaveService;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;

public class UddiApp {

	private String userID = "gruppe1";
	private String userName = "gruppe 1 publisher";

	public static final String MY_HOSTER = "140.78.73.87";
	public static final String MY_PORT = "8085";

	public static final String APPROXIMATE_MATCH = "approximateMatch";

	private String wsdlLocation = "http://" + MY_HOSTER + ":" + MY_PORT
			+ "/GW01/services/InquiryOrderPlattformServicePort?wsdl";
	private String serviceName = "Gruppe1_InquiryOrderPlattformServicePort";
	private String serviceID = "GW01";
	private String serviceDescription = "Webservice for managing prices of offered parts and retrieving price information.";

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

	/**
	 * check if service & plattform is already registered
	 * 
	 * @param namestring
	 * @return
	 * @throws DispositionReportFaultMessage
	 * @throws RemoteException
	 */
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

	/**
	 * deletes own business
	 */
	public void deleteService() {

		String businessKey = null;
		FindBusiness fb = new FindBusiness();
		Name name = new Name();
		name.setValue(userName);
		fb.getName().add(name);
		BusinessList bl = null;
		try {
			bl = inquiry.findBusiness(fb);
			if (bl != null
					&& bl.getBusinessInfos() != null
					&& bl.getBusinessInfos().getBusinessInfo().size() > 0
					&& bl.getBusinessInfos().getBusinessInfo().get(0).getName()
							.size() > 0)
				businessKey = bl.getBusinessInfos().getBusinessInfo().get(0)
						.getBusinessKey();

			DeleteBusiness db = new DeleteBusiness();
			db.getBusinessKey().add(businessKey);

			db.setAuthInfo(this.getAuth());
			publish.deleteBusiness(db);
			System.out.println("business deleted");
			System.out.println(businessKey);

		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * geth Auth
	 * 
	 * @return
	 * @throws DispositionReportFaultMessage
	 * @throws RemoteException
	 */
	public String getAuth() throws DispositionReportFaultMessage,
			RemoteException {
		GetAuthToken gat = new GetAuthToken();
		gat.setUserID(userID);
		gat.setCred("");
		return security.getAuthToken(gat).getAuthInfo();
	}

	/**
	 * publish plattform and check if already registered
	 * 
	 * @return
	 * @throws DispositionReportFaultMessage
	 * @throws RemoteException
	 */
	public String publish() throws DispositionReportFaultMessage,
			RemoteException {
		if (isRegistered(userName) == null) {
			SaveBusiness saveB = new SaveBusiness();

			saveB.setAuthInfo(getAuth());

			BusinessEntity businessEntity = new BusinessEntity();
			Name myName = new Name();
			myName.setValue(userName);

			businessEntity.getName().add(myName);

			saveB.getBusinessEntity().add(businessEntity);
			if (publish.saveBusiness(saveB).getBusinessEntity().size() > 0)
				return publish.saveBusiness(saveB).getBusinessEntity().get(0)
						.getBusinessKey();
		}
		return null;
	}

	/**
	 * publish service including wsdl file
	 * 
	 * @return
	 */
	public String publishService() {
		try {
			String businessKey = null;
			if ((businessKey = this.publish()) != null) {

				BusinessService myService = new BusinessService();
				SaveBusiness saveBusiness = new SaveBusiness();
				saveBusiness.setAuthInfo(getAuth());
								
				myService.setBusinessKey(businessKey);
				Name myServiceName = new Name();
				myServiceName.setValue(serviceName);
				myService.getName().add(myServiceName);

				// description
				Description serviceDesc = new Description();
				serviceDesc.setValue(serviceDescription);
				myService.getDescription().add(serviceDesc);

				// binding template
				BindingTemplates templates = new BindingTemplates();
				BindingTemplate bindingTemp = new BindingTemplate();
				bindingTemp.getDescription().add(serviceDesc);

				// set access point / wsdl file
				AccessPoint accessPoint = new AccessPoint();
				accessPoint.setUseType("wsdlDeployment");
				accessPoint.setValue(wsdlLocation);

				bindingTemp.setAccessPoint(accessPoint);
				templates.getBindingTemplate().add(bindingTemp);

				myService.setBindingTemplates(templates);
				
				SaveService ss = new SaveService();
				ss.getBusinessService().add(myService);
				ss.setAuthInfo(this.getAuth());
				ServiceDetail sd = publish.saveService(ss);
				String myServKey = sd.getBusinessService().get(0)
						.getServiceKey();

				return "plattform+ " + userName + " published";
			}
			return userName + " already published";
		} catch (DispositionReportFaultMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * return list of endpoints excluding us
	 * 
	 * @return
	 */
	public Map<String, String> getListofEndpoints() {

		FindBusiness fb = new FindBusiness();
		BusinessList bl = null;
		String serviceKey = null;
		Map<String, String> endpoints = new HashMap<String, String>();

		try {

			fb.setAuthInfo(this.getAuth());

			Name name = new Name();
			name.setValue("%");

			FindQualifiers fq = new FindQualifiers();
			fq.getFindQualifier().add(this.APPROXIMATE_MATCH);

			fb.getName().add(name);
			fb.setFindQualifiers(fq);

			// get all businesses
			bl = inquiry.findBusiness(fb);

			bl.getBusinessInfos().getBusinessInfo().iterator();
			for (int i = 0; i < bl.getBusinessInfos().getBusinessInfo().size(); i++) {

				if (bl != null
						&& bl.getBusinessInfos() != null
						&& bl.getBusinessInfos().getBusinessInfo().size() > 0
						&& bl.getBusinessInfos().getBusinessInfo().get(i)
								.getName().size() > 0) {
					String publisherName = bl.getBusinessInfos()
							.getBusinessInfo().get(i).getName().get(0)
							.getValue();

					if (publisherName.matches("gruppe\\s+[0-9]*\\s+publisher")) {
						// System.out.println(""+bl.getBusinessInfos().getBusinessInfo().get(i).getName().get(0).getValue());
						// System.out.println(publisherName);

						if (bl.getBusinessInfos().getBusinessInfo().get(i)
								.getServiceInfos() != null
								&& bl.getBusinessInfos().getBusinessInfo()
										.get(i).getServiceInfos()
										.getServiceInfo().size() > 0) {
							serviceKey = bl.getBusinessInfos()
									.getBusinessInfo().get(i).getServiceInfos()
									.getServiceInfo().get(0).getServiceKey();

							GetServiceDetail service = new GetServiceDetail();
							service.setAuthInfo(getAuth());
							service.getServiceKey().add(serviceKey);
							ServiceDetail serviceInfo = inquiry
									.getServiceDetail(service);
							List<BusinessService> services = serviceInfo
									.getBusinessService();
							if (services.size() > 0) {
								BusinessService bs = services.get(0);
								if (bs != null
										&& bs.getBindingTemplates() != null
										&& bs.getBindingTemplates()
												.getBindingTemplate().size() > 0
										&& bs.getBindingTemplates()
												.getBindingTemplate().get(0)
												.getAccessPoint() != null) {

									AccessPoint ap = bs.getBindingTemplates()
											.getBindingTemplate().get(0)
											.getAccessPoint();
									String wsdlFile = ap.getValue();

									if ((!wsdlFile.contains("localhost") && !wsdlFile.contains("GW01")  && !wsdlFile.contains("gr4") && !wsdlFile.contains("HL16") && !wsdlFile.contains("HL07"))
											&& (wsdlFile.contains("GW23") || wsdlFile.contains("GR14") || wsdlFile.contains("HL02") || wsdlFile.contains("HL10") ||
											wsdlFile.contains("GW11") || wsdlFile.contains("GW21"))) {
										if (!wsdlFile.contains("8090")) {
											if (!wsdlFile.endsWith("?wsdl"))
												wsdlFile = wsdlFile + "?wsdl";

											System.out
													.println("publisherName: "
															+ publisherName
															+ " " + wsdlFile);
											endpoints.put(publisherName,
													wsdlFile);
										}
									}
								}
							}
						}
					} // else
						// System.out.println("wrong " + publisherName);
				}

			}
			return endpoints;

		} catch (DispositionReportFaultMessage e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return endpoints;
	}
	
	/**
	 * get list of endpoints including us
	 * @return
	 */
	public Map<String, String> getListOfAllEndpoints() {

		FindBusiness fb = new FindBusiness();
		BusinessList bl = null;
		String serviceKey = null;
		Map<String, String> endpoints = new HashMap<String, String>();

		try {

			fb.setAuthInfo(this.getAuth());

			Name name = new Name();
			name.setValue("%");

			FindQualifiers fq = new FindQualifiers();
			fq.getFindQualifier().add(this.APPROXIMATE_MATCH);

			fb.getName().add(name);
			fb.setFindQualifiers(fq);

			// get all businesses
			bl = inquiry.findBusiness(fb);

			bl.getBusinessInfos().getBusinessInfo().iterator();
			for (int i = 0; i < bl.getBusinessInfos().getBusinessInfo().size(); i++) {

				if (bl != null
						&& bl.getBusinessInfos() != null
						&& bl.getBusinessInfos().getBusinessInfo().size() > 0
						&& bl.getBusinessInfos().getBusinessInfo().get(i)
								.getName().size() > 0) {
					String publisherName = bl.getBusinessInfos()
							.getBusinessInfo().get(i).getName().get(0)
							.getValue();

					if (publisherName.matches("gruppe\\s+[0-9]*\\s+publisher")) {
						// System.out.println(""+bl.getBusinessInfos().getBusinessInfo().get(i).getName().get(0).getValue());
						// System.out.println(publisherName);

						if (bl.getBusinessInfos().getBusinessInfo().get(i)
								.getServiceInfos() != null
								&& bl.getBusinessInfos().getBusinessInfo()
										.get(i).getServiceInfos()
										.getServiceInfo().size() > 0) {
							serviceKey = bl.getBusinessInfos()
									.getBusinessInfo().get(i).getServiceInfos()
									.getServiceInfo().get(0).getServiceKey();

							GetServiceDetail service = new GetServiceDetail();
							service.setAuthInfo(getAuth());
							service.getServiceKey().add(serviceKey);
							ServiceDetail serviceInfo = inquiry
									.getServiceDetail(service);
							List<BusinessService> services = serviceInfo
									.getBusinessService();
							if (services.size() > 0) {
								BusinessService bs = services.get(0);
								if (bs != null
										&& bs.getBindingTemplates() != null
										&& bs.getBindingTemplates()
												.getBindingTemplate().size() > 0
										&& bs.getBindingTemplates()
												.getBindingTemplate().get(0)
												.getAccessPoint() != null) {

									AccessPoint ap = bs.getBindingTemplates()
											.getBindingTemplate().get(0)
											.getAccessPoint();
									String wsdlFile = ap.getValue();

									if ((!wsdlFile.contains("localhost") && !wsdlFile.contains("gr4") && !wsdlFile.contains("HL16") && !wsdlFile.contains("HL07"))
											&& (wsdlFile.contains("GW23") || wsdlFile.contains("GR14") || wsdlFile.contains("HL02") || wsdlFile.contains("HL10") ||
													wsdlFile.contains("GW11") || wsdlFile.contains("GW21") || wsdlFile.contains("GW01"))) {
										if (!wsdlFile.contains("8090")) {
											if (!wsdlFile.endsWith("?wsdl"))
												wsdlFile = wsdlFile + "?wsdl";

											System.out
													.println("publisherName: "
															+ publisherName
															+ " " + wsdlFile);
											endpoints.put(publisherName,
													wsdlFile);
										}
									}
								}
							}
						}
					} // else
						// System.out.println("wrong " + publisherName);
				}

			}
			return endpoints;

		} catch (DispositionReportFaultMessage e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return endpoints;
	}

	public static void main(String[] args) {
		UddiApp app = new UddiApp();

		String plattformName = "gruppe4"; // for testing
		app.getWsdlFile(plattformName);

	}

	// returns plattform depending WSDL file
	public String getWsdlFile(String plattformName) {

		FindBusiness fb = new FindBusiness();
		Name name = new Name();
		name.setValue(plattformName);
		fb.getName().add(name);
		BusinessList bl = null;
		String serviceKey = null;
		String endpoint = null;
		try {
			bl = inquiry.findBusiness(fb);
			serviceKey = bl.getBusinessInfos().getBusinessInfo().get(0)
					.getServiceInfos().getServiceInfo().get(0).getServiceKey();

			GetServiceDetail service = new GetServiceDetail();
			service.setAuthInfo(getAuth());
			service.getServiceKey().add(serviceKey);
			ServiceDetail serviceInfo = inquiry.getServiceDetail(service);
			List<BusinessService> services = serviceInfo.getBusinessService();
			endpoint = null;
			if (services.size() > 0) {
				BusinessService bs = services.get(0);
				AccessPoint ap = bs.getBindingTemplates().getBindingTemplate()
						.get(0).getAccessPoint();
				endpoint = ap.getValue();
			}

		} catch (DispositionReportFaultMessage e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		// check, if "wsdl" is at the end
		if (!endpoint.endsWith("?wsdl"))
			endpoint = endpoint + "?wsdl";

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
