package jdbcDemo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {
	
	public static void main(String[] args) {
		
		Connection conn=ConnectionFactory.getConnection();
		
		PreparedStatement pstmt=null;
		int rs=0;
		
		try {
			
			String sql = "INSERT INTO t_user (id,username,password,sex,"
					+ "id_number,tel,addr) "
					+ "VALUES(t_user_id_seq.NEXTVAL,?,?,?,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "张三");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "男");
			pstmt.setInt(4, 001);
			pstmt.setLong(5,3544758);
			pstmt.setString(6, "Londen");
			
			
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBUtils.close(pstmt, conn);
	}

}
