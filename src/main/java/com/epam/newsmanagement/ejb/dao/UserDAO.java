package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.Authority;
import com.epam.newsmanagement.ejb.entity.User;

public interface UserDAO {
    Authority getUserAuthority(String username);
    void saveUser(User user);
}
