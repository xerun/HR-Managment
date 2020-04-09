package ca.myseneca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SecurityDao {
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
    
	public long checkUser(String user, String password) {
		getEntityManager();
		try {
			//Query queryObj = em.createQuery("SELECT s.secId FROM Security s WHERE s.secId = :id AND s.secPassword = :password AND s.secStatus= :status");         
			Query queryObj = em.createQuery(
				      "SELECT s.employeeId FROM Security s WHERE s.secId = :id AND s.secPassword = :password AND s.secStatus= :status");				  
			
			queryObj.setParameter("id", user);
	        queryObj.setParameter("password", password);
	        queryObj.setParameter("status", "A");

	        long empId = (Long) queryObj.getSingleResult();
	        return empId;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			closeEntityManager();
		}
        return 0;
    }
}
