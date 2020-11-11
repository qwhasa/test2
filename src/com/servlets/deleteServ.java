package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.db.Db;
import com.google.gson.Gson;
import com.models.FoodItem;

/**
 * Servlet implementation class deleteServ
 */
@WebServlet("/deleteServ")
public class deleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Db db=new Db();
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		
		JSONObject jason = new JSONObject();
		
		try {
			if(db.deleteItem(id)){
				jason.put("Message", "Item Deleted successfully");
				jason.put("result","success");
				
			}
			else {
				
				jason.put("Message", "Item Deleted failed");
				jason.put("result","fail");
				
				
			}
			
		out.print(jason.toString());
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
