<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <%--  Nhúng CSS  --%>

    <%--  BOOTSTRAP --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body id="body-pd">
<!-- Gọi Sidebar -->
<jsp:include page="common/sidebar.jsp" />

<!-- Gọi Toast -->
<%@ include file="common/toast.jsp" %>

<!-- Main Content -->
<div class="main-content">
    <div class="container">
        <h1 class="mb-4">Đăng ký</h1>
        <form action="${pageContext.request.contextPath}/register" method="post" class="bg-white p-4 shadow rounded">
            <div class="form-group mb-3">
                <label for="username" class="form-label">Tài khoản:</label>
                <input type="text" id="username" name="username" class="form-control" value="${username}" required placeholder="Nhập tài khoản">
            </div>
            <div class="form-group mb-3">
                <label for="password" class="form-label">Mật khẩu:</label>
                <input type="password" id="password" name="password" class="form-control" value="${password}" required placeholder="Nhập mật khẩu">
            </div>
            <div class="form-group mb-3">
                <label for="fullName" class="form-label">Tên:</label>
                <input type="text" id="fullName" name="fullName" class="form-control" value="${fullName}" required placeholder="Nhập họ và tên">
            </div>
            <div class="form-group mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="text" id="email" name="email" class="form-control" value="${email}" required placeholder="Nhập email">
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
        </form>
        <div class="extra-options mt-3">
            <p>Don't have an account? <a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập tại đây</a>.</p>
        </div>
    </div>
</div>

</body>

</html>
