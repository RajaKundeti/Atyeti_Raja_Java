package org.pp2.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Technologies{

	@JsonProperty("cloud")
	private Cloud cloud;

	@JsonProperty("languages")
	private List<String> languages;

	@JsonProperty("tools")
	private List<String> tools;

	public void setCloud(Cloud cloud){
		this.cloud = cloud;
	}

	public Cloud getCloud(){
		return cloud;
	}

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setTools(List<String> tools){
		this.tools = tools;
	}

	public List<String> getTools(){
		return tools;
	}

	@Override
 	public String toString(){
		return 
			"Technologies{" + 
			"cloud = '" + cloud + '\'' + 
			",languages = '" + languages + '\'' + 
			",tools = '" + tools + '\'' + 
			"}";
		}
}