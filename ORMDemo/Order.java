package ORMDemo;

import java.sql.Date;
import java.util.List;

//订单类
public class Order {
	
	private long id;
	private long userId;
	private Date orderDate;
	private String name;
	private String  tel;
	private String addr;
	private int status;
	private List<OrderDetail> detailList;
	
	
	public Order() {
		super();
	}


	public Order(long id, long userId, Date orderDate, String name, String tel, String addr, int status) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderDate = orderDate;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.status = status;
	}
	
	


	public List<OrderDetail> getDetailList() {
		return detailList;
	}


	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderDate=" + orderDate + ", name=" + name + ", tel=" + tel
				+ ", addr=" + addr + ", status=" + status + "]";
	}
	
	
	

}
