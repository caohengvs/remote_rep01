package com.caoheng.www.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",value = "/login.html")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");

        if (id != null) {
            if (id == 1) {
                response.sendRedirect("/day11/admin");
            }else {
                response.sendRedirect("/day11/user");
            }
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    if ("userInfo".equals(name)) {
                        String value = cookie.getValue();
                        String[] split = value.split("#");
                        Integer userId = Integer.valueOf(split[1]);
                        session.setAttribute("id", userId);
                        if (userId == 1){
                            response.sendRedirect("/day11/admin");
                        }else {
                            response.sendRedirect("/day11/user");
                        }
                    }

                }

            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
