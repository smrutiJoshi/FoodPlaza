package in.sqaud.foodplaza.pojo;

public class Order {
	private int order_id;
	private String cust_email, order_date;
	private double total_bill;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public double getTotal_bill() {
		return total_bill;
	}
	public void setTotal_bill(double total_bill) {
		this.total_bill = total_bill;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cust_email=" + cust_email + ", order_date=" + order_date
				+ ", total_bill=" + total_bill + "]";
	}

}
