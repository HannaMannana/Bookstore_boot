package com.belhard.bookstoreBoot.web.filters;

import com.belhard.bookstoreBoot.data.entity.User;
import com.belhard.bookstoreBoot.service.dto.UserDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Filter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserDto user = (UserDto) req.getSession().getAttribute("user");
        if (user == null) {
            res.sendRedirect("/login");
            return;
        }
        if (req.isUserInRole("ADMIN")){
            res.sendRedirect("/users/getAll");
        }
        User.Role role = user.getRoleType();
        if(!role.equals(User.Role.ADMIN)){
            res.sendRedirect("/error");
        }
        chain.doFilter(req, res);
    }
}
