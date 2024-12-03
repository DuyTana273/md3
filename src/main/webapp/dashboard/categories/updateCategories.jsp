<%@ page import="com.demo.test.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!-- Kiểm tra người dùng đã đăng nhập chưa -->
<c:if test="${empty sessionScope.loggedInUser}">
    <c:redirect url="${pageContext.request.contextPath}/login" />
</c:if>
<html>
<head>
    <title>Update Category</title>
</head>
<body id="body-pd">
<!-- Gọi sidebar -->
<jsp:include page="../../common/sidebar.jsp" />
<!-- Gọi toast -->
<jsp:include page="../../common/toast.jsp" />

<form action="${pageContext.request.contextPath}/categories?action=updateCategories" method="post" style="margin-top: 100px">
    <div class="mb-3">
        <label for="categories_name" class="form-label">Tên thương hiệu</label>
        <input type="text" id="categories_name" name="categories_name" class="form-control" value="${categories_name != null ? categories_name : categories.categories_name}" readonly>
    </div>

    <div class="mb-3">
        <label for="categories_img" class="form-label">Logo (URL)</label>
        <input type="text" id="categories_img" name="categories_img" class="form-control" value="${categories_img != null ? categories_img : categories.categories_img}">
    </div>
    

    <div class="mb-3">
        <label for="userCreatedDate" class="form-label">Ngày tạo tài khoản</label>
        <input type="text" id="userCreatedDate" name="userCreatedDate" class="form-control" value="${user.userCreatedDate}" readonly>
    </div>

    <div class="mb-3">
        <label for="userUpdatedDate" class="form-label">Ngày cập nhật tài khoản</label>
        <input type="text" id="userUpdatedDate" name="userUpdatedDate" class="form-control" value="${user.userUpdatedDate}" readonly>
    </div>

    <div class="d-flex justify-content-between">
        <button type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
        <a href="${pageContext.request.contextPath}/users?action=listUsers" class="btn btn-secondary">
            Quay lại
        </a>
    </div>
</form>

</body>
</html>
