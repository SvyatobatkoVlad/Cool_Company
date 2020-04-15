<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Регистрация</title>
<link href="resources/Style.css" rel="stylesheet">
</head>
<body>



	<div class="form">
		<h1>Регистрация</h1>
		<form action="signup2" method="POST">
			<div class="input-form">
				<label for="firstname"></label> <input type="text" name="firstname"
					value="${firstname}" placeholder="Имя">
			</div>
			<div class="input-form">
				<label for="lastname"> </label> <input type="text" name="lastname"
					value="${lastname}" placeholder="Фамилия">
			</div>
			<div class="input-form">
				<label for="Date_of_Birth"></label> <input type="Date"
					name="Date_of_Birth" value="${Date_of_Birth}"
					placeholder="Дата рождения">
			</div>
			<div class="input-form">
				<label for="email"></label> <input type="email" name="email"
					value="${email}" placeholder="логин">
			</div>
			<div class="input-form">
				<label for="password"></label> <input type="password"
					name="Password" value="${password}" placeholder="Пароль">
			</div>
			<div class="input-form">
				<label for="Telephone"></label> <input type="text" name="Telephone"
					value="${Telephone}" placeholder="Номер телефона">
			</div>

			<div class="input-form">
				<input name="submit" type="submit" value="Зарегистрироваться">
			</div>
		</form>
	</div>

</body>
</html>