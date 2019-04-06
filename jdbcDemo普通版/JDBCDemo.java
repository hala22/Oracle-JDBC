package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	public static void main(String[] args) {
		JDBCDemo demo=new JDBCDemo();
		
		try {
			demo.queryUser();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void queryUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"easybuy",
				"easybuy");
		
		
		Statement stmt=conn.createStatement();
		
		String sql="SELECT id,username,password,sex FROM t_user";
		
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println(rs.getLong(1)+"\t"
				+rs.getString(2)+"\t"
				+rs.getString(3)+"\t"
				+rs.getString(4)+"\t");
		
		if(rs!=null) {
			rs.close();
		}
		
		if(stmt!=null) {
			stmt.close();
		}
		
		if(conn!=null) {
			conn.close();
		}
	}

}
