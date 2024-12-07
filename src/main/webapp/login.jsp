<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <%--  Nhúng CSS  --%>

    <%--  BOOTSTRAP --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
<!-- Gọi Sidebar -->
<jsp:include page="common/sidebar.jsp" />

<!-- Gọi Toast -->
<%@ include file="common/toast.jsp" %>

<!-- Main Content -->
<div class="main-content" style="margin-top: 4rem">
    <div class="container">
        <h1 class="mb-4">Đăng nhập</h1>
        <form action="${pageContext.request.contextPath}/login" method="post" class="bg-white p-4 shadow rounded">
            <div class="form-group mb-3">
                <label for="username" class="form-label">Tài khoản:</label>
                <input type="text" id="username" name="username" class="form-control" required placeholder="Nhập tài khoản">
            </div>
            <div class="form-group mb-3">
                <label for="password" class="form-label">Mật khẩu:</label>
                <input type="password" id="password" name="password" class="form-control" required placeholder="Nhập mật khẩu">
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>
        <div class="extra-options mt-3">
            <p>Don't have an account? <a href="${pageContext.request.contextPath}/register.jsp">Đăng ký tại đây</a>.</p>
        </div>
    </div>
</div>

</body>

</html>
