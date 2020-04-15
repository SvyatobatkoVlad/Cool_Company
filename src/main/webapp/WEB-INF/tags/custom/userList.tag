<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>


<div class="table">
			<table>
				<thead>
					<tr>
						<th>LastName</th>
						<th>FirstName</th>
						<th>Date_of_Birth</th>
						<th>Login</th>
						<th>Password</th>
						<th>Telephone</th>
						<th>ID_role</th>
						<th>Edit user</th>
						<th>Delet user</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${usersList}">

						<tr>		
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.dateOfBirth}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.telephone}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td><input id=edit class="edit_button" type="button" value="EDIT"/></td>
							<td><input id=edit class="delet_button" type="button" value="DELET"/></td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>