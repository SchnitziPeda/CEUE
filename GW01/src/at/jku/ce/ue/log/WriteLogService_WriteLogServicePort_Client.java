
package at.jku.ce.ue.log;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.4.9
 * 2013-01-08T20:38:23.488+01:00
 * Generated source version: 2.4.9
 * 
 */
public final class WriteLogService_WriteLogServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://ue.ce.jku.at/", "WriteLogServiceService");

    private WriteLogService_WriteLogServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WriteLogServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WriteLogServiceService ss = new WriteLogServiceService(wsdlURL, SERVICE_NAME);
        WriteLogService port = ss.getWriteLogServicePort();  
        
        {
        System.out.println("Invoking logInquiry...");
        java.lang.String _logInquiry_customerid = "_logInquiry_customerid1120237485";
        java.lang.String _logInquiry_producerid = "_logInquiry_producerid-393891072";
        java.lang.String _logInquiry_partid = "_logInquiry_partid1825097966";
        java.lang.String _logInquiry_inquiryid = "_logInquiry_inquiryid106855847";
        port.logInquiry(_logInquiry_customerid, _logInquiry_producerid, _logInquiry_partid, _logInquiry_inquiryid);


        }
        {
        System.out.println("Invoking logOffer...");
        java.lang.String _logOffer_customerid = "_logOffer_customerid1299245189";
        java.lang.String _logOffer_producerid = "_logOffer_producerid157447461";
        java.lang.String _logOffer_partid = "_logOffer_partid-719711500";
        int _logOffer_price = 757582601;
        java.lang.String _logOffer_inquiryid = "_logOffer_inquiryid1516014320";
        java.lang.String _logOffer_offerid = "_logOffer_offerid1651904691";
        port.logOffer(_logOffer_customerid, _logOffer_producerid, _logOffer_partid, _logOffer_price, _logOffer_inquiryid, _logOffer_offerid);


        }
        {
        System.out.println("Invoking logOrder...");
        java.lang.String _logOrder_customerid = "_logOrder_customerid346736441";
        java.lang.String _logOrder_producerid = "_logOrder_producerid721607696";
        java.lang.String _logOrder_partid = "_logOrder_partid184045199";
        int _logOrder_price = -1131635406;
        java.lang.String _logOrder_inquiryid = "_logOrder_inquiryid-1222774829";
        java.lang.String _logOrder_offerid = "_logOrder_offerid-832561017";
        java.lang.String _logOrder_orderid = "_logOrder_orderid1306638943";
        port.logOrder(_logOrder_customerid, _logOrder_producerid, _logOrder_partid, _logOrder_price, _logOrder_inquiryid, _logOrder_offerid, _logOrder_orderid);


        }

        System.exit(0);
    }

}
