package ca.myseneca.controller;

import java.util.List;

import ca.myseneca.dao.DepartmentDao;
import ca.myseneca.model.Department;

public class DepartmentController {
	private DepartmentDao departmentDao;
	
	public DepartmentController()
	{
		departmentDao = new DepartmentDao();		
	}
	
	public List<Department> getDepartmentList()
	{
		List<Department> empList = departmentDao.getAllDepartments();
		return empList;
	}
}
