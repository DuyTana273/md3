<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <link rel="stylesheet" href="../css/toast.css">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<!-- Toast  -->
<div class="toast-container p-3" style="z-index: 9999; width: 400px;">
  <c:choose>
    <c:when test="${not empty sessionScope.successMessage}">
      <div class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">
            <c:out value="${sessionScope.successMessage}" />
          </div>
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
      </div>
      <c:remove var="successMessage" scope="session" />
    </c:when>
    <c:when test="${not empty sessionScope.errorMessage}">
      <div class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">
            <c:out value="${sessionScope.errorMessage}" />
          </div>
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
      </div>
      <c:remove var="errorMessage" scope="session" />
    </c:when>
    <c:when test="${not empty sessionScope.warningMessage}">
      <div class="toast align-items-center text-bg-warning border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">
            <c:out value="${sessionScope.warningMessage}" />
          </div>
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
      </div>
      <c:remove var="warningMessage" scope="session" />
    </c:when>
  </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    const toastElList = document.querySelectorAll('.toast');
    const toastList = [...toastElList].map(toastEl => {
      const toast = new bootstrap.Toast(toastEl, { delay: 5000 });

      let toastTimeout;

      toast.show();

      toastEl.addEventListener('mouseenter', () => {
        clearTimeout(toastTimeout);
        toast._element.classList.add('paused');
      });

      // Khi rời chuột, tiếp tục toast
      toastEl.addEventListener('mouseleave', () => {
        if (toast._element.classList.contains('paused')) {
          toastTimeout = setTimeout(() => toast.hide(), toast._config.delay);
          toast._element.classList.remove('paused');
        }
      });

      return toast;
    });

    toastList.forEach(toast => toast.show());
  });
</script>