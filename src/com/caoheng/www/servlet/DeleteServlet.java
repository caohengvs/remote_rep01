package com.caoheng.www.servlet;

import com.caoheng.www.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        String name = (String) request.getParameter("name");
        if (name != null) {
            if (service.delete(name) > 0) {
                response.sendRedirect("/day11/admin");
            }
        }
    }
}
