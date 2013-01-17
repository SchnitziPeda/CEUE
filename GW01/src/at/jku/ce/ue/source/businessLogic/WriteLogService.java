package at.jku.ce.ue.source.businessLogic;

public interface WriteLogService {

	public void logInquiry(String customerid, String producerid, String partid, String inquiryid);
	
	public void logOffer(String customerid, String producerid, String partid, String price, String inquiryid, String offerid);
	
	public void logOrder(String customerid, String producerid, String partid, String price, String inquiryid, String orderid, String offerid);
	
}     