<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h1>SignIn Portal</h1>
<form action="login" method="post">
<label for="username">Email-Id:</label>
<input type="text" name="email"/><br>
<label for="password">Password:</label>
<input type="password" name="password"/><br>
<button type="submit" formaction="index.jsp">SignUp</button>
<button type="submit">LogIn</button>
<%
String errorMsg="";
if(request.getSession().getAttribute("error")!=null)
	errorMsg=(String)request.getSession().getAttribute("error");
%>
<p>
<%=errorMsg%>
</p>

</form>
</body>
</html>