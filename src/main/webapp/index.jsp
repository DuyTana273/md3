<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <%--  Nhúng CSS  --%>

    <%--  BOOTSTRAP --%>

</head>
<body>
    <!-- Gọi sidebar -->
    <jsp:include page="common/sidebar.jsp" />
    <!-- Gọi toast -->
    <jsp:include page="common/toast.jsp" />

    <div class="main-content">Đây là trang chủ </div>

</body>
</html>
