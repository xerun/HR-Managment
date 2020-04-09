<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">Employee List Page</h3>
		<span>Show employee in a department by typing in the department id and click on the button or click on the Show All Employee for 
		all employees in the company.</span>
		<form method="post" action="searchByDepartment">
			<div class="form-group p-t-20">
				<div class="wrap-input100 validate-input" data-validate = "Enter department id">
					<input class="input100" type="number" min="10" required name="dptid">
					<span class="focus-input100" data-placeholder="Department Id"></span>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="action">Show Department Employees</button>
			<a href="searchResult" class="btn btn-info">Show All Employees</a>
		</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>