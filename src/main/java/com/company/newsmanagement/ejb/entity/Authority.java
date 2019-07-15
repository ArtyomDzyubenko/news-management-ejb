package com.company.newsmanagement.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROLES")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ROLE")
    private String authority;

    @Id
    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public String getAuthority() {
        return authority;
    }

    public String getUsername() {
        return username;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
