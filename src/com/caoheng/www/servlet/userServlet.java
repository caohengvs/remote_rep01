package com.caoheng.www.servlet;

import com.caoheng.www.entity.Bank;
import com.caoheng.www.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        ServiceImpl service = new ServiceImpl();
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        if (cookies!= null) {
            for (Cookie cookie : cookies) {
                if ("userInfo".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    String[] str = value.split("#");
                    Bank bank = service.select(str[0]);
                    if (bank != null) {
                        request.setAttribute("user", bank);
                        request.getRequestDispatcher("user/list.jsp").forward(request,response);
                    }
                }
            }
        }






    }
}
