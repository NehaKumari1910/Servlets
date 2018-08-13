<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.jda.model.UserModel"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
<%
String userName = "";
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(request.getSession().getAttribute("user") != null){
	UserModel user = (UserModel) request.getSession().getAttribute("user");
    userName = user.getName();
}
else
{
	response.sendRedirect("signIn.jsp");
}
%>
Welcome : <%=userName %>

<form action="logout" method="post">
<br><button type="submit" >LogOut</button>

</form>
</body>
</html>