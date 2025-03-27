<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>${accion} Registro de Correo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validation.js"></script>
    <script type="text/javascript">
      function validarFormulario(){
        var nombre = document.getElementById("sNombre").value;
        var correo = document.getElementById("sCorreo").value;
        if(nombre.trim() === "" || correo.trim() === ""){
          alert("Los campos 'Nombre' y 'Correo' son obligatorios.");
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <div class="container">
      <h1>${accion} Registro de Correo</h1>
      <form action="${pageContext.request.contextPath}/${accion == 'Editar' ? 'actualizar' : 'guardar'}" method="post" onsubmit="return validarFormulario();">
        <input type="hidden" name="nId" value="${correo.nId}">

        <div class="form-group">
          <label for="sNombre">Nombre:</label>
          <input type="text" id="sNombre" name="sNombre" value="${correo.sNombre}" required />
        </div>

        <div class="form-group">
          <label for="sCorreo">Correo:</label>
          <input type="email" id="sCorreo" name="sCorreo" value="${correo.sCorreo}" required />
        </div>

        <div class="form-group">
          <label for="nIdTipoCorreo">Tipo de Correo:</label>
          <select id="nIdTipoCorreo" name="nIdTipoCorreo">
            <option value="">Seleccione...</option>
            <c:forEach var="tipo" items="${listaTipos}">
              <option value="${tipo.nId}" ${correo.nIdTipoCorreo == tipo.nId ? 'selected' : ''}>${tipo.sTipoCorreo}</option>
            </c:forEach>
          </select>
        </div>

        <div class="form-group">
          <button type="submit" class="btn">${accion == 'Editar' ? 'Actualizar' : 'Guardar'}</button>
          <a href="${pageContext.request.contextPath}/" class="btn">Cancelar</a>
        </div>
      </form>
    </div>
  </body>
</html>