package com.example.microserviceuser.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name="User")
public class ApplUser {

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
	
	//dodaj rolu
	@Column(name="Role")
	private String role;
	
	@NotNull
	@Column(name="Loged")
	private boolean loged;

	public ApplUser() {
	}

	public ApplUser(String username, String password) {
		this.username = username;
		this.password = password;
		this.role = "USER";
		this.loged = false;
	}
	
	public ApplUser(Integer id, String username, String password) {
		this.userId = id;
		this.username = username;
		this.password = password;
		this.role = "USER";
		this.loged = false;
	}
	
	//dodaj konstruktor za rolu
	public ApplUser(Integer id, String username, String password, String role) {
		this.userId = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.loged = false;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
	
	

}
