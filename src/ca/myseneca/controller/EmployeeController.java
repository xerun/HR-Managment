package ca.myseneca.controller;

import java.util.List;

import ca.myseneca.dao.EmployeeDao;
import ca.myseneca.model.Employee;

public class EmployeeController {
	private EmployeeDao employeeDao;
	
	public EmployeeController()
	{
		employeeDao = new EmployeeDao();		
	}
	
	public Employee getEmployee(int empId)
	{
		Employee employee = employeeDao.getEmployee(empId);
		return employee;
	}
	
	public List<Employee> getLastEmployee()
	{
		List<Employee> employee = employeeDao.getLastEmployee();
		return employee;
	}
	
	public void addNewEmployee(Employee employee)
	{
		employeeDao.saveEmployee(employee);
	}
	
	public void editEmployee(Employee employee)
	{
		employeeDao.updateEmployee(employee);
	}
	
	public void removeEmployee(int empId)
	{
		employeeDao.deleteEmployee(empId);
	}
	
	public List<Employee> getEmployeeList()
	{
		List<Employee> empList = employeeDao.getAllEmployee();
		return empList;
	}
	
	public List<Employee> getEmployeeListByDepartment(int dptId)
	{
		List<Employee> empList = employeeDao.getAllEmployeeByDepartment(dptId);
		return empList;
	}
	
	public List<Object[]> getEmployeeListByAny(String name)
	{
		List<Object[]> empList = employeeDao.getAllEmployeeByAny(name);
		return empList;
	}
}
