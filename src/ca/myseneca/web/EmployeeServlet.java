package ca.myseneca.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.myseneca.controller.DepartmentController;
import ca.myseneca.controller.EmployeeController;
import ca.myseneca.controller.SecurityController;
import ca.myseneca.dao.*;
import ca.myseneca.model.Department;
import ca.myseneca.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(urlPatterns = { "/employeeList", "/newEmployee", "/newEmployeeAction", "/editEmployee",
		"/editEmployeeAction", "/deleteEmployee", "/searchEmployee", "/searchResult", "/searchByDepartment",
		"/searchByAny", "/login", "/logout" })
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeController employeeController;
	private DepartmentController departmentController;
	private SecurityController securityController;
	public void init() {
		employeeController = new EmployeeController();
		departmentController = new DepartmentController();
		securityController = new SecurityController();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();  
		if(session.getAttribute("name")!=null) {
			String action = request.getServletPath();
			try {
				switch (action) {
				case "/employeeList":
					employeeList(request, response);
					break;
				case "/newEmployee":
					newEmployee(request, response);
					break;
				case "/editEmployee":
					editEmployee(request, response);
					break;
				case "/deleteEmployee":
					deleteEmployee(request, response);
					break;
				case "/searchEmployee":
					searchEmployee(request, response);
					break;
				case "/searchResult":
					showEmployeeList(request, response);
					break;
				case "/logout":
					logout(request, response);
					break;
				default:
					login(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		try {
			switch (path) {
			case "/searchResult":
				showEmployeeList(request, response);
				break;
			case "/searchByDepartment":
				showEmployeeListByDepartment(request, response);
				break;
			case "/searchByAny":
				showEmployeeListByAny(request, response);
				break;
			case "/newEmployeeAction":
				newEmployeeAction(request, response);
				break;
			case "/editEmployeeAction":
				editEmployeeAction(request, response);
				break;
			default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		response.setContentType("text/html");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		try {
			long empId = securityController.loginCheck(user, pass);
			if (empId > 0l) {
				Employee employee = employeeController.getEmployee((int) empId);
				HttpSession session=request.getSession();  
		        session.setAttribute("name",employee.getFirstName()+" "+employee.getLastName()); 		        
				response.sendRedirect(request.getContextPath() + "/employeeList");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("error", "Invalid username or password");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession session=request.getSession();  
        session.invalidate();
        
        response.sendRedirect(request.getContextPath() + "/");
	}

	private void employeeList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
		dispatcher.forward(request, response);
	}

	private void newEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Department> departmentList = departmentController.getDepartmentList();
		List<Employee> employee = employeeController.getLastEmployee();
		int lastId = employee.get(0).getEmployeeId();
		System.out.println(lastId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newEmployee.jsp");
		request.setAttribute("dptList", departmentList);
		request.setAttribute("empId", (lastId+1));
		dispatcher.forward(request, response);
	}
	
	private void newEmployeeAction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Employee employee = new Employee(); 
		employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setPhoneNumber(request.getParameter("phoneNumber"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		employee.setCommissionPct(Double.parseDouble(request.getParameter("commPct")));
		employee.setEmail(request.getParameter("email"));
		employee.setHireDate(Date.valueOf(request.getParameter("hireDate")));
		employee.setJobId(request.getParameter("jobId"));
		employee.setManagerId(Integer.parseInt(request.getParameter("managerId")));
		employee.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		employeeController.addNewEmployee(employee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("newEmployee.jsp");
		request.setAttribute("success", "New record added");
		dispatcher.forward(request, response);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("searchResult");
		//dispatcher.forward(request, response);
	}

	private void editEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Department> departmentList = departmentController.getDepartmentList();
		Employee employee = employeeController.getEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
		request.setAttribute("dptList", departmentList);
		request.setAttribute("employee", employee);
		dispatcher.forward(request, response);
	}
	
	private void editEmployeeAction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		Employee employee = new Employee(); 
		employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setPhoneNumber(request.getParameter("phoneNumber"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		employee.setCommissionPct(Double.parseDouble(request.getParameter("commPct")));
		employee.setEmail(request.getParameter("email"));
		employee.setHireDate(Date.valueOf(request.getParameter("hireDate")));
		employee.setJobId(request.getParameter("jobId"));
		employee.setManagerId(Integer.parseInt(request.getParameter("managerId")));
		employee.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		employeeController.editEmployee(employee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
		request.setAttribute("success", "Record updated");
		dispatcher.forward(request, response);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("searchResult");
		//dispatcher.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeController.removeEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchResult");
		dispatcher.forward(request, response);
	}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void showEmployeeList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Employee> empList = employeeController.getEmployeeList();
		request.setAttribute("empList", empList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeSearchResult.jsp");
		dispatcher.forward(request, response);
	}

	private void showEmployeeListByDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int dptId = Integer.valueOf(request.getParameter("dptid"));
		List<Employee> empList = employeeController.getEmployeeListByDepartment(dptId);
		request.setAttribute("empList", empList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeSearchResult.jsp");
		dispatcher.forward(request, response);
	}

	private void showEmployeeListByAny(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {		
		String searchField = request.getParameter("search");
		List<Object[]> empList = null;
		empList = employeeController.getEmployeeListByAny(searchField);			
		request.setAttribute("empList", empList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchResult.jsp");
		dispatcher.forward(request, response);
	}

}
