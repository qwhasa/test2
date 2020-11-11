package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Db;

/**
 * Servlet implementation class AddFood
 */
@WebServlet("/AddFood")
public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		String desc = request.getParameter("desc");
		PrintWriter out=response.getWriter();
		
		try {
		
			Db db= new Db();
			
			RequestDispatcher rd= request.getRequestDispatcher("addfood.html");
			rd.include(request, response);
			
			
			
			
			
			if(db.addRecord(name, price, desc)) {
				out.println("<div class='alert alert-success alert-dismissible m-3'>");
				out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
				out.println("<strong>Success!</strong> .<div>");
				
			}else {
				out.println("<div class='alert alert-danger alert-dismissible m-3'>");
				out.println("<button type='button' class='close' data-dismiss='alert'>&times;</button>");
				out.println("<strong>Error!</strong> .<div>");
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

