function eliminarServicioPorTipo(tipo) {
    $.ajax({
        url: "http://localhost:8080/eliminarServicioTipo/" + tipo,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Servicio eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar el Servicio");
        }
    });
}

function selectTipo(){
    const tiposelect = document.querySelector("#servicioEliminarTipo");
    tiposelect.innerHTML = "<option value='Seleccione Tipo a Eliminar'>Nombre A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarServicio",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(servicio => {
                tiposelect.innerHTML += '<option value="' + servicio['tipo_servicio'] +'">' + servicio['tipo_servicio'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectTipo();
    const eliminarServicioTipoBtn = $("#eliminarServicioTipoBtn");
    const tiposelect = $("#servicioEliminarTipo");

    eliminarServicioTipoBtn.click(function(event) {
        event.preventDefault();
    
        const tiposeleccionado = tiposelect.val();
        console.log(tiposeleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarTipoServicio/" + tiposeleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar el servicio existente?")) {
                        eliminarServicioPorTipo(tiposeleccionado);
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