package in.sqaud.foodplaza.pojo;

public class Cart {
private int cart_id, food_id, quantity, food_price;
private String cust_email,food_name;
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}
public int getFood_id() {
	return food_id;
}
public void setFood_id(int food_id) {
	this.food_id = food_id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getFood_price() {
	return food_price;
}
public void setFood_price(int food_price) {
	this.food_price = food_price;
}
public String getCust_email() {
	return cust_email;
}
public void setCust_email(String cust_email) {
	this.cust_email = cust_email;
}
public String getFood_name() {
	return food_name;
}
public void setFood_name(String food_name) {
	this.food_name = food_name;
}
@Override
public String toString() {
	return "Cart [cart_id=" + cart_id + ", food_id=" + food_id + ", quantity=" + quantity + ", food_price=" + food_price
			+ ", cust_email=" + cust_email + ", food_name=" + food_name + "]";
}

}
