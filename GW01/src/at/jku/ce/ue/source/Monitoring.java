package at.jku.ce.ue.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Monitoring {

	private static final String connectionUrl = "jdbc:mysql://140.78.73.87:3306/";
	private static final String username = "uece";
	private static final String password = "2012WSceue";
	private static final String tableName = "log_ws2012";
	private static final String dbName = "monitoringDB";
	public static Connection conn;

	public Monitoring() {
		this.establishConnection();
	}

	private void establishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(connectionUrl + dbName,
					username, password);
			System.out.print("connected to database");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
			System.out.print("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public ResultSet getAllData() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("Select * from " + tableName
					+ " Limit 30");
			// System.out.print(ps.toString());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getAllDataForProducer(String producerName) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("Select * from " + tableName
					+ " Where producerID LIKE '" + producerName+"'");
			// System.out.print(ps.toString());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * return calculated prices 
	 * @param producerName
	 * @return
	 */
	public ResultSet getCalculatedOrders(String producerName){
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("SELECT customerid, sum(price) as price FROM "+tableName
					+ " WHERE producerID='"+producerName+"' GROUP BY customerID");
			rs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return rs; 
	}
	



}
