
package at.jku.ce.ue.bom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.jku.ce.ue.bom package. 
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

    private final static QName _GetAllPartsResponse_QNAME = new QName("http://ue.ce.jku.at/", "getAllPartsResponse");
    private final static QName _SetDirectSubPartsOf_QNAME = new QName("http://ue.ce.jku.at/", "setDirectSubPartsOf");
    private final static QName _GetAllParts_QNAME = new QName("http://ue.ce.jku.at/", "getAllParts");
    private final static QName _GetDirectSubPartsOfResponse_QNAME = new QName("http://ue.ce.jku.at/", "getDirectSubPartsOfResponse");
    private final static QName _SetDirectSubPartsOfResponse_QNAME = new QName("http://ue.ce.jku.at/", "setDirectSubPartsOfResponse");
    private final static QName _GetDirectSubPartsOf_QNAME = new QName("http://ue.ce.jku.at/", "getDirectSubPartsOf");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.jku.ce.ue.bom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetDirectSubPartsOfResponse }
     * 
     */
    public SetDirectSubPartsOfResponse createSetDirectSubPartsOfResponse() {
        return new SetDirectSubPartsOfResponse();
    }

    /**
     * Create an instance of {@link GetDirectSubPartsOfResponse }
     * 
     */
    public GetDirectSubPartsOfResponse createGetDirectSubPartsOfResponse() {
        return new GetDirectSubPartsOfResponse();
    }

    /**
     * Create an instance of {@link GetDirectSubPartsOf }
     * 
     */
    public GetDirectSubPartsOf createGetDirectSubPartsOf() {
        return new GetDirectSubPartsOf();
    }

    /**
     * Create an instance of {@link SetDirectSubPartsOf }
     * 
     */
    public SetDirectSubPartsOf createSetDirectSubPartsOf() {
        return new SetDirectSubPartsOf();
    }

    /**
     * Create an instance of {@link GetAllPartsResponse }
     * 
     */
    public GetAllPartsResponse createGetAllPartsResponse() {
        return new GetAllPartsResponse();
    }

    /**
     * Create an instance of {@link GetAllParts }
     * 
     */
    public GetAllParts createGetAllParts() {
        return new GetAllParts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPartsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllPartsResponse")
    public JAXBElement<GetAllPartsResponse> createGetAllPartsResponse(GetAllPartsResponse value) {
        return new JAXBElement<GetAllPartsResponse>(_GetAllPartsResponse_QNAME, GetAllPartsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirectSubPartsOf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "setDirectSubPartsOf")
    public JAXBElement<SetDirectSubPartsOf> createSetDirectSubPartsOf(SetDirectSubPartsOf value) {
        return new JAXBElement<SetDirectSubPartsOf>(_SetDirectSubPartsOf_QNAME, SetDirectSubPartsOf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllParts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getAllParts")
    public JAXBElement<GetAllParts> createGetAllParts(GetAllParts value) {
        return new JAXBElement<GetAllParts>(_GetAllParts_QNAME, GetAllParts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectSubPartsOfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getDirectSubPartsOfResponse")
    public JAXBElement<GetDirectSubPartsOfResponse> createGetDirectSubPartsOfResponse(GetDirectSubPartsOfResponse value) {
        return new JAXBElement<GetDirectSubPartsOfResponse>(_GetDirectSubPartsOfResponse_QNAME, GetDirectSubPartsOfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirectSubPartsOfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "setDirectSubPartsOfResponse")
    public JAXBElement<SetDirectSubPartsOfResponse> createSetDirectSubPartsOfResponse(SetDirectSubPartsOfResponse value) {
        return new JAXBElement<SetDirectSubPartsOfResponse>(_SetDirectSubPartsOfResponse_QNAME, SetDirectSubPartsOfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectSubPartsOf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ue.ce.jku.at/", name = "getDirectSubPartsOf")
    public JAXBElement<GetDirectSubPartsOf> createGetDirectSubPartsOf(GetDirectSubPartsOf value) {
        return new JAXBElement<GetDirectSubPartsOf>(_GetDirectSubPartsOf_QNAME, GetDirectSubPartsOf.class, null, value);
    }

}
