package org.pp2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartnershipsItem{

	@JsonProperty("partner")
	private String partner;

	@JsonProperty("startYear")
	private int startYear;

	@JsonProperty("active")
	private boolean active;

	public void setPartner(String partner){
		this.partner = partner;
	}

	public String getPartner(){
		return partner;
	}

	public void setStartYear(int startYear){
		this.startYear = startYear;
	}

	public int getStartYear(){
		return startYear;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	@Override
 	public String toString(){
		return 
			"PartnershipsItem{" + 
			"partner = '" + partner + '\'' + 
			",startYear = '" + startYear + '\'' + 
			",active = '" + active + '\'' + 
			"}";
		}
}