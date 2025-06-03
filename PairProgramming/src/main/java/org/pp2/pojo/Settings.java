package org.pp2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Settings{

	@JsonProperty("theme")
	private String theme;

	@JsonProperty("notifications")
	private Notifications notifications;

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return theme;
	}

	public void setNotifications(Notifications notifications){
		this.notifications = notifications;
	}

	public Notifications getNotifications(){
		return notifications;
	}

	@Override
 	public String toString(){
		return 
			"Settings{" + 
			"theme = '" + theme + '\'' + 
			",notifications = '" + notifications + '\'' + 
			"}";
		}
}