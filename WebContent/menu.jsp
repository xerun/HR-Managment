<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="col-sm-12">
		<div class="pull-right col-sm-12 text-right m-b-20">
			<ul class="list-inline">
				<li class="list-inline-item">Welcome: <%= session.getAttribute("name") %></li>
				<li class="list-inline-item">| <a href="logout">Logout <i class="zmdi zmdi-close"></i></a></li>
			</ul>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="employeeList"><i class="zmdi zmdi-account-box"></i></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="employeeList">Employee List</a></li>
					<li class="nav-item"><a class="nav-link" href="newEmployee">New
							Employee</a></li>
					<li class="nav-item"><a class="nav-link" href="searchEmployee">Search
							Employee</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" method="post"
					action="searchByAny">
					<input class="form-control mr-sm-2" type="search" name="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</div>