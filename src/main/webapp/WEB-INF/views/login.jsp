<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
  </head>
  <body>
    <div class="container">
      <h1>Iniciar Sesión</h1>
      <form action="${pageContext.request.contextPath}/login" method="post">
        <!-- Agregar el token CSRF -->
        <sec:csrfInput/>
        <div class="form-group">
          <label for="username">Usuario:</label>
          <input type="text" id="username" name="username" required />
        </div>
        <div class="form-group">
          <label for="password">Contraseña:</label>
          <input type="password" id="password" name="password" required />
        </div>
        <div class="form-group">
          <button type="submit" class="btn">Entrar</button>
        </div>
        <c:if test="${param.error != null}">
          <div class="error">Usuario o contraseña incorrectos.</div>
        </c:if>
        <c:if test="${param.logout != null}">
          <div class="message">Ha cerrado sesión exitosamente.</div>
        </c:if>
      </form>
    </div>
  </body>
</html>
