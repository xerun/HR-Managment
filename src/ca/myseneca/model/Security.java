package ca.myseneca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SECURITY database table.
 * 
 */
@Entity
@Table(name="SECURITY")
@NamedQuery(name="Security.findAll", query="SELECT s FROM Security s")
public class Security implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	@Column(name="SEC_ID")
	private String secId;

	@Column(name="SEC_PASSWORD")
	private String secPassword;

	@Column(name="SEC_STATUS")
	private String secStatus;

	public Security() {
	}

	public long getDmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getSecId() {
		return this.secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getPassword() {
		return this.secPassword;
	}

	public void setPassword(String password) {
		this.secPassword = password;
	}

	public String getSecStatus() {
		return this.secStatus;
	}

	public void setEmployee(String secStatus) {
		this.secStatus = secStatus;
	}

}