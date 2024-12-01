package com.demo.test.controller;

import com.demo.test.model.User;
import com.demo.test.service.user.IUserService;
import com.demo.test.service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "dashboard", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {
    private IUserService iUserService;

    @Override
    public void init() throws ServletException {
        iUserService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("loggedInUser") != null) {
            User loggedInUser = (User) session.getAttribute("loggedInUser");

            if ("customer".equals(loggedInUser.getUserRole())) {
                session.setAttribute("warningMessage", "Bạn không có quyền truy cập vào trang này!");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/dashboard.jsp");
            dispatcher.forward(req, resp);
        } else {
            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
