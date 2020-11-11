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

import com.db.Db;
import com.models.FoodItem;

/**
 * Servlet implementation class FoodList
 */
@WebServlet("/FoodList")
public class FoodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Db db=new Db();
		try {
			
			List<FoodItem> list = db.getFoodItems();
			
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>123</title>\r\n"
					+ "<script type=\"text/javascript\" src=\"jquery.js\"></script>\r\n"
					+ "<script type=\"text/javascript\" src=\"bootstrap.js\"></script>\r\n"
					+ "<link href=\"bootstrap.css\" rel=\"stylesheet\"/>\r\n"
					);
			
			out.println("<script>\r\n"
					+ "function valid(){\r\n"
					+ "	if(confirm(\"really delete it?\"))\r\n"
					+ "		return true;\r\n"
					+ "	else\r\n"
					+ "		return false;\r\n"
					+ "	\r\n"
					+ "	\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "</script>\r\n"
					+ "</head>\r\n"
					+ "<body>");
			
			
			out.println("<div class=\'jumbotron m-0\'>\r\n"
					
					+ "<h1 class=\'text-primary\'>List Items ("+list.size()+") </h1>");
			
			out.println("<a href='addfood.html' class='btn btn-link btn-warning'>Back</a></div>");
			
			out.println("<table class='table table-bordered table-striped m-2'>");
			out.println("<thead class='bg-primary '>");
			out.println("<tr><th>ID</th><th>Name</th><th>Price</th><th>Description</th><th>Delete</th></tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			
			if(list.size()>0) {
			
			for(FoodItem food:list) {
				out.println("<tr><td>"+food.getId()+"</td>");
				out.println("<td>"+food.getName()+"</td><td>"+food.getPrice()+"</td>");
			
				out.println("<td>"+food.getDesc()+"</td>");
				out.println("<td><a href='DeleteFood?id="+food.getId()+"' class='btn btn-danger' onclick='return valid();')>Delete</a></td>");
				out.println("</tr>");
	
				
			}
			}
			else {
			out.println("<tr><td colspan='5' align='center'>No Data Found</td></tr>");
			
		}
			out.println("</tbody></table></body></html>");
		}catch (SQLException e) {
			
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
