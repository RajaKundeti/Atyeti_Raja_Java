package org.pp2.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsItem{

	@JsonProperty("members")
	private List<MembersItem> members;

	@JsonProperty("name")
	private String name;

	@JsonProperty("lead")
	private String lead;

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLead(String lead){
		this.lead = lead;
	}

	public String getLead(){
		return lead;
	}

	@Override
 	public String toString(){
		return 
			"TeamsItem{" + 
			"members = '" + members + '\'' + 
			",name = '" + name + '\'' + 
			",lead = '" + lead + '\'' + 
			"}";
		}
}