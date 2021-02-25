package com.batch2.latihan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "m_user")
public class User {

    @Id
    private Integer id;
    @Column(name = "username")
    private String userName;
    private String email;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
