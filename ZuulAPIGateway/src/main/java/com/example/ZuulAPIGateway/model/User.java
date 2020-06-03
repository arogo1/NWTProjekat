/*package com.example.ZuulAPIGateway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="users")
public class User  {
    public User(){}

    public User(Integer id, String username, String password, String avatarUrl){
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }


    public User(String username, String password, String avatarUrl){
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    public User(String username, String password, String avatarUrl, String email){
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @NotNull(message = "Username must not be empty.")
    @Size(max = 50, message = "Username must not be longer than 50 characters.")
    @Column(name="username")
    private String username;

    @NotNull(message = "Password must not be empty.")
    @Size(max = 100, message = "Password must not be longer than 100 characters.")
    @Column(name="password")
    private String password;

    @NotNull(message = "AvatarUrl must not be empty.")
    @Size(max = 200, message = "AvatarUrl must not be longer than 200 characters.")
    @Column(name="avatar_url")
    private String avatarUrl;

    @NotNull(message = "Email must not be empty.")
    @Size(max = 200, message = "Email must not be longer than 50 characters.")
    @Column(name="email")
    private String email;

    @ManyToOne
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAvatarUrl(){
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl){
        this.avatarUrl = avatarUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        Integer roleId = 0;
        if (role != null) {
            roleId = role.getId();
        }
        return String.format(
                "User[id=%d, username='%s', password='%s', avatarUrl='%s', roleId=%d]",
                id, username, password, avatarUrl, roleId);
    }
}*/