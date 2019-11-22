package by.htp.ts._java._se_07_connectionpool.connectionpool.dbparameters;

import java.util.ResourceBundle;

public class DBResourceManager {
	private final static DBResourceManager instances = new DBResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("resources.db");
	
	public static DBResourceManager getInstance(){
		return instances;
	}
	public String getValue(String key){
		return bundle.getString(key);		
	}
	
}
