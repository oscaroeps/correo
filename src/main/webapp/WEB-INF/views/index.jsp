<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Listado de Correos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validation.js"></script>
  </head>
  <body>
    <div class="container">
      <h1>Listado de Correos</h1>

      <div class="actions">
        <a href="${pageContext.request.contextPath}/nuevo" class="btn">Nuevo Registro</a>
        <a href="${pageContext.request.contextPath}/reporte" class="btn">Descargar Reporte</a>
      </div>

      <table class="table">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Tipo de Correo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="correo" items="${listaCorreos}">
            <tr>
              <td>${correo.nombre}</td>
              <td>${correo.correoElectronico}</td>
              <td>${correo.tipoCorreo != null ? correo.tipoCorreo.nombreTipo : 'No especificado'}</td>
              <td>
                <a href="${pageContext.request.contextPath}/editar?id=${correo.id}" class="btn">Modificar</a>
                <a href="${pageContext.request.contextPath}/eliminar?id=${correo.id}" class="btn" onclick="return confirm('¿Está seguro de eliminar este registro?');">Borrar</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
