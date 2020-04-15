
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>



<link href="resources/Dropdown.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Cool Company</title>
</head>
<body>
<custom:hader/>

	<c:if test="${loggedInUser.role == 'ADMIN' }">
  Тут текст для админа!))
  </c:if>
	<c:if test="${loggedInUser != null }">
 Тут текст для авторизированого пользователя
</c:if>
Тут будет что то.....







<custom:footer/>
</body>
</html>
