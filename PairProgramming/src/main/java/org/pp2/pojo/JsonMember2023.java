package org.pp2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMember2023{

	@JsonProperty("Q1")
	private Object q1;

	@JsonProperty("Q2")
	private Object q2;

	@JsonProperty("Q3")
	private Object q3;

	@JsonProperty("Q4")
	private Object q4;

	public void setQ1(Object q1){
		this.q1 = q1;
	}

	public Object getQ1(){
		return q1;
	}

	public void setQ2(Object q2){
		this.q2 = q2;
	}

	public Object getQ2(){
		return q2;
	}

	public void setQ3(Object q3){
		this.q3 = q3;
	}

	public Object getQ3(){
		return q3;
	}

	public void setQ4(Object q4){
		this.q4 = q4;
	}

	public Object getQ4(){
		return q4;
	}

	@Override
 	public String toString(){
		return 
			"JsonMember2023{" + 
			"q1 = '" + q1 + '\'' + 
			",q2 = '" + q2 + '\'' + 
			",q3 = '" + q3 + '\'' + 
			",q4 = '" + q4 + '\'' + 
			"}";
		}
}