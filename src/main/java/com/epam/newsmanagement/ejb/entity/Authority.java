package com.epam.newsmanagement.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AUTHORITY")
    private String authority;

    @Id
    @Column(name = "USERNAME")
    private String username;

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
}
