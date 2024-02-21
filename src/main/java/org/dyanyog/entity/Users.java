package org.dyanyog.entity;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Users {

	@GeneratedValue
	@Id
	@Column
	private long user_id;
	
	public long getUser_id() {
		return user_id;
	}

	public Users setUser_id(long user_id) {
		this.user_id = user_id;
		return this;
	}
	@Column
    private String status;
	@Column
    private String message;
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String age;
	
	public static Users getInstance() {
		return new Users();
	}

	public String getUsername() {
		return username;
	}

	public Users setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Users setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Users setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAge() {
		return age;
	}

	public Users setAge(String age) {
		this.age = age;
		return this;
	}
	public String getStatus() {
		return status;
	}

	public Users setStatus( String status) {
		this.status= status;
		return this;
		
	}
	public String getMessage() {
		return message;
	}

	public Users setMessage( String message) {
		this.message= message;
		return this;
		
	}
}
