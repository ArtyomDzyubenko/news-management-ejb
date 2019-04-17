package com.epam.newsmanagement.ejb.dao;

import com.epam.newsmanagement.ejb.entity.Authority;

public interface UserDAO {
    Authority getUserAuthority(String username);
}
