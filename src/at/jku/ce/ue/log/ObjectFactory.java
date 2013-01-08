
package at.jku.ce.ue.log;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.jku.ce.ue.log package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LogOrderResponse_QNAME = new QName("http://ue.ce.jku.at/", "logOrderResponse");
    private final static QName _LogOrder_QNAME = new QName("http://ue.ce.jku.at/", "logOrder");
    private final static QName _LogInquiry_QNAME = new QName("http://ue.ce.jku.at/", "logInquiry");
    private final static QName _LogOfferResponse_QNAME = new QName("http://ue.ce.jku.at/", "logOfferResponse");
    private final static QName _LogInquiryResponse_QNAME = new QName("http://ue.ce.jku.at/", "logInquiryResponse");
    private final static QName _LogOffer_QNAME = new QName("http://ue.ce.jku.at/", "logOffer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.jku.ce.ue.log
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogOfferResponse }
     * 
     */
    public LogOfferResponse createLogOfferResponse() {
        return new LogOfferResponse();
    }

    /**
     * Create an instance of {@link LogInquiry }
     * 
     */
    public LogInquiry createLogInquiry() {
        return new LogInquiry();
    }

    /**
     * Create an instance of {@link LogOffer }
     * 
     */
    public LogOffer createLogOffer() {
        return new LogOffer();
    }

    /**
     * Create an instance of {@link LogInquiryResponse }
     * 
     */
    public LogInquiryResponse createLogInquiryResponse() {
        return new LogInquiryResponse();
    }

    /**
     * Create an instance of {@link LogOrderResponse }
     * 
     */
    public LogOrderResponse createLogOrderResponse() {
        return new LogOrderResponse();
    }

    /**
     * Create an instance of {@link LogOrder }
     * 
     */
    public LogOrder createLogOrder() {
        return new LogOrder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logOrderResponse")
    public JAXBElement<LogOrderResponse> createLogOrderResponse(LogOrderResponse value) {
        return new JAXBElement<LogOrderResponse>(_LogOrderResponse_QNAME, LogOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logOrder")
    public JAXBElement<LogOrder> createLogOrder(LogOrder value) {
        return new JAXBElement<LogOrder>(_LogOrder_QNAME, LogOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogInquiry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logInquiry")
    public JAXBElement<LogInquiry> createLogInquiry(LogInquiry value) {
        return new JAXBElement<LogInquiry>(_LogInquiry_QNAME, LogInquiry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOfferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logOfferResponse")
    public JAXBElement<LogOfferResponse> createLogOfferResponse(LogOfferResponse value) {
        return new JAXBElement<LogOfferResponse>(_LogOfferResponse_QNAME, LogOfferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogInquiryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logInquiryResponse")
    public JAXBElement<LogInquiryResponse> createLogInquiryResponse(LogInquiryResponse value) {
        return new JAXBElement<LogInquiryResponse>(_LogInquiryResponse_QNAME, LogInquiryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogOffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "logOffer")
    public JAXBElement<LogOffer> createLogOffer(LogOffer value) {
        return new JAXBElement<LogOffer>(_LogOffer_QNAME, LogOffer.class, null, value);
    }

}
