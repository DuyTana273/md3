<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
</head>
<body>
<!-- Sidebar -->
<jsp:include page="common/sidebar.jsp" />

<!-- Toast -->
<jsp:include page="common/toast.jsp" />

<!-- Main Content -->
<div class="main-content" style="margin-top: 4rem">
    <h1>Chào mừng bạn đến với TanaShop!</h1>
    <p>Đây là trang chủ của ứng dụng.</p>
</div>
</body>
</html>
