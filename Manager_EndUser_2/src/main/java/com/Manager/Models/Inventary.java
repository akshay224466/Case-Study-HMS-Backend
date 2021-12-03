package com.Manager.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Inventary")
public class Inventary {
	@Id
	private Long inventaryId;
	private String inventaryName;
	private Long inventaryStock;
	private String inventaryType;
	public Long getInventaryId() {
		return inventaryId;
	}
	public void setInventaryId(Long inventaryId) {
		this.inventaryId = inventaryId;
	}
	public String getInventaryName() {
		return inventaryName;
	}
	public void setInventaryName(String inventaryName) {
		this.inventaryName = inventaryName;
	}
	public Long getInventaryStock() {
		return inventaryStock;
	}
	public void setInventaryStock(Long inventaryStock) {
		this.inventaryStock = inventaryStock;
	}
	public String getInventaryType() {
		return inventaryType;
	}
	public void setInventaryType(String inventaryType) {
		this.inventaryType = inventaryType;
	}
	public Inventary(Long inventaryId, String inventaryName, Long inventaryStock, String inventaryType) {
		super();
		this.inventaryId = inventaryId;
		this.inventaryName = inventaryName;
		this.inventaryStock = inventaryStock;
		this.inventaryType = inventaryType;
	}
	public Inventary() {
		
	}
	@Override
	public String toString() {
		return "Inventary [inventaryId=" + inventaryId + ", inventaryName=" + inventaryName + ", inventaryStock="
				+ inventaryStock + ", inventaryType=" + inventaryType + "]";
	}
	
	
	
	
	
	
	

}
