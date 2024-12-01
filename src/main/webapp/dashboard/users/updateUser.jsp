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
    <title>Edit User</title>
</head>
<body id="body-pd">
    <!-- Gọi sidebar -->
    <jsp:include page="../../common/sidebar.jsp" />
    <!-- Gọi toast -->
    <jsp:include page="../../common/toast.jsp" />

    <form action="${pageContext.request.contextPath}/users" method="post" style="margin-top: 100px">
        <div class="mb-3">
            <label for="fullName" class="form-label">Họ và tên</label>
            <input type="text" id="fullName" name="fullName" class="form-control" value="${user.fullName}">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" class="form-control" value="${user.email}">
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại</label>
            <input type="text" id="phone" name="phone" class="form-control" value="${user.phone}">
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <input type="text" id="address" name="address" class="form-control" value="${user.address}">
        </div>

        <div class="mb-3">
            <label for="avatar" class="form-label">Avatar (URL)</label>
            <input type="text" id="avatar" name="avatar" class="form-control" value="${user.avatar}">
        </div>

        <div class="mb-3">
            <label for="userStatus" class="form-label">Trạng thái</label>
            <select id="userStatus" name="userStatus" class="form-select">
                <option value="active" ${user.userStatus == 'active' ? 'selected' : ''}>Active</option>
                <option value="inactive" ${user.userStatus == 'suspended' ? 'selected' : ''}>Suspended</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="userRole" class="form-label">Vai trò</label>
            <select id="userRole" name="userRole" class="form-select">
                <option value="admin" ${user.userRole == 'admin' ? 'selected' : ''}>Admin</option>
                <option value="manager" ${user.userRole == 'manager' ? 'selected' : ''}>Manager</option>
                <option value="employee" ${user.userRole == 'employee' ? 'selected' : ''}>Employee</option>
                <option value="customer" ${user.userRole == 'customer' ? 'selected' : ''}>Customer</option>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary">Lưu Thay Đổi</button>
            <a href="${pageContext.request.contextPath}/users?action=listUsers" class="btn btn-secondary">Hủy</a>
        </div>
    </form>

</body>
</html>
