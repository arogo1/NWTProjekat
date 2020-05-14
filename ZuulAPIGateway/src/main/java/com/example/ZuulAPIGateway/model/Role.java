package com.example.ZuulAPIGateway.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "roles")
public class Role {
    public Role(){}

    public Role(String type){
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @NotNull(message = "Type must not be empty.")
    @Size(max = 30, message = "Type must not be longer than 30 characters.")
    @Column(name = "type")
    private String type;

    public Integer getId() {
        return id;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return String.format(
                "Role[id=%d, type='%s']",
                id, type);
    }
}
