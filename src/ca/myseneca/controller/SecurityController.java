package ca.myseneca.controller;

import ca.myseneca.dao.SecurityDao;

public class SecurityController {
	private SecurityDao securityDao;
	
	public SecurityController()
	{
		securityDao = new SecurityDao();	
	}
	
	public long loginCheck(String user, String pass)
	{
		long employeeId = securityDao.checkUser(user, pass);
		return employeeId;
	}
}
