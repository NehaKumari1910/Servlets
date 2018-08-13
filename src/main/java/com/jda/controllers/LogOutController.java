package com.jda.controllers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LogOutController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();
			 response.sendRedirect("signIn.jsp");
		} 
		catch (Exception e) {
			System.out.println("error"+e);
		}
	}	

}
