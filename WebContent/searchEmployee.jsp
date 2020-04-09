<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">Search for Employee Page</h3>
		<span>Search for an Employee by typing in any part of name, email address, phone number or department</span>
		<form method="post" action="searchByAny">
			<div class="form-group p-t-20">
				<div class="wrap-input100 validate-input" data-validate = "Enter any values">
					<input class="input100" type="text" name="search">
					<span class="focus-input100" data-placeholder="Search"></span>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="action">Go</button>
		</form>
	</div>
<jsp:include page="footer.jsp"></jsp:include>