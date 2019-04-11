package persistence.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCManager {

    private static JDBCManager INSTANCE = null;
    private static Connection connection;
    
    private JDBCManager(){
    	
    }
    
    public static JDBCManager getInstance(){  
    	if(INSTANCE == null) {
    		INSTANCE = new JDBCManager();
    	}
    	return INSTANCE;
    }	    
    
    public Connection openConection() throws Exception {
    	CfgManager cfg = CfgManager.getInstance();
    	Class.forName(cfg.getCfg().getProperty("driverName"));	
		String url = cfg.getCfg().getProperty("url");
		String user = cfg.getCfg().getProperty("user");
		String password = cfg.getCfg().getProperty("password");
		
		connection =  DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
    public void closeConnection() throws SQLException {
			connection.close();
	}
}
