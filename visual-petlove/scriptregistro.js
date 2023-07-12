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
    const nombre = $('#nombre');
    const apellido = $('#apellido');
    const direccion = $('#direccion');
    const telefono = $('#telefono');
    const correo = $('#correo');
    const contrasena = $('#contrasena');
    const rolselect = $("#rolselect");

    GuardaUsuario.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = nombre.val();
        const apellidoseleccionado = apellido.val();
        const direccionseleccionado = direccion.val();
        const telefonoseleccionado = telefono.val();
        const correoseleccionado = correo.val();
        const contrasenaseleccionado = contrasena.val();
        const rolseleccionado = rolselect.val();

        $.ajax({
            url: "http://localhost:8080/AgregarUsuario/" + rolseleccionado,
            type: "POST",
            dataType: "JSON",
            success: function(response) {
                console.log(response)
                console.log("Agregado")
            },
        });
    });
});