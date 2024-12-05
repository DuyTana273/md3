package com.demo.test.controller;

import com.demo.test.model.Categories;
import com.demo.test.model.Product;
import com.demo.test.model.User;
import com.demo.test.service.categories.CategoriesService;
import com.demo.test.service.categories.ICategoriesService;
import com.demo.test.service.product.IProductService;
import com.demo.test.service.product.ProductService;

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

@WebServlet(name = "product", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService iProductService;
    private ICategoriesService iCategoriesService;

    @Override
    public void init() throws ServletException {
        iProductService = new ProductService();
        iCategoriesService = new CategoriesService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "listProducts";
        }
        switch (action) {
            case "viewProduct":
                viewProduct(req, resp);
                break;
            case "createProduct":
                showCreateForm(req, resp);
                break;
//            case "updateProduct":
//                showUpdateForm(req, resp);
//                break;
//            case "deleteProduct":
//                deleteProduct(req, resp);
//                break;
            default:
                listProducts(req, resp);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "listProducts";
        }
        switch (action) {
            case "createProduct":
                createProduct(req, resp);
                break;
//            case "updateProduct":
//                updateProduct(req, resp);
//                break;
//            case "deleteProduct":
//                deleteProduct(req, resp);
//                break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {

            if ("customer".equals(loggedInUser.getUserRole())) {
                session.setAttribute("warningMessage", "Bạn không có quyền truy cập vào trang này!");
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }

            List<Product> listProducts = iProductService.findAllProducts();
            req.setAttribute("listProducts", listProducts);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard/products/listProducts.jsp");
            dispatcher.forward(req, resp);
        } else {
            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    private void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("warningMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền xem thông tin sản phẩm ở dashboard!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        String product_name = req.getParameter("product_name");
        Optional<Product> productToView = iProductService.findProductByName(product_name);
        if (productToView.isEmpty()) {
            session.setAttribute("errorMessage", "Sản phẩm không tồn tại");
            resp.sendRedirect(req.getContextPath() + "/product?action=listProducts");
            return;
        }

        Product product = productToView.get();
        try {
            req.setAttribute("product", product);
            req.getRequestDispatcher("/dashboard/products/viewProduct.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Đã xảy ra lỗi khi xem thông tin sản phẩm!");
            resp.sendRedirect(req.getContextPath() + "/users?action=listUsers");
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        if ("customer".equals(loggedInUser.getUserRole())) {
            session.setAttribute("warningMessage", "Bạn không có quyền thêm sản phẩm ở Dashboard!");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }

        List<Categories> categories = iCategoriesService.findAllCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher(req.getContextPath() + "/dashboard/products/createProduct.jsp").forward(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        List<Categories> categories = iCategoriesService.findAllCategories();

        if (loggedInUser == null) {
            session.setAttribute("errorMessage", "Bạn cần phải đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        String product_name = req.getParameter("product_name");
        double product_price = Double.parseDouble(req.getParameter("product_price"));
        int product_stock = Integer.parseInt(req.getParameter("product_stock"));
        String categories_name = req.getParameter("categories_name");

        Optional<Product> checkProduct = iProductService.findProductByName(product_name);
        if (checkProduct.isPresent()) {
            session.setAttribute("errorMessage", "Sản phẩm này đã tồn tại");
            req.setAttribute("product_name", product_name);
            req.setAttribute("product_price", product_price);
            req.setAttribute("product_stock", product_stock);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/dashboard/products/createProduct.jsp").forward(req, resp);
            return;
        }

        if (product_price <= 0 || product_stock <= 0) {
            session.setAttribute("warningMessage", "Giá hoặc số lượng phải lớn hơn 0");
            req.setAttribute("product_name", product_name);
            req.setAttribute("product_price", product_price);
            req.setAttribute("product_stock", product_stock);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/dashboard/products/createProduct.jsp").forward(req, resp);
            return;
        }

        System.out.println("Selected Category: " + categories_name);

        Product newProduct = new Product();
        newProduct.setProduct_name(product_name);
        newProduct.setProduct_price(product_price);
        newProduct.setProduct_stock(product_stock);
        newProduct.setCategories_name(categories_name);
        newProduct.setProduct_createdDate(LocalDateTime.now());
        newProduct.setProduct_updateDate(LocalDateTime.now());

        try {
            iProductService.addProduct(newProduct);
            session.setAttribute("successMessage", "Tạo sản phẩm mới thành công");
            resp.sendRedirect(req.getContextPath() + "/product?action=listProducts");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Có lỗi khi thêm mới sản phẩm");
            req.getRequestDispatcher(req.getContextPath() + "/product?action=listProducts").forward(req, resp);
        }
    }



}
