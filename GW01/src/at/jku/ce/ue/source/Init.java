package at.jku.ce.ue.source;

import at.jku.ce.ue.source.entities.Database;

public class Init {
	
	static Database db;
	static UddiRegistration uddiReg;

	public Init() {
		db = new Database();
		uddiReg = new UddiRegistration();
		
//		uddiReg.generateListOfPlattforms();
	}

	public static Database getDb() {
		return db;
	}

	public static void setDb(Database db) {
		Init.db = db;
	}

	public static UddiRegistration getUddiReg() {
		return uddiReg;
	}

	public static void setUddiReg(UddiRegistration uddiReg) {
		Init.uddiReg = uddiReg;
	}


}
