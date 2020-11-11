package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Db;

/**
 * Servlet implementation class DeleteFood
 */
@WebServlet("/DeleteFood")
public class DeleteFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Db db = new Db();
		PrintWriter out= response.getWriter();
		
		
		
		RequestDispatcher rd= request.getRequestDispatcher("FoodList");
		rd.include(request, response);
		
		try {
		
			if(db.deleteItem(id)) {
				out.println("<div class='alert alert-success alert-dismissible m-3'>");
				out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
				out.println("<strong>Success!</strong> .<div>");
				
			}else {
				out.println("<div class='alert alert-danger alert-dismissible m-3'>");
				out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
				out.println("<strong>Error!</strong> .<div>");
				
				
			}
			
			
		} catch (SQLException e) {
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
