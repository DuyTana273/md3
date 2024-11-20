<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Navbar</title>
    <%--  LINK CSS --%>
    <link href="../css/navbar.css" rel="stylesheet">

    <%--  BOOTSTRAP --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <%--  FONT AWESOME --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<header class="bg-white shadow-sm">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <div class="menu-toggle d-lg-none me-3" onclick="toggleSidebar()" style="cursor: pointer;">
            <i class="fas fa-bars fa-lg text-primary"></i>
        </div>

        <!-- Logo Section -->
        <h4 class="m-0 d-flex align-items-center">
            <a href="${pageContext.request.contextPath}/index.jsp" class="text-decoration-none text-dark d-flex align-items-center">
                <img src="../img/Logo.png" alt="Logo" class="me-2" style="height: 100px;">
            </a>
        </h4>

        <div class="d-flex align-items-center">
<%--            <c:if test="${not empty sessionScope.loggedInUser}">--%>
<%--                <span class="me-4 text-muted d-flex align-items-center">--%>
<%--                    <i class="fas fa-user-circle fa-2x me-2 text-primary"></i>--%>
<%--                    <a href="${pageContext.request.contextPath}/users?action=view&account=${sessionScope.loggedInUser.account}"--%>
<%--                       class="text-decoration-none text-dark">--%>
<%--                        <strong class="fs-4">${sessionScope.loggedInUser.account}</strong>--%>
<%--                    </a>--%>
<%--                </span>--%>

<%--                <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-primary btn-md d-flex align-items-center"--%>
<%--                   onclick="return confirm('Bạn có chắc chắn muốn đăng xuất?')">--%>
<%--                    <i class="fas fa-sign-out-alt me-2"></i>--%>
<%--                    Đăng Xuất--%>
<%--                </a>--%>
<%--            </c:if>--%>

<%--            <c:if test="${empty sessionScope.loggedInUser}">--%>
                <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-outline-primary btn-md me-2">Đăng Nhập</a>
                <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary btn-md">Đăng Ký</a>
<%--            </c:if>--%>

            <!-- Biểu tượng mạng xã hội -->
            <div class="social-icons d-flex ms-3">
                <a href="#" class="text-decoration-none me-2"><i class="fab fa-facebook-f fa-lg"></i></a>
                <a href="#" class="text-decoration-none me-2"><i class="fab fa-twitter fa-lg"></i></a>
                <a href="#" class="text-decoration-none me-2"><i class="fab fa-instagram fa-lg"></i></a>
                <a href="#" class="text-decoration-none"><i class="fab fa-linkedin-in fa-lg"></i></a>
            </div>
        </div>
    </div>
</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
