<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">Search for Employee</h3>
		<span>Employee search results for input: <%=request.getParameter("search") %></span>
		<table class="table table-hover dataTable">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Department</th>
					<th scope="col">Job ID</th>
					<th scope="col">Salary</th>
					<th scope="col">Email</th>
					<th scope="col">Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${empList}">
				<tr>					
					<td scope="col"><a href="editEmployee?id=<c:out value='${employee[7]}' />"><c:out value="${employee[0]} ${employee[1]}" /></a></td>
					<td scope="col"><c:out value="${employee[6]}" /></td>
					<td scope="col"><c:out value="${employee[2]}" /></td>
					<td scope="col"><c:out value="${employee[3]}" /></td>
					<td scope="col"><a href="mailto:<c:out value="${employee[4]}" />"><c:out value="${employee[4]}" /></a></td>
					<td scope="col"><c:out value="${employee[5]}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table><br><br>
		<span>To return the Search for Employee page, click on the Black button in your browser or the Return button shown below</span><br><br>
		<a href="searchEmployee" class="btn btn-warning">Return</a>
	</div>
<jsp:include page="footer.jsp"></jsp:include>