package com.epam.newsmanagement.ejb.service;

import com.epam.newsmanagement.ejb.dao.UserDAO;
import com.epam.newsmanagement.ejb.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class UserServiceImpl implements UserService {

    @EJB
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
       userDAO.saveUser(user);
    }
}
