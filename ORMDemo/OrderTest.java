package ORMDemo;

import java.util.List;

public class OrderTest {
	
	//测试
	public static void main(String[] args) {
		
		OrderTest ot=new OrderTest();
		Order order=ot.getOrderWithDetails(1);
		if(order!=null) {
			System.out.println(order);
			List<OrderDetail> list=order.getDetailList();
			
			for (OrderDetail orderDetail : list) {
				System.out.println("\t"+orderDetail);
			}
		}
		
	}
	
	
	//通过订单号获取订单信息及订单明细的信息
	public Order getOrderWithDetails(long id) {
		Order order=null;
		
		OrderJDBC oj=new OrderJDBC();
		OrderDetailJDBC odj=new OrderDetailJDBC();
		
		//查询订单
		order=oj.getOrder(id);
		//查询订单明细
		List<OrderDetail> list=odj.getDetails(id);
		//把明细设置到订单类中
		order.setDetailList(list);
		
		return order;
	}

}
