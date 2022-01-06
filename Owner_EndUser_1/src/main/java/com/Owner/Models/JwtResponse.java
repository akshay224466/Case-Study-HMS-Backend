package com.Owner.Models;

public class JwtResponse {
	
	
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String response) {
		super();
		this.response = response;
	}

	@Override
	public String toString() {
		return "JwtResponse [response=" + response + "]";
	}
	
	

	
}
