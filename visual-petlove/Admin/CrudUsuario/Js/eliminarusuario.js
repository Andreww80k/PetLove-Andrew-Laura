function eliminarUsuarioPorCorreo(correo) {
    $.ajax({
        url: "http://localhost:8080/eliminarUsuarioCorreo/" + correo,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Usuario eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar el usuario");
        }
    });
}

function selectCorreo(){
    const correoselect = document.querySelector("#correoEliminar");
    correoselect.innerHTML = "<option value='Seleccione Correo a Eliminar'>Correo A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(usuario => {
                correoselect.innerHTML += '<option value="' + usuario['correo_usuario'] +'">' + usuario['correo_usuario'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectCorreo();
    const eliminarUsuarioBtn = $("#eliminarUsuarioBtn");
    const correoselect = $("#correoEliminar");

    eliminarUsuarioBtn.click(function(event) {
        event.preventDefault();
    
        const correoseleccionado = correoselect.val();
        console.log(correoseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarUsuarioEmail/" + correoseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar al usuario existente?")) {
                        eliminarUsuarioPorCorreo(correoseleccionado);
                    }
                } else {
                    alert("No existe en la base de datos")
                }
            },
            error: function(error) {
                console.error(error);
                alert("Error al verificar el correo electrónico en la base de datos");
            }
        });
    });    
});
