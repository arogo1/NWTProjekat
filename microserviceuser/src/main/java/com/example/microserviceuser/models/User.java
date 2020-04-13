package com.example.microserviceuser.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private int userId;

	@NotNull
	@Size(min = 3, message = "Username must be at least 3 characters long")
	@Column(name="Username")
	private String username;

	@NotNull
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Column(name="Loged")
	private boolean loged;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.loged = false;
	}
	
	public User(Integer id, String username, String password) {
		this.userId = id;
		this.username = username;
		this.password = password;
		this.loged = false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}
	
	@Override
	  public String toString() {
	    return String.format("User [id=%s, username=%s, password=%s]", userId, username, password);
	  }

}
