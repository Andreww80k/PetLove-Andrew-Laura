function eliminarRolUsuarioPorNombre(nombre) {
    $.ajax({
        url: "http://localhost:8080/eliminarRolUsuarioNombre/" + nombre,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Rol eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar el Rol");
        }
    });
}

function selectNombre(){
    const nombreselect = document.querySelector("#rolEliminarNombre");
    nombreselect.innerHTML = "<option value='Seleccione Nombre a Eliminar'>Nombre A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarRolUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(rol_usuario => {
                nombreselect.innerHTML += '<option value="' + rol_usuario['nombre_rol_usuario'] +'">' + rol_usuario['nombre_rol_usuario'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectNombre();
    const eliminarRolUsuarioNombreBtn = $("#eliminarRolUsuarioNombreBtn");
    const nombreselect = $("#rolEliminarNombre");

    eliminarRolUsuarioNombreBtn.click(function(event) {
        event.preventDefault();
    
        const nombreseleccionado = nombreselect.val();
        console.log(nombreseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarNombreRol/" + nombreseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar el rol existente?")) {
                        eliminarRolUsuarioPorNombre(nombreseleccionado);
                    }
                } else {
                    alert("No existe en la base de datos")
                }
            },
            error: function(error) {
                console.error(error);
                alert("Error al verificar existencia en la base de datos");
            }
        });
    });
});