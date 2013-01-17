
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package at.jku.ce.ue.service;

import java.util.List;
import java.util.logging.Logger;

import at.jku.ce.ue.source.businessLogic.SupplierService;
import at.jku.ce.ue.source.businessLogic.impl.PartServiceImpl;
import at.jku.ce.ue.source.businessLogic.impl.SupplierServiceImpl;

/**
 * This class was generated by Apache CXF 2.4.9
 * 2013-01-08T20:34:27.205+01:00
 * Generated source version: 2.4.9
 * 
 */

@javax.jws.WebService(
                      serviceName = "InquiryOrderPlattformServiceService",
                      portName = "InquiryOrderPlattformServicePort",
                      targetNamespace = "http://ue.ce.jku.at/",
                      wsdlLocation = "http://140.78.73.87:8090/ACServices/services/InquiryOrderPlattformServicePort?wsdl",
                      endpointInterface = "at.jku.ce.ue.service.InquiryOrderPlattformService")
                      
public class InquiryOrderPlattformServiceImpl implements InquiryOrderPlattformService {

    private static final Logger LOG = Logger.getLogger(InquiryOrderPlattformServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#getPrice(java.lang.String  customerid ,)java.lang.String  producerid ,)java.lang.String  partid ,)java.lang.String  inquiryid )*
     */
    public int getPrice(java.lang.String customerid,java.lang.String producerid,java.lang.String partid,java.lang.String inquiryid) { 
        LOG.info("Executing operation getPrice");
        System.out.println(customerid);
        System.out.println(producerid);
        System.out.println(partid);
        System.out.println(inquiryid);
        try {
            int _return = 818061312;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#getAllPartsByProducer(java.lang.String  producerid )*
     */
    public java.util.List<java.lang.String> getAllPartsByProducer(java.lang.String producerid) { 
        LOG.info("Executing operation getAllPartsByProducer");
        System.out.println(producerid);
        try {
        	
        	PartServiceImpl partService = new PartServiceImpl();
        	return partService.getAllPartsByProducer(producerId);
        	
        	
        	
//        	java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
//            java.lang.String _returnVal1 = "_returnVal1993362333";
//            _return.add(_returnVal1);
//            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#getAllPartsOnPlattform(*
     */
    public java.util.List<java.lang.String> getAllPartsOnPlattform() { 
        LOG.info("Executing operation getAllPartsOnPlattform");
        try {
        	
        	PartServiceImpl partService = new PartServiceImpl();
        	return partService.getAllPartNames();
//        	
//            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
//            java.lang.String _returnVal1 = "_returnVal336555682";
//            _return.add(_returnVal1);
//            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#getAllProducersForPart(java.lang.String  partid )*
     */
    public java.util.List<java.lang.String> getAllProducersForPart(java.lang.String partid) { 
        LOG.info("Executing operation getAllProducersForPart");
        System.out.println(partid);
        try {
        	
        	SupplierServiceImpl supService = new SupplierServiceImpl();
        	return supService.getAllProducersForPart(partid);

//            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
//            java.lang.String _returnVal1 = "_returnVal911775315";
//            _return.add(_returnVal1);
//            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#placeOrder(java.lang.String  customerid ,)java.lang.String  producerid ,)java.lang.String  partid ,)java.lang.String  inquiryid ,)int  price ,)java.lang.String  orderid )*
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
     * @see at.jku.ce.ue.service.InquiryOrderPlattformService#getAllProducersOnPlattform(*
     */
    public java.util.List<java.lang.String> getAllProducersOnPlattform() { 
        LOG.info("Executing operation getAllProducersOnPlattform");
        try {
        	
        	SupplierService supplService = new SupplierServiceImpl();
        	List<String> producers = supplService.getAllProducerNames();
        	return producers;
        	
//            java.util.List<java.lang.String> _return = new java.util.ArrayList<java.lang.String>();
//            java.lang.String _returnVal1 = "_returnVal-1487149130";
//            _return.add(_returnVal1);
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
