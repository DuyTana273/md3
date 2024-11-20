<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Danh sách người dùng</title>

    <%--  BOOTSTRAP --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<!-- Gọi navbar -->
<jsp:include page="../../common-index/navbar.jsp" />

  <h1>Danh Sách Người Dùng</h1>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Tài khoản</th>
        <th scope="col">Email</th>
        <th scope="col">Họ và Tên</th>
        <th scope="col">Quyền</th>
      </tr>
      </thead>
      <tbody class="table-group-divider">
      <c:forEach var="user" items="${listUsers}">
        <tr>
          <th scope="row">${user.userID}</th>
          <td>${user.username}</td>
          <td>${user.email}</td>
          <td>${user.fullName}</td>
          <td>${user.userRole}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  <%--  BOOTSTRAP --%>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
