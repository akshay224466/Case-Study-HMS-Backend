package com.Owner.Models;

public class JwtRequest {
	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public JwtRequest(String username, String password, String mobileNumber, String email) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public JwtRequest(String username, String password, String mobileNumber,
	 * String email) { super(); this.username = username; this.password = password;
	 * this.mobileNumber = mobileNumber; this.email = email; }
	 */
	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}
	
	
	
	

}

