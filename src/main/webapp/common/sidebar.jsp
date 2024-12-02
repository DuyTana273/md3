<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SideBar</title>

  <!-- CSS Links -->
  <link href="../css/sidebar.css" rel="stylesheet">
  <%-- BOOTSTRAP --%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

  <link href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" rel="stylesheet">
</head>
<body id="body-pd">
<!-- Header -->
<header id="header" class="header">
  <div class="header_toggle">
    <i class='bx bx-menu' id="header-toggle"></i>
  </div>

  <!-- User Section -->
  <div class="user-actions d-flex align-items-center">

    <!-- User is logged in -->
    <c:if test="${not empty sessionScope.loggedInUser}">
      <div class="d-flex align-items-center me-3">
        <img src="${sessionScope.loggedInUser.avatar}" alt="avatar" class="rounded-circle border" width="40px">
        <a href="${pageContext.request.contextPath}/users?action=viewUser&username=${sessionScope.loggedInUser.username}" class="ms-2 text-dark fw-semibold text-decoration-none">
            ${sessionScope.loggedInUser.fullName}
        </a>
      </div>
      <button type="button" class="btn btn-outline-primary btn-sm d-flex align-items-center" data-bs-toggle="modal" data-bs-target="#logoutModal">
        <i class="fas fa-sign-out-alt me-2"></i> Đăng Xuất
      </button>
    </c:if>

    <!-- User is not logged in -->
    <c:if test="${empty sessionScope.loggedInUser}">
      <a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-outline-primary btn-sm me-2">Đăng Nhập</a>
      <a href="${pageContext.request.contextPath}/register.jsp" class="btn btn-outline-primary btn-sm">Đăng Ký</a>
    </c:if>
  </div>
</header>

  <!-- Sidebar Navigation -->
  <div class="l-navbar" id="nav-bar">
    <nav class="nav">
      <div>
        <!-- Logo -->
        <a href="../index.jsp" class="nav_logo">
          <img src="../img/Logo.png" alt="Logo" width="30px">
          <span class="nav_logo-name">TanaShop</span>
        </a>

        <!-- Navigation Links -->
        <div class="nav_list">
          <a href="${pageContext.request.contextPath}/dashboard" class="nav_link">
            <i class='bx bx-grid-alt nav_icon'></i>
            <span class="nav_name">Dashboard</span>
          </a>
          <a href="${pageContext.request.contextPath}/users?action=listUsers" class="nav_link">
            <i class='bx bx-user nav_icon'></i>
            <span class="nav_name">Users</span>
          </a>
          <a href="${pageContext.request.contextPath}/categories?action=listCategories" class="nav_link">
            <i class='bx bx-message-square-detail nav_icon'></i>
            <span class="nav_name">Category</span>
          </a>
          <a href="#" class="nav_link">
            <i class='bx bx-bookmark nav_icon'></i>
            <span class="nav_name">Bookmark</span>
          </a>
          <a href="#" class="nav_link">
            <i class='bx bx-folder nav_icon'></i>
            <span class="nav_name">Files</span>
          </a>
          <a href="#" class="nav_link">
            <i class='bx bx-bar-chart-alt-2 nav_icon'></i>
            <span class="nav_name">Stats</span>
          </a>
        </div>
      </div>

      <!-- Sign Out -->
      <a href="#" class="nav_link" data-bs-toggle="modal" data-bs-target="#logoutModal">
        <i class='bx bx-log-out nav_icon'></i>
        <span class="nav_name">SignOut</span>
      </a>
    </nav>
  </div>

  <!-- Logout Modal -->
  <div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="logoutModalLabel">Đang đăng xuất...</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          Bạn có chắc chắn muốn đăng xuất khỏi tài khoản này không?
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
          <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Đăng Xuất</a>
        </div>
      </div>
    </div>
  </div>
  <!-- JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    document.addEventListener("DOMContentLoaded", function(event) {
      const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId),
                nav = document.getElementById(navId),
                bodypd = document.getElementById(bodyId),
                headerpd = document.getElementById(headerId);

        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
          toggle.addEventListener('click', () => {
            // Show navbar
            nav.classList.toggle('show');
            // Change icon
            toggle.classList.toggle('bx-x');
            // Add padding to body
            bodypd.classList.toggle('body-pd');
            // Add padding to header
            headerpd.classList.toggle('body-pd');
          });
        }
      };

      showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header');

      /*===== LINK ACTIVE =====*/
      const linkColor = document.querySelectorAll('.nav_link');

      function colorLink() {
        if (linkColor) {
          linkColor.forEach(l => l.classList.remove('active'));
          this.classList.add('active');
        }
      }
      linkColor.forEach(l => l.addEventListener('click', colorLink));
    });
  </script>
</body>
</html>
