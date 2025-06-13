package org.pp2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Push{

	@JsonProperty("enabled")
	private boolean enabled;

	@JsonProperty("frequency")
	private String frequency;

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setFrequency(String frequency){
		this.frequency = frequency;
	}

	public String getFrequency(){
		return frequency;
	}

	@Override
 	public String toString(){
		return 
			"Push{" + 
			"enabled = '" + enabled + '\'' + 
			",frequency = '" + frequency + '\'' + 
			"}";
		}
}