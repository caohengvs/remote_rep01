package com.caoheng.www.servlet;

import com.caoheng.www.entity.Register;
import com.caoheng.www.service.Service;
import com.caoheng.www.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String usernamepassword = request.getParameter("usernamepassword");

        if (username != null && username.trim().length() != 0) {
            if (usernamepassword != null && usernamepassword.trim().length() != 0) {
                ServiceImpl service = new ServiceImpl();
                List<Register> list = service.check();
                if (list != null) {

                    for (Register register : list) {
                        if (register.getUsername().equals(username) && register.getUserpassword().equals(usernamepassword)) {

                            HttpSession session = request.getSession();
                            session.setAttribute("id", register.getId());

                            Cookie cookie = new Cookie("userInfo", username + "#" + register.getId());
                            cookie.setPath("/");
                            cookie.setMaxAge(60 * 60 * 24 * 7);
                            response.addCookie(cookie);
                            if (register.getId() == 1) {
                                response.sendRedirect("/day11/admin");
                                break;
                            } else if (register.getId() == 2) {
                                response.sendRedirect("/day11/user ");
                                break;
                            }
                        }
                    }
                }

            }
        }
    }
}
