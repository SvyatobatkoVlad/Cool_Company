<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User</title>
</head>
<body>
 <p>Hello!!!</p>
 <p>Your user name: ${loggedInUser.firstName} </p>
  
 <p>==========================================</p>
 
 <form action="LoginCheck.jsp" method="POST">
 <input name="Login" type="text" placeholder="Insert your Login"/>
 <input name="Password" type="password" placeholder="Insert your passwrod"/>
 <input type="submit" value="Sign in" />
 </form>
 
</body>
</html>