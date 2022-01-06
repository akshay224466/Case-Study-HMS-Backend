package com.Owner.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection ="OwnerInformation" )
public class OwnerInformation {
	
	@Id
	private String Id;

	private String email;



	 private String username;
	private String password;
	private String mobileNumber;
	
	
	public OwnerInformation() {
		
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setId(String id) {
		Id = id;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return Id;
	}
	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }
	
}