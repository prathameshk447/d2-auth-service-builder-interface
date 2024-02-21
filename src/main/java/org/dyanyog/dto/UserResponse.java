package org.dyanyog.dto;


import org.springframework.stereotype.Component;

@Component
public class UserResponse {

	private String status;
	private String message;
	private long user_id;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	public void setAge(String age) {
		// TODO Auto-generated method stub
		
	}
}