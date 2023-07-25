function eliminarProductoPorNombre(nombre) {
    $.ajax({
        url: "http://localhost:8080/eliminarProductoNombre/" + nombre,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Producto eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar el producto");
        }
    });
}

function selectNombre(){
    const nombreselect = document.querySelector("#productoEliminarNombre");
    nombreselect.innerHTML = "<option value='Seleccione Nombre a Eliminar'>Nombre A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarProducto",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(producto => {
                nombreselect.innerHTML += '<option value="' + producto['nombre_producto'] +'">' + producto['nombre_producto'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectNombre();
    const eliminarProductoNombreBtn = $("#eliminarProductoNombreBtn");
    const nombreselect = $("#productoEliminarNombre");

    eliminarProductoNombreBtn.click(function(event) {
        event.preventDefault();
    
        const nombreseleccionado = nombreselect.val();
        console.log(nombreseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarNombreProducto/" + nombreseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar el producto existente?")) {
                        eliminarProductoPorNombre(nombreseleccionado);
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