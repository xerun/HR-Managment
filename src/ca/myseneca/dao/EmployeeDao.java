package ca.myseneca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ca.myseneca.model.Employee;

public class EmployeeDao {
	private EntityManagerFactory emf;
	private EntityManager em;
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence.createEntityManagerFactory("assignment2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public void closeEntityManager() {
		// Close the EntityManager
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public void saveEmployee(Employee emp) {
		getEntityManager();
		Employee employee = new Employee(); 
		employee.setEmployeeId(emp.getEmployeeId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setPhoneNumber(emp.getPhoneNumber());
		employee.setSalary(emp.getSalary());
		employee.setCommissionPct(emp.getCommissionPct());
		employee.setEmail(emp.getEmail());
		employee.setHireDate(emp.getHireDate());
		employee.setJobId(emp.getJobId());
		employee.setManagerId(emp.getManagerId());
		employee.setDepartmentId(emp.getDepartmentId());
		em.persist(employee);
		closeEntityManager();
    }

    public void updateEmployee(Employee emp) {
    	getEntityManager();
    	Employee employee = em.find(Employee.class, emp.getEmployeeId());
    	employee.setEmployeeId(emp.getEmployeeId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setPhoneNumber(emp.getPhoneNumber());
		employee.setSalary(emp.getSalary());
		employee.setCommissionPct(emp.getCommissionPct());
		employee.setEmail(emp.getEmail());
		employee.setHireDate(emp.getHireDate());
		employee.setJobId(emp.getJobId());
		employee.setManagerId(emp.getManagerId());
		employee.setDepartmentId(emp.getDepartmentId());
		closeEntityManager();
    }

    public void deleteEmployee(int id) {
    	getEntityManager();
    	Employee employee = em.find(Employee.class, id);
	    em.remove(employee);
	    closeEntityManager();
    }

    public Employee getEmployee(int id) {
    	getEntityManager();
    	Employee employee = em.find(Employee.class, id);
	    closeEntityManager();
        return employee;
    }
    
    public List<Employee> getLastEmployee() {
    	getEntityManager();
    	TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
    	List<Employee> employee = query.setMaxResults(1).getResultList();;
	    closeEntityManager();
        return employee;
    }

    public List <Employee> getAllEmployee() {        
        getEntityManager();
        List <Employee> listOfEmployee = null;
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		// Query and get result
        listOfEmployee = query.getResultList();
	    closeEntityManager();
        return listOfEmployee;
    }
    
    public List <Employee> getAllEmployeeByDepartment(int deptId) {       
        getEntityManager();
        List <Employee> listOfEmployee = null;
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.departmentId=:deptId", Employee.class);
	    query.setParameter("deptId", deptId);
	    listOfEmployee = query.getResultList();
	    closeEntityManager();
        return listOfEmployee;
    }
    
    public List <Object[]> getAllEmployeeByAny(String field) {       
        getEntityManager();
        List <Object[]> listOfEmployee = null;
        Query query = em.createQuery("SELECT e.firstName,e.lastName,e.jobId,e.salary,e.email,e.phoneNumber,d.departmentName,e.employeeId "
        		+ "FROM Employee e, Department d WHERE e.departmentId = d.departmentId AND "
        		+ "(UPPER(e.firstName) LIKE UPPER(:search) OR UPPER(e.lastName) LIKE UPPER(:search) "
        		+ "OR UPPER(e.email) LIKE UPPER(:search) OR e.phoneNumber LIKE :search "
        		+ "OR UPPER(d.departmentName) LIKE UPPER(:search))");
	    query.setParameter("search", "%"+field+"%");
	    listOfEmployee = query.getResultList();
	    closeEntityManager();
        return listOfEmployee;
    }
}
