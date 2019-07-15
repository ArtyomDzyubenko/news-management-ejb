package com.company.newsmanagement.ejb.dao;

import com.company.newsmanagement.ejb.entity.User;
import com.company.newsmanagement.ejb.entity.Authority;

public interface UserDAO {
    Authority getUserAuthority(String username);
    void saveUser(User user);
}
