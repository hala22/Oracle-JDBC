package JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	
	//针对增删改的封装
	public int update(String sql,PreparedStatementSetter setter) {
		int rows=0;
		//1,2
		Connection conn=ConnectionFactory.getConnection();
		
		try {
			//3,4
			PreparedStatement ps=conn.prepareStatement(sql);
			//设置占位符的值
			if(setter!=null) {
				setter.setValues(ps);
			}
			//5,执行
			rows=ps.executeUpdate();
			//6
			DBUtils.close(ps, conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	
	//查询
	public void query(String sql,
			PreparedStatementSetter setter,
			ResultSetHandler handler) throws SQLException {
		//1,2
		Connection conn = ConnectionFactory.getConnection();
		//3
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//4
		if(setter!=null) {
			setter.setValues(pstmt);
		}
		ResultSet rs = pstmt.executeQuery();
		//5.处理结果集
		if(handler!=null) {
			handler.handleRS(rs);
		}
		//6.
		DBUtils.close(rs, pstmt, conn);
	}


}
