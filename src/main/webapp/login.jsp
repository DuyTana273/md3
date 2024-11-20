<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <%--  Nhúng CSS  --%>
    <link rel="stylesheet" href="css/index.css">

    <%--  BOOTSTRAP --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
<!-- Gọi navbar -->
<jsp:include page="common-index/navbar.jsp" />

<div class="container">
    <h1>Login</h1>

    <%-- Kiểm tra và hiển thị thông báo lỗi từ session nếu có --%>
    <c:if test="${not empty sessionScope.errorMessage}">
        <div class="alert alert-danger">
            <c:out value="${sessionScope.errorMessage}"/>
        </div>
        <%-- Sau khi hiển thị thông báo lỗi, xóa nó khỏi session --%>
        <c:remove var="errorMessage"/>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required placeholder="Nhập tài khoản">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Nhập mật khẩu">
        </div>
        <button type="submit">Login</button>
    </form>
    <div class="extra-options">
        <p>Don't have an account? <a href="#">Đăng ký tại đây</a>.</p>
    </div>
</div>

<%--  BOOTSTRAP --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
