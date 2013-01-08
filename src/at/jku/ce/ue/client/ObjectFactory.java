
package at.jku.ce.ue.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.jku.ce.ue.client package. 
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

    private final static QName _GetAllPartsOnPlattform_QNAME = new QName("http://ue.ce.jku.at/", "getAllPartsOnPlattform");
    private final static QName _PlaceOrderResponse_QNAME = new QName("http://ue.ce.jku.at/", "placeOrderResponse");
    private final static QName _GetAllPartsByProducerResponse_QNAME = new QName("http://ue.ce.jku.at/", "getAllPartsByProducerResponse");
    private final static QName _GetAllProducersOnPlattformResponse_QNAME = new QName("http://ue.ce.jku.at/", "getAllProducersOnPlattformResponse");
    private final static QName _GetAllProducersOnPlattform_QNAME = new QName("http://ue.ce.jku.at/", "getAllProducersOnPlattform");
    private final static QName _GetAllProducersForPartResponse_QNAME = new QName("http://ue.ce.jku.at/", "getAllProducersForPartResponse");
    private final static QName _GetAllPartsOnPlattformResponse_QNAME = new QName("http://ue.ce.jku.at/", "getAllPartsOnPlattformResponse");
    private final static QName _GetPriceResponse_QNAME = new QName("http://ue.ce.jku.at/", "getPriceResponse");
    private final static QName _PlaceOrder_QNAME = new QName("http://ue.ce.jku.at/", "placeOrder");
    private final static QName _GetAllPartsByProducer_QNAME = new QName("http://ue.ce.jku.at/", "getAllPartsByProducer");
    private final static QName _GetAllProducersForPart_QNAME = new QName("http://ue.ce.jku.at/", "getAllProducersForPart");
    private final static QName _GetPrice_QNAME = new QName("http://ue.ce.jku.at/", "getPrice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.jku.ce.ue.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllProducersForPartResponse }
     * 
     */
    public GetAllProducersForPartResponse createGetAllProducersForPartResponse() {
        return new GetAllProducersForPartResponse();
    }

    /**
     * Create an instance of {@link GetPriceResponse }
     * 
     */
    public GetPriceResponse createGetPriceResponse() {
        return new GetPriceResponse();
    }

    /**
     * Create an instance of {@link GetAllPartsOnPlattformResponse }
     * 
     */
    public GetAllPartsOnPlattformResponse createGetAllPartsOnPlattformResponse() {
        return new GetAllPartsOnPlattformResponse();
    }

    /**
     * Create an instance of {@link PlaceOrder }
     * 
     */
    public PlaceOrder createPlaceOrder() {
        return new PlaceOrder();
    }

    /**
     * Create an instance of {@link GetAllPartsByProducer }
     * 
     */
    public GetAllPartsByProducer createGetAllPartsByProducer() {
        return new GetAllPartsByProducer();
    }

    /**
     * Create an instance of {@link GetAllProducersForPart }
     * 
     */
    public GetAllProducersForPart createGetAllProducersForPart() {
        return new GetAllProducersForPart();
    }

    /**
     * Create an instance of {@link GetPrice }
     * 
     */
    public GetPrice createGetPrice() {
        return new GetPrice();
    }

    /**
     * Create an instance of {@link GetAllPartsOnPlattform }
     * 
     */
    public GetAllPartsOnPlattform createGetAllPartsOnPlattform() {
        return new GetAllPartsOnPlattform();
    }

    /**
     * Create an instance of {@link PlaceOrderResponse }
     * 
     */
    public PlaceOrderResponse createPlaceOrderResponse() {
        return new PlaceOrderResponse();
    }

    /**
     * Create an instance of {@link GetAllProducersOnPlattformResponse }
     * 
     */
    public GetAllProducersOnPlattformResponse createGetAllProducersOnPlattformResponse() {
        return new GetAllProducersOnPlattformResponse();
    }

    /**
     * Create an instance of {@link GetAllPartsByProducerResponse }
     * 
     */
    public GetAllPartsByProducerResponse createGetAllPartsByProducerResponse() {
        return new GetAllPartsByProducerResponse();
    }

    /**
     * Create an instance of {@link GetAllProducersOnPlattform }
     * 
     */
    public GetAllProducersOnPlattform createGetAllProducersOnPlattform() {
        return new GetAllProducersOnPlattform();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartsOnPlattform }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllPartsOnPlattform")
    public JAXBElement<GetAllPartsOnPlattform> createGetAllPartsOnPlattform(GetAllPartsOnPlattform value) {
        return new JAXBElement<GetAllPartsOnPlattform>(_GetAllPartsOnPlattform_QNAME, GetAllPartsOnPlattform.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "placeOrderResponse")
    public JAXBElement<PlaceOrderResponse> createPlaceOrderResponse(PlaceOrderResponse value) {
        return new JAXBElement<PlaceOrderResponse>(_PlaceOrderResponse_QNAME, PlaceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartsByProducerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllPartsByProducerResponse")
    public JAXBElement<GetAllPartsByProducerResponse> createGetAllPartsByProducerResponse(GetAllPartsByProducerResponse value) {
        return new JAXBElement<GetAllPartsByProducerResponse>(_GetAllPartsByProducerResponse_QNAME, GetAllPartsByProducerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducersOnPlattformResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllProducersOnPlattformResponse")
    public JAXBElement<GetAllProducersOnPlattformResponse> createGetAllProducersOnPlattformResponse(GetAllProducersOnPlattformResponse value) {
        return new JAXBElement<GetAllProducersOnPlattformResponse>(_GetAllProducersOnPlattformResponse_QNAME, GetAllProducersOnPlattformResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducersOnPlattform }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllProducersOnPlattform")
    public JAXBElement<GetAllProducersOnPlattform> createGetAllProducersOnPlattform(GetAllProducersOnPlattform value) {
        return new JAXBElement<GetAllProducersOnPlattform>(_GetAllProducersOnPlattform_QNAME, GetAllProducersOnPlattform.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducersForPartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllProducersForPartResponse")
    public JAXBElement<GetAllProducersForPartResponse> createGetAllProducersForPartResponse(GetAllProducersForPartResponse value) {
        return new JAXBElement<GetAllProducersForPartResponse>(_GetAllProducersForPartResponse_QNAME, GetAllProducersForPartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartsOnPlattformResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllPartsOnPlattformResponse")
    public JAXBElement<GetAllPartsOnPlattformResponse> createGetAllPartsOnPlattformResponse(GetAllPartsOnPlattformResponse value) {
        return new JAXBElement<GetAllPartsOnPlattformResponse>(_GetAllPartsOnPlattformResponse_QNAME, GetAllPartsOnPlattformResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getPriceResponse")
    public JAXBElement<GetPriceResponse> createGetPriceResponse(GetPriceResponse value) {
        return new JAXBElement<GetPriceResponse>(_GetPriceResponse_QNAME, GetPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "placeOrder")
    public JAXBElement<PlaceOrder> createPlaceOrder(PlaceOrder value) {
        return new JAXBElement<PlaceOrder>(_PlaceOrder_QNAME, PlaceOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartsByProducer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllPartsByProducer")
    public JAXBElement<GetAllPartsByProducer> createGetAllPartsByProducer(GetAllPartsByProducer value) {
        return new JAXBElement<GetAllPartsByProducer>(_GetAllPartsByProducer_QNAME, GetAllPartsByProducer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducersForPart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllProducersForPart")
    public JAXBElement<GetAllProducersForPart> createGetAllProducersForPart(GetAllProducersForPart value) {
        return new JAXBElement<GetAllProducersForPart>(_GetAllProducersForPart_QNAME, GetAllProducersForPart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getPrice")
    public JAXBElement<GetPrice> createGetPrice(GetPrice value) {
        return new JAXBElement<GetPrice>(_GetPrice_QNAME, GetPrice.class, null, value);
    }

}
