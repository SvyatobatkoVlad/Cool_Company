<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>
    <h1>Регистрация</h1>

 

    <form action="${pageContext.request.contextPath}/processcustomer" method="post">
    <div>
        <label for="firstname">Имя : </label>
        <input type="text" name="firstname"  value="${firstname}">
     </div>
     <div>    
        <label for="lastname">Фамилия: </label>
        <input type="text" name="lastname" value="${lastname}">
       </div>
       <div> 
         <label for="Date_of_Birth">Дата Рождения: </label>
         <input type="int" name="Date_of_Birth" value="${Date_of_Birth}">
      </div> 
      <div>   
        <label for="email">Login: </label>
        <input type="text" name="email"  value="${email}">
      </div>
      <div> 
 	    <label for="password">Пароль: </label>
 	    <input type="password" name="Password"  value="${password}">
 	 </div>
 	  <div>   
 	   <label for="Telephone">Номер телефона: </label>
 	    <input type="text" name="Telephone"  value="${Telephone}"> 		       	
    </div>
 
    <div >
			<input name="submit" type="submit" value="Готово">
		</div>
    </form>
    
	 
</body>
</html>