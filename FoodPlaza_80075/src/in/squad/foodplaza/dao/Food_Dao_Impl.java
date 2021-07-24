package in.squad.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sqaud.foodplaza.pojo.Customer;
import in.sqaud.foodplaza.pojo.Food;
import in.squad.foodplaza.dbUtil.DbUtil;

public class Food_Dao_Impl implements Food_Dao {
	  Connection con;
	     PreparedStatement pstat;
	     int flag;
	     ResultSet rs;
	@Override
	public boolean Add_food(Food food) throws ClassNotFoundException, SQLException {
		
   con=DbUtil.getCon();
   
     pstat=con.prepareStatement("insert into Food_80075 (food_name,food_category,food_price) values(?,?,?)");
  //   pstat.setInt(1, food.getFood_id());
     pstat.setString(1, food.getFood_name());
     pstat.setString(2, food.getFood_category());
     pstat.setInt(3, food.getFood_price());
     
     flag=pstat.executeUpdate();
     if(flag!=0)
    	 return true;
     else
		return false;
	}

	@Override
	public boolean Update_food(Food food, int p) throws ClassNotFoundException, SQLException{
		
		  con=DbUtil.getCon();
		   
		     pstat=con.prepareStatement("update Food_80075 set food_name=?,food_category=?,food_price=? where food_id=?");
		 //    pstat.setInt(1, food.getFood_id());
		     pstat.setString(1, food.getFood_name());
		     pstat.setString(2, food.getFood_category());
		     pstat.setInt(3, food.getFood_price());
		     pstat.setInt(4,p);
		     
		     flag=pstat.executeUpdate();
		     if(flag!=0)
		    	 return true;
		     else
		    		return false;
	}

	@Override
	public boolean Delete_food(int id) throws ClassNotFoundException, SQLException{
		con=DbUtil.getCon();
		pstat=con.prepareStatement("Delete from Food_80075 where food_id=?");
		  pstat.setInt(1,id);
		  
		flag=pstat.executeUpdate();
		  if(flag!=0)
		         return true;
		         else
		        	 return false;
		
	}

	@Override
	public List<Food> getAllFood() throws ClassNotFoundException, SQLException{
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Food_80075 ");
       rs=pstat.executeQuery();
       List<Food> li= new ArrayList();
       while(rs.next()) {
    	  Food f= new Food();
    	  f.setFood_id(rs.getInt(1));
    	  f.setFood_name(rs.getString(2));
    	  f.setFood_category(rs.getString(3));
    	  f.setFood_price(rs.getInt(4));
    	   li.add(f);
    	   
       }
       return li;
	}

	@Override
	public Food SearchById(int id)throws ClassNotFoundException, SQLException {
		con=DbUtil.getCon();
		pstat=con.prepareStatement("select * from Food_80075 where food_id=?");
		pstat.setInt(1, id);
		rs=pstat.executeQuery();
		
	Food f= new Food();
	while(rs.next()) {
		f.setFood_id(rs.getInt(1));
		  f.setFood_name(rs.getString(2));
    	  f.setFood_category(rs.getString(3));
    	  f.setFood_price(rs.getInt(4));
	}
		return f;
	}
	@Override
	public List<Food> searchFood(String name) throws ClassNotFoundException, SQLException {
		
		List<Food>foodlist = new ArrayList<>();
		con = DbUtil.getCon();
		pstat = con.prepareStatement("Select * from Food_80075 where food_name like ?");
	
		pstat.setString(1,"%"+name+"%");
		
		rs = pstat.executeQuery();
		
		while(rs.next()) {
			
			Food food = new Food();
			
			food.setFood_id(rs.getInt("food_id"));
			food.setFood_name(rs.getString("food_name"));
			food.setFood_category(rs.getString("food_category"));
			food.setFood_price(rs.getInt("food_price"));
			
			foodlist.add(food);
			
		}
	
		return foodlist;
	}


}
