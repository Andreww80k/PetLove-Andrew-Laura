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
        console.log(respuesta);
        if (respuesta.length != 0) {
          if (respuesta[0].contrasena_usuario == contrasena) {
            if (correo.endsWith('@gmail.com')) {
              window.location.href = 'Cliente/clienteprincipal.html'; // Redireccionar a la página del cliente
            } else if (correo.endsWith('@professionalgrooming.com')) {
              window.location.href = 'Veterinario/veterinarioprincipal.html'; // Redireccionar a la página del veterinario
            } else if (correo.endsWith('@petlove.com')) {
              alert('Correo electrónico encontrado ¡Navegue feliz!');
              window.location.href = 'Admin/adminprincipal.html'; // Redireccionar a la página del administrador
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