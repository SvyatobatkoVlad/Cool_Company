<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tour Management Application</title>

<link href="resources/Dropdown.css" rel="stylesheet">
</head>
<body>
	<custom:hader />


	<em><h3 class="text-center">List of Tours</h3></em>

	<custom:tourList />

</body>
</html>