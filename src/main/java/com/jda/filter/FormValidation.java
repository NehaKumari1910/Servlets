package com.jda.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormValidation implements Filter {
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws java.io.IOException,
         ServletException{
		String name=request.getParameter("name");
		String email=request.getParameter("emailaddress");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		System.out.println("print"+name+" "+email+" "+" "+phone+" "+password);
		String regexPhone = "^[0-9]{10}$";
		Pattern pattern=Pattern.compile(regexPhone);
		Matcher matcher=pattern.matcher(phone);
		String regexEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern1=Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
		Matcher matcher1=pattern1.matcher(email);
	System.out.println("print"+name+" "+email+" "+" "+phone+" "+password);
		if(name.equals(""))
		{
			request.setAttribute("name_error","Name can't be null");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else if(!matcher1.matches())
		{
			request.setAttribute("email_error","Email address is not valid");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else if(password.length()<5 || password.length()>9)
		{
			request.setAttribute("password_error","password must be of length 5 - 9 charachters.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		}
		else if(!matcher.matches())
		{
			request.setAttribute("phone_error","Phone number is not valid.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		chain.doFilter(request, response);
	}

}
