package ca.myseneca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ca.myseneca.model.Department;

public class DepartmentDao {
	private EntityManagerFactory emf;
	private EntityManager em;
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence.createEntityManagerFactory("assignment2");
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		// Close the EntityManager
		em.close();
		emf.close();
	}
    
	public List <Department> getAllDepartments() {
		getEntityManager();
        List <Department> listOfDepartment = null;
        TypedQuery<Department> query = em.createNamedQuery("Department.findAll", Department.class);
		// Query and get result
        listOfDepartment = query.getResultList();
	    closeEntityManager();
        return listOfDepartment;
    }
}
