<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<meta charset="UTF-8">
<div>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			
			<div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="dropdown-content">
    <a href="GetLogin" class="forget">Sign in</a>
    <a href="signup2" class="forget">Sign up</a>
    <a href="LogOut">Sign out</a>
  </div>
</div>
			<a href="index.jsp" class="forget">Home page</a>   
			<a href="UserServlet"  class="forget">All user</a>
			<a href="TourServlet"  class="forget">All tour</a>
			<c:if test="${loggedInUser != null }">
			<a href="myaccount.jsp"  class="forget">My account</a>
			</c:if>
		</nav>
	</header>
</div>
