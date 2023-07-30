function eliminarProveedorPorCorreo(correo) {
    $.ajax({
        url: "http://localhost:8080/eliminarProveedorCorreo/" + correo,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Proveedor eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar el proveedor");
        }
    });
}

function selectCorreo(){
    const correoselect = document.querySelector("#correoEliminar");
    correoselect.innerHTML = "<option value='Seleccione Correo a Eliminar'>Correo A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarProveedores",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(proveedor => {
                correoselect.innerHTML += '<option value="' + proveedor['correo_proveedor'] +'">' + proveedor['correo_proveedor'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectCorreo();
    const eliminarProveedorBtn = $("#eliminarProveedorBtn");
    const correoselect = $("#correoEliminar");

    eliminarProveedorBtn.click(function(event) {
        event.preventDefault();
    
        const correoseleccionado = correoselect.val();
        console.log(correoseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarCorreoProveedor/" + correoseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar al proveedor existente?")) {
                        eliminarProveedorPorCorreo(correoseleccionado);
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
