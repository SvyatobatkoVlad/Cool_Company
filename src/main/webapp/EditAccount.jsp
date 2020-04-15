<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="EditUser" method="POST">
		<div>
			<label for="firstname">Имя : </label> <input type="text"
				name="firstname" value="${firstname}">
		</div>
		<div>
			<label for="lastname">Фамилия: </label> <input type="text"
				name="lastname" value="${lastname}">
		</div>
		<div>
			<label for="Date_of_Birth">Дата Рождения: </label> <input type="Date"
				name="Date_of_Birth" value="${Date_of_Birth}">
		</div>
		<div>
			<label for="Telephone">Номер телефона: </label> <input type="text"
				name="Telephone" value="${Telephone}">
		</div>
		<div>
			<label for="Telephone">id user: </label> <input type="text"
				name="Telephone" value="${id}">
		</div>

		<div>
			<input name="submit" type="submit" value="Готово">

		</div>
	</form>
</body>
</html>