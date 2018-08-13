package com.jda.controllers;

	import java.io.IOException;
	import java.io.PrintWriter;
	

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.jda.dao.jdbcUtill;
import com.jda.model.UserModel;

	/**
	 * Servlet implementation class UserController
	 */

	public class RegistrationController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			System.out.print("djskfjdfd");
			try {
				UserModel usermodel=new UserModel();
				usermodel.setName(request.getParameter("name"));
				usermodel.setGender(request.getParameter("gender"));
				usermodel.setAge(Integer.parseInt(request.getParameter("age")));
				usermodel.setUsername(request.getParameter("username"));
				usermodel.setEmail(request.getParameter("emailaddress"));
				usermodel.setPassword(request.getParameter("password"));
				usermodel.setPhone(request.getParameter("phone"));
			
				jdbcUtill.registerUser(usermodel);
			
			  RequestDispatcher dispatcher = request.getRequestDispatcher("signIn.jsp");
				
				dispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println("error"+e);
				
			}
		}

	}

