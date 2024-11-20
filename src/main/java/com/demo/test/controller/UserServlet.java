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
import java.io.IOException;
import java.util.List;

@WebServlet (name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private IUserService iUserService;

    @Override
    public void init() throws ServletException {
        iUserService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "listUsers";
        }
        switch (action) {
            case "viewUser":
                viewUser(req, resp);
                break;
            case "listUsers":
                listUsers(req, resp);
                break;
            case "createUser":
                createUser(req, resp);
                break;
            case "editUser":
                editUser(req, resp);
                break;
            case "deleteUser":
                deleteUser(req, resp);
                break;
            default:
                listUsers(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listUsers";
        }
        switch (action) {
            case "createUser":
                createUser(req, resp);
                break;
            case "editUser":
                editUser(req, resp);
                break;
            default:
                listUsers(req, resp);
                break;
        }
    }

    private void listUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> listUsers = iUserService.findAllUsers();
        req.setAttribute("listUsers", listUsers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/users/listUsers.jsp");
        dispatcher.forward(req, resp);
    }
    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void viewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
