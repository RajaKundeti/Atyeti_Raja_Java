package org.pp2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMember2024{

	@JsonProperty("Q1")
	private Object q1;

	public void setQ1(Object q1){
		this.q1 = q1;
	}

	public Object getQ1(){
		return q1;
	}

	@Override
 	public String toString(){
		return 
			"JsonMember2024{" + 
			"q1 = '" + q1 + '\'' + 
			"}";
		}
}