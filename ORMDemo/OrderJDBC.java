package ORMDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//订单类与数据库的交互，得到订单类对象
public class OrderJDBC {
	
	public Order getOrder(long id) {
		
		Order order=null;
		Connection conn=ConnectionFactory.getConnection();
		
		String sql="SELECT id,user_id,orderDate,name,tel,addr,status"
				+"FROM t_order WHERE id=?";
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				order=new Order(rs.getLong(1),
						rs.getLong(2),
						rs.getDate(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7));
				
			}
			
			DBUtils.close(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return order;
		
		
	}

}
