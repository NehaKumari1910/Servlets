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

@WebServlet("/login")
public class LogInController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			
			UserModel user=jdbcUtill.logInUser(request.getParameter("email"));
			if(user.getPassword()!=null)
			{
				System.out.println("helll");
				System.out.println("pas"+user.getPassword()+" "+request.getParameter("password"));
					if(user.getPassword().equals(request.getParameter("password")))
					{
						user.setPassword(null);
						request.getSession().setAttribute("user", user);
						RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
						dispatcher.forward(request, response);
					}
					else
					{
						request.getSession().setAttribute("error", "your password is incorrect");
						RequestDispatcher dispatcher = request.getRequestDispatcher("signIn.jsp");
						dispatcher.forward(request, response);
						request.getSession().removeAttribute("error");
						System.out.println("password is incorrect");
					}
			}
			else
			{
				request.getSession().setAttribute("error", "user may not exist or user or password may be incorrect.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("signIn.jsp");
				dispatcher.forward(request, response);
				request.getSession().removeAttribute("error");
			}
		} catch (Exception e) {
			System.out.println("error"+e);
			
		}
	}	
}
