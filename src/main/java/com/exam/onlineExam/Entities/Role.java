package com.exam.onlineExam.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private int id;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "roleName",orphanRemoval = true)
    private Set<User_Role> userRole=new HashSet<>();

    
    public Role() {
    }


    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Set<User_Role> getUser_Role() {
        return userRole;
    }


    public void setUser_Role(Set<User_Role> user_Role) {
        this.userRole = user_Role;
    }
    
    
}
