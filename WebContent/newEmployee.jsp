<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">New Employee Page</h3>
		<span></span>
		<form method="post" action="newEmployeeAction">
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Employee Id">
					<input class="input100 has-val" type="number" min="1" required readonly name="employeeId" value="<%=request.getAttribute("empId") %>">
					<span class="focus-input100" data-placeholder="Employee ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter First Name">
					<input class="input100" type="text" required name="firstName">
					<span class="focus-input100" data-placeholder="First Name"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Last Name">
					<input class="input100" type="text" required name="lastName">
					<span class="focus-input100" data-placeholder="Last Name"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Email">
					<input class="input100" type="email" required name="email">
					<span class="focus-input100" data-placeholder="Email"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Phone number">
					<input id="phone" class="input100" type="text" required name="phoneNumber">
					<span class="focus-input100" data-placeholder="Phone Number"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Hire Date">
					<input class="input100 has-val datepicker" type="text" required readonly name="hireDate">
					<span class="focus-input100" data-placeholder="Hire Date"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Job Id">
					<!-- <input class="input100" type="text" required name="jobId"> -->
					<select name="jobId" class="input100 has-val" style="border:0px">
						<option value="AC_ACCOUNT">AC_ACCOUNT</option>
						<option value="AC_MGR">AC_MGR</option>
						<option value="AD_ASST">AD_ASST</option>
						<option value="AD_PRES">AD_PRES</option>						
						<option value="AD_VP">AD_VP</option>
						<option value="FI_ACCOUNT">FI_ACCOUNT</option>
						<option value="FI_MGR">FI_MGR</option>
						<option value="HR_REP">HR_REP</option>
						<option value="IT_PROG">IT_PROG</option>
						<option value="MK_MAN">MK_MAN</option>
						<option value="MK_REP">MK_REP</option>
						<option value="PR_REP">PR_REP</option>
						<option value="PU_CLERK">PU_CLERK</option>
						<option value="PU_MAN">PU_MAN</option>
						<option value="SA_MAN">SA_MAN</option>
						<option value="SA_REP">SA_REP</option>
						<option value="SH_CLERK">SH_CLERK</option>
						<option value="ST_CLERK">ST_CLERK</option>
						<option value="ST_MAN">ST_MAN</option>
					</select>
					<span class="focus-input100" data-placeholder="Job ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Salary">
					<input id="salary" class="input100" type="text" maxlength="5" required name="salary">
					<span class="focus-input100" data-placeholder="Salary"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Comm Pct">
					<input id="comm" class="input100" type="text" required name="commPct">
					<span class="focus-input100" data-placeholder="Comm Pct"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Manager Id">
					<input class="input100 has-val" type="number" value="100" name="managerId">
					<span class="focus-input100" data-placeholder="Manager ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Department">
					<!-- <input class="input100" type="text" name="departmentId"> -->
					<select name="departmentId" class="input100 has-val" style="border:0px">
						<option value="0">Select Department</option>
				        <c:forEach items="${dptList}" var="department" >
				            <option value="${department.departmentId}">${department.departmentName}</option>
				        </c:forEach>
				    </select>
					<span class="focus-input100" data-placeholder="Department ID"></span>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="action">Save the New Employee</button>
		</form>
	</div>	
<jsp:include page="footer.jsp"></jsp:include>
<%
	String msg=(String)request.getAttribute("success");  
	if(msg!=null)
	out.println("<script>showAlert('success','Data Saved!','New Employee has been created',true)</script>");
%>