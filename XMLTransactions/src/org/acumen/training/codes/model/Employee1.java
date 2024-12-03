package org.acumen.training.codes.model;

import java.time.LocalDate;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employee")
public class Employee1 {

	@JacksonXmlProperty(localName = "id")
	private Integer id;
	@JacksonXmlProperty(localName = "firstname")
	private String firstname;
	@JacksonXmlProperty(localName = "lastname")
	private String lastname;
	@JacksonXmlProperty(localName = "salary")
	private Double salary;
	@JacksonXmlProperty(localName = "birthday")
	private LocalDate birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

}
