package com.xdl.bean;

import java.io.Serializable;

public class XdlUser implements Serializable{
	
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1941273448809141651L;
	@Override
	public String toString() {
		return "XdlUser [user_id=" + user_id + ", login_name=" + login_name + ", password=" + password + ", email="
				+ email + ", recommender=" + recommender + "]";
	}
	public XdlUser(String login_name, String password, String email, String recommender) {
		super();
		this.login_name = login_name;
		this.password = password;
		this.email = email;
		this.recommender = recommender;
	}
	public XdlUser(int user_id, String login_name, String password, String email, String recommender) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.password = password;
		this.email = email;
		this.recommender = recommender;
	}
	public XdlUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	private  int   user_id;
    private  String login_name;
    private  String password;
    private  String  email;
    /** ÍÆ¼öÈË*/
    private  String  recommender;
}
