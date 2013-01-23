package at.jku.ce.ue.source;

import at.jku.ce.ue.source.entities.Database;

public class Init {
	
	static Database db;

	public Init() {
		db = new Database();
	}

	public static Database getDb() {
		return db;
	}

	public static void setDb(Database db) {
		Init.db = db;
	}


}
