function validarFormulario(){
  var nombre = document.getElementById("nombre").value;
  var correoElectronico = document.getElementById("correoElectronico").value;
  var tipoCorreo = document.getElementById("nIdTipoCorreo").value;
  
  if(nombre.trim() === "" || correoElectronico.trim() === "" || tipoCorreo.trim() === ""){
      alert("Debe completar todos los campos, incluyendo seleccionar un Tipo de Correo.");
      return false;
  }
  return true;
}
