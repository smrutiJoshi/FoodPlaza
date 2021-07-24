package in.sqaud.foodplaza.pojo;

public class Food {
	
	private int food_id,food_price;
	private String food_name,food_category;
	
	
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_price=" + food_price + ", food_name=" + food_name
				+ ", food_category=" + food_category + "]";
	}
	
	//Getters and setters
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_category() {
		return food_category;
	}
	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}

	

}
