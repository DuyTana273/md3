package com.demo.test.controller;

import com.demo.test.repository.categories.CategoriesRepo;
import com.demo.test.repository.categories.ICategoriesRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "categories", urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
    private  ICategoriesRepo iCategoriesRepo;

    @Override
    public void init() {
        iCategoriesRepo = new CategoriesRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
    }
}
