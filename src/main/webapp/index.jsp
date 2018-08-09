
 <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Portal</h1>
<form action="registration" method="post">
<label for="Name" >Name:</label>
<input type="text" name="name" placeholder="name" /><br>
<label for="gender"  >Gender:</label>
<select name="gender">
  <option name="male" value="male">Male</option>
  <option name="female" value="female">Female</option>
</select><br>
<label for="Age" >Age:</label>
<input type="text" name="age" placeholder="age" /><br>
<label for="Name" >UserName:</label>
<input type="text" name="username" placeholder="username" /><br>
<label for="Email-Id">Email Id:</label>
<input  type="email" name="emailaddress" placeholder="email"/><br>
<label for="password">Password:</label>
<input type="password" name="userpassword" placeholder="password"/><br>
<label for="phone">Phone:</label>
<input type="text" name="phone" placeholder="phone"/><br>

<button type="submit">SignUp</button>
<button type="submit" formaction="signIn.jsp">login </button>
</form>
</body>
</html>