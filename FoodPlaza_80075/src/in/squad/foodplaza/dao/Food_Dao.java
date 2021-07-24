package in.squad.foodplaza.dao;

import java.sql.SQLException;
import java.util.List;

import in.sqaud.foodplaza.pojo.Food;

public interface Food_Dao {
	boolean Add_food(Food food) throws ClassNotFoundException, SQLException;
	boolean Update_food(Food food,int p)throws ClassNotFoundException, SQLException;
	boolean Delete_food(int id)throws ClassNotFoundException, SQLException;
	List<Food>getAllFood()throws ClassNotFoundException, SQLException;
	Food SearchById(int id)throws ClassNotFoundException, SQLException;
	List<Food> searchFood(String name) throws ClassNotFoundException, SQLException;

}
