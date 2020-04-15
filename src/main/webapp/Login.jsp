<h    tml>
<head>
<meta charset="UTF-8">
<title>Cool Company</title>
<link href="resources/Style.css" rel="stylesheet">
</head>
<body>

	<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>



<form action="Login" method="POST">
	<div class="form">
		<h1>Вход</h1>
		<div class="input-form">
			<input name="Login" type="text" placeholder="Логин">
		</div>
		<div class="input-form">
			<input name="Password" type="password" placeholder="Пароль">
		</div>
		<div class="input-form">
			<input name="submit" type="submit" value="Войти">
		</div>
		<div href="#" class="forget">
			<a href="signup2" class="forget">Зарегистрироваться</a>
		</div>
	</div>
	<div class="message">${message}</div>
</form>

</body>
</html>
