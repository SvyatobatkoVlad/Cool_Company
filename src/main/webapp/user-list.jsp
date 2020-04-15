<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>User Management Application</title>

<link href="resources/Dropdown.css" rel="stylesheet">
</head>
<body>

	<custom:hader />
	<br>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" />
	<script type="text/javascript">
		function switchToSaveMode() {

			console.log("editButton");
		}
	</script>

	<em><h3 class="text-center">List of Users</h3></em>
	<hr>

	<br>

	<custom:userList />
</body>
</html>