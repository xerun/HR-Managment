package ca.myseneca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private java.math.BigDecimal locationId;
	
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee employee;

	public Department() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(java.math.BigDecimal locationId) {
		this.locationId = locationId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}