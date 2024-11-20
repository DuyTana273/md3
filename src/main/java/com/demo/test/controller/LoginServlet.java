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
import java.util.Optional;

@WebServlet (name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private IUserService iUserService;

    @Override
    public void init() throws ServletException {
        iUserService = new UserService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("Đang cố gắng đăng nhập với username: " + username);  // Log username đầu vào

        try {
            Optional<User> loginUser = iUserService.findUserByUsernameAndPassword(username, password);
            HttpSession session = req.getSession(true);

            if (loginUser.isPresent()) {
                session.setAttribute("loggedInUser", loginUser.get());
                session.setAttribute("successMessage", "Đăng nhập thành công!");
                resp.sendRedirect(req.getContextPath() + "/users?action=listUsers");
            } else {
                session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu! Vui lòng thử lại!");
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log exception chi tiết
//            session.setAttribute("errorMessage", "Đã xảy ra lỗi trong quá trình xử lý. Vui lòng thử lại sau.");
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
