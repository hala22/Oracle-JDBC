package ORMDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//订单明细与数据库的交互类
public class OrderDetailJDBC {
	
	public List<OrderDetail> getDetails(long orderId){
		
		List<OrderDetail> list=new ArrayList<>();
		Connection conn=ConnectionFactory.getConnection();
		
		String sql="SELECT id,order_id,product_id,price,quantity,cost"
				+"FROM t_order_detail WHERE order_id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setLong(1,orderId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				OrderDetail detail=new OrderDetail(rs.getLong(1),
						rs.getLong(2),rs.getLong(3),
						rs.getDouble(4),rs.getInt(5),
						rs.getDouble(6));
				list.add(detail);
			}
			
			DBUtils.close(rs,ps,conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
