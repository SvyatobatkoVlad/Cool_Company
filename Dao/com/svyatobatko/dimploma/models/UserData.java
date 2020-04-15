package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Role;

public class UserData {
	private String id;
	private String firstName;
	private String lastName;
	private Role role;
	private String Login;
	private String Password;
	private String Telephone;
	private String dateOfBirth;
	private String referId;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}	
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", Login=" + Login + ", Password=" + Password + ", Telephone=" + Telephone + ", dateOfBirth="
				+ dateOfBirth + ", referId=" + referId + "]";
	}

	public void setReferId(String value) { this.referId = value; }
	 
}
