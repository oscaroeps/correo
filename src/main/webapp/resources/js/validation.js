function validarFormularioGeneral(formId) {
  var form = document.getElementById(formId);
  var nombre = form.sNombre.value.trim();
  var correo = form.sCorreo.value.trim();
  if (nombre === "" || correo === "") {
    alert("Los campos 'Nombre' y 'Correo' son obligatorios.");
    return false;
  }
  return true;
  }