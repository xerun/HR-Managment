<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="col-sm-11 mx-auto">
		<h3 class="m-t-20 m-b-20">Edit Employee Page</h3>
		<span></span>
		<form method="post" action="editEmployeeAction">
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Employee Id">
					<input class="input100 has-val" type="number" min="1" name="employeeId" value="<c:out value='${employee.employeeId}' />" readonly>
					<span class="focus-input100" data-placeholder="Employee ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter First Name">
					<input class="input100 has-val" type="text" required name="firstName" value="<c:out value='${employee.firstName}' />">
					<span class="focus-input100" data-placeholder="First Name"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Last Name">
					<input class="input100 has-val" type="text" required name="lastName" value="<c:out value='${employee.lastName}' />">
					<span class="focus-input100" data-placeholder="Last Name"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Email">
					<input class="input100 has-val" type="email" required name="email" value="<c:out value='${employee.email}' />">
					<span class="focus-input100" data-placeholder="Email"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Phone number">
					<input id="phone" class="input100 has-val" type="text" required name="phoneNumber" value="<c:out value='${employee.phoneNumber}' />">
					<span class="focus-input100" data-placeholder="Phone Number"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Hire Date">
					<input class="input100 has-val datepicker" type="text" required name="hireDate" readonly value="<fmt:formatDate value="${employee.hireDate}" pattern="yyyy-MM-dd" />">
					<span class="focus-input100" data-placeholder="Hire Date"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Job Id">
					<%-- <input class="input100 has-val" type="text" minlength="3" required name="jobId" value="<c:out value='${employee.jobId}' />"> --%>
					<select name="jobId" class="input100 has-val" style="border:0px">
						<option value="AC_ACCOUNT" <c:if test="${employee.jobId eq 'AC_ACCOUNT'}">selected="selected"</c:if>>AC_ACCOUNT</option>
						<option value="AC_MGR" <c:if test="${employee.jobId eq 'AC_MGR'}">selected="selected"</c:if>>AC_MGR</option>
						<option value="AD_ASST" <c:if test="${employee.jobId eq 'AD_ASST'}">selected="selected"</c:if>>AD_ASST</option>
						<option value="AD_PRES" <c:if test="${employee.jobId eq 'AD_PRES'}">selected="selected"</c:if>>AD_PRES</option>						
						<option value="AD_VP" <c:if test="${employee.jobId eq 'AD_VP'}">selected="selected"</c:if>>AD_VP</option>
						<option value="FI_ACCOUNT" <c:if test="${employee.jobId eq 'FI_ACCOUNT'}">selected="selected"</c:if>>FI_ACCOUNT</option>
						<option value="FI_MGR" <c:if test="${employee.jobId eq 'FI_MGR'}">selected="selected"</c:if>>FI_MGR</option>
						<option value="HR_REP" <c:if test="${employee.jobId eq 'HR_REP'}">selected="selected"</c:if>>HR_REP</option>
						<option value="IT_PROG" <c:if test="${employee.jobId eq 'IT_PROG'}">selected="selected"</c:if>>IT_PROG</option>
						<option value="MK_MAN" <c:if test="${employee.jobId eq 'MK_MAN'}">selected="selected"</c:if>>MK_MAN</option>
						<option value="MK_REP" <c:if test="${employee.jobId eq 'MK_REP'}">selected="selected"</c:if>>MK_REP</option>
						<option value="PR_REP" <c:if test="${employee.jobId eq 'PR_REP'}">selected="selected"</c:if>>PR_REP</option>
						<option value="PU_CLERK" <c:if test="${employee.jobId eq 'PU_CLERK'}">selected="selected"</c:if>>PU_CLERK</option>
						<option value="PU_MAN" <c:if test="${employee.jobId eq 'PU_MAN'}">selected="selected"</c:if>>PU_MAN</option>
						<option value="SA_MAN" <c:if test="${employee.jobId eq 'SA_MAN'}">selected="selected"</c:if>>SA_MAN</option>
						<option value="SA_REP" <c:if test="${employee.jobId eq 'SA_REP'}">selected="selected"</c:if>>SA_REP</option>
						<option value="SH_CLERK" <c:if test="${employee.jobId eq 'SH_CLERK'}">selected="selected"</c:if>>SH_CLERK</option>
						<option value="ST_CLERK" <c:if test="${employee.jobId eq 'ST_CLERK'}">selected="selected"</c:if>>ST_CLERK</option>
						<option value="ST_MAN" <c:if test="${employee.jobId eq 'ST_MAN'}">selected="selected"</c:if>>ST_MAN</option>
					</select>
					<span class="focus-input100" data-placeholder="Job ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Salary">
					<input id="salary" class="input100 has-val" type="text" maxlength="5" required name="salary" value="<c:out value='${employee.salary}' />">
					<span class="focus-input100" data-placeholder="Salary"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Comm Pct">
					<input id="comm" class="input100 has-val" type="text" required name="commPct" value="<c:out value='${employee.commissionPct}' />">
					<span class="focus-input100" data-placeholder="Comm Pct"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Manager Id">
					<input class="input100 has-val" type="number" name="managerId" value="<c:out value='${employee.managerId}' />">
					<span class="focus-input100" data-placeholder="Manager ID"></span>
				</div>
			</div>
			<div class="form-group p-t-10">
				<div class="wrap-input100 validate-input" data-validate = "Enter Department">
					<%-- <input class="input100 has-val" type="text" name="departmentId" value="<c:out value='${employee.departmentId}' />"> --%>
					<select name="departmentId" class="input100 has-val" style="border:0px">
				        <c:forEach items="${dptList}" var="department">
				        	<option value="0">Select Department</option>
				            <option value="${department.departmentId}" 
				            <c:if test="${department.departmentId eq employee.departmentId}">selected="selected"</c:if>
				            >${department.departmentName}</option>
				        </c:forEach>
				    </select>
					<span class="focus-input100" data-placeholder="Department ID"></span>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="action">Update the Employee</button>
			<a href="javascript:void(0)" class="btn btn-info"
			onclick="confirmDelete ('warning','Are you sure?','You won\'t be able to revert this!','deleteEmployee?id=<c:out value='${employee.employeeId}' />')">Delete the Employee</a><br><br>
		</form>
		<span>To return to the Employee List page, click on the Back button in your browser or the Return button shown below.</span><br><br>
		<a href="employeeList" class="btn btn-warning">Return</a>
	</div>
	
<jsp:include page="footer.jsp"></jsp:include>
<%
	String msg=(String)request.getAttribute("success");  
	if(msg!=null)
	out.println("<script>showAlert('success','Data Updated!','Employee date has been updated',true)</script>");
%>