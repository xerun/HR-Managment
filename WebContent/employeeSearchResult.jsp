<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ca.myseneca.model.Employee" %> 
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">Employee List Page</h3>
		<span>Here is the information of employees.</span>
		<table class="table table-hover dataTable">
			<thead>
				<tr>
					<th scope="col">Employee ID</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Hire Date</th>
					<th scope="col">Job Id</th>
					<th scope="col">Salary</th>
					<th scope="col">Commission Pct</th>
					<th scope="col">Manager Id</th>
					<th scope="col">Department Id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${empList}">
				<tr>
					<td scope="col"><a href="editEmployee?id=<c:out value='${employee.employeeId}' />" class="btn btn-primary"><c:out value="${employee.employeeId}" /></a></td>
					<td scope="col"><c:out value="${employee.firstName}" /></td>
					<td scope="col"><c:out value="${employee.lastName}" /></td>
					<td scope="col"><a href="mailto:<c:out value="${employee.email}" />"><c:out value="${employee.email}" /></a></td>
					<td scope="col"><c:out value="${employee.phoneNumber}" /></td>
					<td scope="col"><fmt:formatDate value="${employee.hireDate}" pattern="yyyy-MM-dd" /></td>
					<td scope="col"><c:out value="${employee.jobId}" /></td>
					<td scope="col"><c:out value="${employee.salary}" /></td>
					<td scope="col"><c:out value="${employee.commissionPct}" /></td>
					<td scope="col"><c:out value="${employee.managerId}" /></td>
					<td scope="col"><c:out value="${employee.departmentId}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><br>
		<span>To return to the employee list page, click on the Back button in your browser or the Return button shown below.</span><br><br>
		<a href="employeeList" class="btn btn-warning">Return</a>
	</div>
<jsp:include page="footer.jsp"></jsp:include>