package ORMDemo;

//订单明细类
public class OrderDetail {
	
	private long id;
	private long orderId;
	private long productId;
	private double price;
	private int quantity;
	private double cost;
	
	
	public OrderDetail() {
		super();
	}


	public OrderDetail(long id, long orderId, long productId, double price, int quantity, double cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.cost = cost;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", price=" + price
				+ ", quantity=" + quantity + ", cost=" + cost + "]";
	}
	
	

}
