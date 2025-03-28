<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>${accion} Registro de Correo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validation.js"></script>
  </head>
  <body>
    <div class="container">
      <h1>${accion} Registro de Correo</h1>
      <form:form method="post" modelAttribute="correo" 
                 action="${pageContext.request.contextPath}/${accion == 'Editar' ? 'actualizar' : 'guardar'}"
                 onsubmit="return validarFormulario();">
        <form:hidden path="id" />

        <div class="form-group">
          <form:label path="nombre">Nombre:</form:label>
          <form:input path="nombre" id="nombre" />
          <form:errors path="nombre" cssClass="error"/>
        </div>

        <div class="form-group">
          <form:label path="correoElectronico">Correo:</form:label>
          <form:input path="correoElectronico" id="correoElectronico" />
          <form:errors path="correoElectronico" cssClass="error"/>
        </div>

        <div class="form-group">
          <form:label path="tipoCorreo.id">Tipo de Correo:</form:label>
          <form:select path="tipoCorreo.id" id="nIdTipoCorreo">
              <form:option value="" label="Seleccione..." />
              <form:options items="${listaTipos}" itemValue="id" itemLabel="nombreTipo" />
          </form:select>
          <form:errors path="tipoCorreo" cssClass="error"/>
        </div>

        <div class="form-group">
          <button type="submit" class="btn">
            <c:choose>
              <c:when test="${accion == 'Editar'}">Actualizar</c:when>
              <c:otherwise>Guardar</c:otherwise>
            </c:choose>
          </button>
          <a href="${pageContext.request.contextPath}/" class="btn">Cancelar</a>
        </div>
      </form:form>
    </div>
  </body>
</html>
