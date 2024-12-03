package com.demo.test.controller;

import com.demo.test.model.Categories;
import com.demo.test.model.User;
import com.demo.test.repository.categories.CategoriesRepo;
import com.demo.test.repository.categories.ICategoriesRepo;
import com.demo.test.service.categories.CategoriesService;
import com.demo.test.service.categories.ICategoriesService;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet (name = "categories", urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
    private IUserService iUserService;
    private ICategoriesService iCategoriesService;

    @Override
    public void init() {
        iUserService = new UserService();
        iCategoriesService = new CategoriesService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "listCategories";
        }
        switch (action) {
            case "createCategories":
                showCreateForm(req, resp);
                break;
            case "updateCategories":
                showUpdateForm(req, resp);
                break;
//            case "deleteCategories":
//                deleteCategories(req, resp);
//                break;
            default:
                listCategories(req, resp);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listCategories";
        }
        switch (action) {
            case "createCategories":
                createCategories(req, resp);
                break;
            case "updateCategories":
                updateCategories(req, resp);
                break;
//            case "deleteCategories":
//                deleteCategories(req, resp);
//                break;
        }
    }

    private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {

            if ("customer".equals(loggedInUser.getUserRole())) {
                session.setAttribute("warningMessage", "Bạn không có quyền truy cập vào trang này!");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }

            List<Categories> listCategories = iCategoriesService.findAllCategories();
            req.setAttribute("listCategories", listCategories);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/categories/listCategories.jsp");
            dispatcher.forward(req, resp);
        } else {
            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền tạo danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        if ("employee".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền tạo danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }
        req.getRequestDispatcher(req.getContextPath() + "/dashboard/categories/createCategories.jsp").forward(req, resp);
    }

    private void createCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String categories_name = req.getParameter("categories_name");
        String categories_img = req.getParameter("categories_img");

        Categories newCategories = new Categories();
        newCategories.setCategories_name(categories_name);
        newCategories.setCategories_img(categories_img);
        newCategories.setCategories_createdDate(LocalDateTime.now());
        newCategories.setCategories_updatedDate(LocalDateTime.now());

        try {
            iCategoriesService.addCategories(newCategories);
            session.setAttribute("successMessage", "Tạo danh mục mới thành công");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Đã xảy ra lỗi khi tạo danh mục sản phẩm");
            req.getRequestDispatcher("/dashboard/categories/listCategories.jsp").forward(req, resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String categories_name = req.getParameter("categories_name");
        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền cập nhật danh mục sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        Optional<Categories> categoriesToUpdate = iCategoriesService.findCategoriesByName(categories_name);
        if (categoriesToUpdate.isEmpty()) {
            session.setAttribute("errorMessage", "Thương hiệu không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Categories categories = categoriesToUpdate.get();
        req.setAttribute("categories_name", categories.getCategories_name());
        req.setAttribute("categories_img", categories.getCategories_img());

        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/dashboard/categories/updateCategories.jsp").forward(req, resp);
    }

    private void updateCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        String categories_name = req.getParameter("categories_name");
        String categories_img = req.getParameter("categories_img");

        Optional<Categories> categoriesToUpdate = iCategoriesService.findCategoriesByName(categories_name);
        if (categoriesToUpdate.isEmpty()) {
            session.setAttribute("errorMessage", "Thương hiệu không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
            return;
        }

        Categories newCategories = categoriesToUpdate.get();
        newCategories.setCategories_name(categories_name);
        newCategories.setCategories_img(categories_img);
        newCategories.setCategories_updatedDate(LocalDateTime.now());

        try {
            iCategoriesService.updateCategories(newCategories);
            session.setAttribute("successMessage", "Chỉnh sửa thương hiệu thành công");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Xảy ra lỗi khi cập nhật thương hiệu");
            resp.sendRedirect(req.getContextPath() + "/categories?action=listCategories");
        }
    }
}
