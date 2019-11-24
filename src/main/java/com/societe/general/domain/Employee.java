package com.societe.general.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name ="first_name")
	@NotNull
	@NotEmpty(message = "First name must not be empty")
	private String firstName;
	
	@Column(name ="last_name")
	@NotNull
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;
	
	
	@Column(name ="gender")
	@NotNull
	@NotEmpty(message = "Gender must not be empty")
	private String gender;
	
	@Column(name ="date_of_birth")
	@NotNull
	@NotEmpty(message = "DOB must not be empty")
	private String dateOfBirth;
	
	@Column(name ="department")
	@NotNull
	@NotEmpty(message = "Department name must not be empty")
	private String department;
	
	
	
	public Employee() {
		
	}
	
	
	public Employee(Integer id, String firstName, String lastName, String gender, String dateOfBirth,
			String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + "]";
	}
	
	
	
	
	
	
	

}
