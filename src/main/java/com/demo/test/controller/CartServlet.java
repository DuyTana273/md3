package com.demo.test.controller;

import com.demo.test.service.cart.CartService;
import com.demo.test.service.cart.ICartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private ICartService iCartService;

    @Override
    public void init() throws ServletException {
        iCartService = new CartService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "listCarts";
        }
        switch (action) {
            case "viewCart":
                viewCart(req, resp);
                break;
//            case "createUser":
//                showCreateForm(req, resp);
//                break;
//            case "updateUser":
//                showUpdateForm(req, resp);
//                break;
//            case "deleteUser":
//                deleteUser(req, resp);
//                break;
//            default:
//                listUsers(req, resp);
//                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listUsers";
        }
//        switch (action) {
//            case "createUser":
//                createUser(req, resp);
//                break;
//            case "updateUser":
//                updateUser(req, resp);
//                break;
//            case "deleteUser":
//                deleteUser(req, resp);
//                break;
//        }
    }

    private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }


}
