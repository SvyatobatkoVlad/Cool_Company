<%@ taglib prefix="custom" tagdir="/WEB-INF/tags/custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>


<table class="table table-bordered" border="3px">
				<thead>
					<tr>
						
						<th>Tour Name</th>
						<th>Start tour</th>
						<th>End tour</th>
						<th>Type tour</th>
						<th>Edit user</th>
						<th>Delet user</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="tour" items="${toursList}">

						<tr>
							
							<td><c:out value="${tour.tourName}" /></td>
							<td><c:out value="${tour.startData}" /></td>
							<td><c:out value="${tour.endData}" /></td>
							<td><c:out value="${tour.type}" /></td>
							<td><input id=edit class="edit_button" type="button" value="EDIT"/></td>
							<td><input id=edit class="delet_button" type="button" value="DELET"/></td>	
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
