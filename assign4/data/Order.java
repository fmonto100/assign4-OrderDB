package data;

public class Order {
	private String orderId;
	private String customerName;
	private String productName;
	private double totalAmount;
	
	public Order(String orderId, String customerName,String productName, double totalAmount) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
		this.totalAmount = totalAmount;
}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}



