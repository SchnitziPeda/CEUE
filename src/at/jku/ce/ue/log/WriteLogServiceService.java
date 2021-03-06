package at.jku.ce.ue.log;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.9
 * 2013-01-08T20:38:23.597+01:00
 * Generated source version: 2.4.9
 * 
 */
@WebServiceClient(name = "WriteLogServiceService", 
                  wsdlLocation = "http://140.78.73.87:8090/ACServices/services/WriteLogServicePort?wsdl",
                  targetNamespace = "http://ue.ce.jku.at/") 
public class WriteLogServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ue.ce.jku.at/", "WriteLogServiceService");
    public final static QName WriteLogServicePort = new QName("http://ue.ce.jku.at/", "WriteLogServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://140.78.73.87:8090/ACServices/services/WriteLogServicePort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WriteLogServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://140.78.73.87:8090/ACServices/services/WriteLogServicePort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WriteLogServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WriteLogServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WriteLogServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns WriteLogService
     */
    @WebEndpoint(name = "WriteLogServicePort")
    public WriteLogService getWriteLogServicePort() {
        return super.getPort(WriteLogServicePort, WriteLogService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WriteLogService
     */
    @WebEndpoint(name = "WriteLogServicePort")
    public WriteLogService getWriteLogServicePort(WebServiceFeature... features) {
        return super.getPort(WriteLogServicePort, WriteLogService.class, features);
    }

}
