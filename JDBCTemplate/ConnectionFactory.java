package JDBCTemplate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//第一二步，连接工厂
public class ConnectionFactory {
	
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String USERPASSWORD;
	
	static {
		Properties prop=new Properties();
		
		try {
			prop.load(ConnectionFactory.class.
					getResourceAsStream("jdbc.properties"));
			
			DRIVER=prop.getProperty("driver");
			URL=prop.getProperty("url");
			USERNAME=prop.getProperty("username");
			USERPASSWORD=prop.getProperty("userpassword");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			
			conn=DriverManager.getConnection(URL,USERNAME,USERPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
