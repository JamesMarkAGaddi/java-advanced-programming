package org.acumen.training.codes;

public class Employee {

	private Integer id;
	private String firstname;
	private String lastname;
	private Double salary;

	@Override
	public String toString() {
		return String.join(" ", String.valueOf(id), firstname, lastname,
				String.valueOf(salary));
	}

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

}
