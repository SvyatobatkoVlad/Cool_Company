<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<em><h3 class="text-center">Your profil</h3></em> Имя:
	${loggedInUser.firstName }
	<br /> Фамилия: ${loggedInUser.lastName}
	<br /> Дата рождения: ${loggedInUser.dateOfBirth }
	<br /> Телефон: ${loggedInUser.telephone}
	<br />
	<a href="EditUser" class="forget">Edit my account</a>
</body>
</html>