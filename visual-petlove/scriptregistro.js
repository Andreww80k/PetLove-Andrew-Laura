function selectRol(){
    const rolselect = document.querySelector("#rol");
    rolselect.innerHTML = "<option value='Seleccione Rol'>Rol A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarRolUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(rol => {
                rolselect.innerHTML += '<option value="' + rol['id_rol_usuario'] +'">' + rol['nombre_rol_usuario'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectRol();
    const GuardaUsuario = $("#GuardaUsuario");
    const rolselect = $("#rol");

    GuardaUsuario.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = $('#nombre').val();
        const apellidoseleccionado = $('#apellido').val();
        const direccionseleccionado = $('#direccion').val();
        const telefonoseleccionado = $('#telefono').val();
        const correoseleccionado = $('#correo').val();
        const contrasenaseleccionado = $('#contrasena').val();
        const rolseleccionado = rolselect.val();

        const usuario = {
            nombre_usuario: nombreseleccionado,
            apellido_usuario: apellidoseleccionado,
            direccion_usuario: direccionseleccionado,
            telefono_usuario: telefonoseleccionado,
            correo_usuario: correoseleccionado,
            contrasena_usuario: contrasenaseleccionado,
        };

        let envioDatos = JSON.stringify(usuario)

        $.ajax({
            url: "http://localhost:8080/AgregarUsuario/" + rolseleccionado, 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                console.log("Agregado");
                alert("Agregado");
                window.location.href = 'IniciodeSesion.html';
            }
        });
    });
});
