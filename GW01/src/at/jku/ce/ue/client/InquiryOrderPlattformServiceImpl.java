
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package at.jku.ce.ue.client;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.4.9
 * 2013-01-08T20:35:59.764+01:00
 * Generated source version: 2.4.9
 * 
 */

@javax.jws.WebService(
                      serviceName = "InquiryOrderPlattformServiceService",
                      portName = "InquiryOrderPlattformServicePort",
                      targetNamespace = "http://ue.ce.jku.at/",
                      wsdlLocation = "http://localhost:8080/GW01/services/InquiryOrderPlattformServicePort?wsdl",
                      endpointInterface = "at.jku.ce.ue.client.InquiryOrderPlattformService")
                      
public class InquiryOrderPlattformServiceImpl implements InquiryOrderPlattformService {

    private static final Logger LOG = Logger.getLogger(InquiryOrderPlattformServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#getPrice(java.lang.String  customerid ,)java.lang.String  producerid ,)java.lang.String  partid ,)java.lang.String  inquiryid )*
     */
    public int getPrice(java.lang.String customerid,java.lang.String producerid,java.lang.String partid,java.lang.String inquiryid) { 
        LOG.info("Executing operation getPrice");
        System.out.println(customerid);
        System.out.println(producerid);
        System.out.println(partid);
        System.out.println(inquiryid);
        try {
            int _return = -1603630566;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#getAllPartsByProducer(java.lang.String  producerid )*
     */
    public java.util.List<java.lang.String> getAllPartsByProducer(java.lang.String producerid) { 
        LOG.info("Executing operation getAllPartsByProducer");
        System.out.println(producerid);
        try {
            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnVal1 = "_returnVal1766754543";
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#getAllPartsOnPlattform(*
     */
    public java.util.List<java.lang.String> getAllPartsOnPlattform() { 
        LOG.info("Executing operation getAllPartsOnPlattform");
        try {
            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnVal1 = "_returnVal-1104698360";
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#getAllProducersForPart(java.lang.String  partid )*
     */
    public java.util.List<java.lang.String> getAllProducersForPart(java.lang.String partid) { 
        LOG.info("Executing operation getAllProducersForPart");
        System.out.println(partid);
        try {
            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnVal1 = "_returnVal-429660171";
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#placeOrder(java.lang.String  customerid ,)java.lang.String  producerid ,)java.lang.String  partid ,)java.lang.String  inquiryid ,)int  price ,)java.lang.String  orderid )*
     */
    public void placeOrder(java.lang.String customerid,java.lang.String producerid,java.lang.String partid,java.lang.String inquiryid,int price,java.lang.String orderid) { 
        LOG.info("Executing operation placeOrder");
        System.out.println(customerid);
        System.out.println(producerid);
        System.out.println(partid);
        System.out.println(inquiryid);
        System.out.println(price);
        System.out.println(orderid);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.client.InquiryOrderPlattformService#getAllProducersOnPlattform(*
     */
    public java.util.List<java.lang.String> getAllProducersOnPlattform() { 
        LOG.info("Executing operation getAllProducersOnPlattform");
        try {
            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnVal1 = "_returnVal-424938849";
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
