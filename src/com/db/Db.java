package com.db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.models.*;

import javax.servlet.RequestDispatcher;
public class Db {
	
	
	Connection con=null;
	public Db() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","q1234");
			
		}catch(Exception e) {
			
			e.printStackTrace();
	
		}
		
	}
	
	public boolean addRecord(String name,float price,String desc) throws SQLException {
		
		
		PreparedStatement statement = con.prepareStatement("insert into fooditems(id,name,price,description) values(food_seq.nextval,?,?,?)");
		statement.setString(1,name);
		statement.setFloat(2,price);
		statement.setString(3,desc);
		
		int res=statement.executeUpdate();
		
		statement.close();
		
		if(res==1)
			return true;
		else;
			return false;
	}
	
	public List<FoodItem> getFoodItems() throws SQLException{
		List<FoodItem> list = new ArrayList<FoodItem>();
		
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fooditems");
		while(rs.next()) {
			FoodItem item= new FoodItem();
			item.setId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setPrice(rs.getFloat(3));
			item.setDesc(rs.getString(4));
			list.add(item);
			
			
			
			
		}
		
		stmt.close();
		return list;
			
	}
	public boolean deleteItem(int id) throws SQLException {

		PreparedStatement statement = con.prepareStatement("delete from fooditems where id=?");
		statement.setInt(1,id);
	
		
		int res=statement.executeUpdate();
		
		statement.close();
		
		if(res==1)
			return true;
		else;
			return false;
		
		
		
		
		
		
		
		
	}

}
