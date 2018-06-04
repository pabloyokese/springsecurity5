package com.jp.repository;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author Rob Winch
 */
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@NotEmpty(message = "This field is required")
	private String email;

	@NotEmpty(message = "This field is required")
	private String password;

	@NotEmpty(message = "This field is required")
	private String firstName;

	@NotEmpty(message = "This field is required")
	private String lastName;

	public User() {}

	public User(User user) {
		this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
	}

	public User(Long id, String email, String password, String firstName,
			String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
