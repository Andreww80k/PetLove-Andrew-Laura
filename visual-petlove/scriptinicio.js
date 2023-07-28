$(document).ready(function () {
  $('.login').on('click', function (event) {
    event.preventDefault();
    let correo = $('#email').val();
    let contrasena = $('#password').val();
    $.ajax({
      url: "http://localhost:8080/BuscarUsuarioEmail/" + correo,
      type: "GET",
      datatype: "JSON",
      success: function (respuesta) {

        if (respuesta.length != 0) {
          if (respuesta[0].contrasena_usuario == contrasena) {

            let dato = {
              email: respuesta[0].correo_usuario
            };
    
            localStorage.setItem('dato', JSON.stringify(dato));

            if (correo.endsWith('.professional.grooming@gmail.com')) {
              alert('Correo electrónico encontrado ¡Navegue feliz!');
              window.location.href = 'Admin/adminprincipal.html'; // Redireccionar a la página del administrador
            } else {
              window.location.href = 'Cliente/clienteprincipal.html'; // Redireccionar a la página del cliente
            }
          } else {
            // Si no coincide con ninguno, se puede mostrar un mensaje de error o tomar otra acción
            alert('Contraseña o usuario incorrecto');
          }
        } else {
          // Si no coincide con ninguno, se puede mostrar un mensaje de error o tomar otra acción
          alert('Correo electrónico no encontrado');
        }
      }
    });
  });
});