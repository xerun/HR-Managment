# HR-Managment

This application use Model-ViewController software pattern to design and implement a Human Resources Management Web Application. Java servlets, JSP, Bootstrap and JPA are used to develop this application.  
The application is comprised of the following parts:  

Packages:  
		ca.myseneca.controller  
		The following classes in this package are to control the data flow into model objects  
			-DepartmentController  
			-EmployerController  
			-SecurityController 
			
		ca.myseneca.dao  
		The following classes in this package are to abstract the retrieval of data from the Oracle database  
			-DepartmentDao  
			-EmployeeDao  
			-SecurityDao  
			
		ca.myseneca.model  
		This package contains the following Java Bean Classes to provide getters and setters  
			-Department  
			-Employee  
			-Security 
			
		ca.myseneca.web  
		This Package contains following servlet class that is used to handle the request obtained from the web server, process the request, produce the response, then send response back to the web server.  
		 	-EmployeeServlet  
		
META-INF folder:  
		 -contains persistence.xml  

WebContent  

		-css folder contains the style files for the website  
		-fonts folder contains the used fonts in the website  
	 	-images folder contains the icon used in the website  
		-js folder contains the main.js  
		-vendor folder contains libraries, plugins, modules, bootstrap and other components  
		WEB-INF folder:  
		-contains the following html and jsp files that form the website.  
			-404.html  
			-editEmployee.jsp  
			-employeeSearchList.jsp  
			-employeeSearchResult.jsp  
			-footer.jsp  
			-header.jsp  
			-index.jsp  
			-menu.jsp  
			-newEmployee.jsp  
			-searchEmployee.jsp  
			-searchResult.jsp
