package com.company.newsmanagement.ejb.servlet;

import com.company.newsmanagement.ejb.service.UserService;
import com.company.newsmanagement.ejb.entity.Authority;
import com.company.newsmanagement.ejb.entity.User;
import com.company.newsmanagement.ejb.util.MD5Encoder;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (!isUserValid(user)) {
            response.sendRedirect("registration.jsp");
        }

        userService.saveUser(getUser(username, password));

        response.sendRedirect("login.jsp");
    }

    private User getUser(String username, String password) {
        MD5Encoder encoder = new MD5Encoder();

        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUsername(username);
        authority.setUser(user);

        user.setAuthority(authority);

        return user;
    }

    private boolean isUserValid(User user) {
        boolean valid = true;

        String username = user.getUsername();
        String password = user.getPassword();

        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            return valid;
        }

        return !valid;
    }
}
