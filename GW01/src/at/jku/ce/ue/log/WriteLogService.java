package at.jku.ce.ue.log;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.9
 * 2013-01-08T20:38:23.581+01:00
 * Generated source version: 2.4.9
 * 
 */
@WebService(targetNamespace = "http://ue.ce.jku.at/", name = "WriteLogService")
@XmlSeeAlso({ObjectFactory.class})
public interface WriteLogService {

    @RequestWrapper(localName = "logInquiry", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogInquiry")
    @WebMethod(action = "urn:LogInquiry")
    @ResponseWrapper(localName = "logInquiryResponse", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogInquiryResponse")
    public void logInquiry(
        @WebParam(name = "customerid", targetNamespace = "")
        java.lang.String customerid,
        @WebParam(name = "producerid", targetNamespace = "")
        java.lang.String producerid,
        @WebParam(name = "partid", targetNamespace = "")
        java.lang.String partid,
        @WebParam(name = "inquiryid", targetNamespace = "")
        java.lang.String inquiryid
    );

    @RequestWrapper(localName = "logOffer", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogOffer")
    @WebMethod(action = "urn:LogOffer")
    @ResponseWrapper(localName = "logOfferResponse", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogOfferResponse")
    public void logOffer(
        @WebParam(name = "customerid", targetNamespace = "")
        java.lang.String customerid,
        @WebParam(name = "producerid", targetNamespace = "")
        java.lang.String producerid,
        @WebParam(name = "partid", targetNamespace = "")
        java.lang.String partid,
        @WebParam(name = "price", targetNamespace = "")
        int price,
        @WebParam(name = "inquiryid", targetNamespace = "")
        java.lang.String inquiryid,
        @WebParam(name = "offerid", targetNamespace = "")
        java.lang.String offerid
    );

    @RequestWrapper(localName = "logOrder", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogOrder")
    @WebMethod(action = "urn:LogOrder")
    @ResponseWrapper(localName = "logOrderResponse", targetNamespace = "http://ue.ce.jku.at/", className = "at.jku.ce.ue.log.LogOrderResponse")
    public void logOrder(
        @WebParam(name = "customerid", targetNamespace = "")
        java.lang.String customerid,
        @WebParam(name = "producerid", targetNamespace = "")
        java.lang.String producerid,
        @WebParam(name = "partid", targetNamespace = "")
        java.lang.String partid,
        @WebParam(name = "price", targetNamespace = "")
        int price,
        @WebParam(name = "inquiryid", targetNamespace = "")
        java.lang.String inquiryid,
        @WebParam(name = "offerid", targetNamespace = "")
        java.lang.String offerid,
        @WebParam(name = "orderid", targetNamespace = "")
        java.lang.String orderid
    );
}
