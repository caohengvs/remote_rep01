package com.caoheng.www.servlet;

import com.caoheng.www.service.Service;
import com.caoheng.www.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double money = Double.valueOf(request.getParameter("money"));
        ServiceImpl service = new ServiceImpl();


        if (name != null) {
            if (service.update(id,name,money) > 0) {
                response.sendRedirect("/day11/admin");
            }
        }
    }
}
