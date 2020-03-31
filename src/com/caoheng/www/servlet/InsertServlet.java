package com.caoheng.www.servlet;

import com.caoheng.www.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double money = Double.valueOf(request.getParameter("money"));

        if (service.insert(id, name, money) > 0) {
            response.sendRedirect("/day11/admin");
        }
    }
}
