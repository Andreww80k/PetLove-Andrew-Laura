function eliminarMascotaPorNombre(nombre) {
    $.ajax({
        url: "http://localhost:8080/eliminarMascotaNombre/" + nombre,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Mascota eliminada");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar la mascota");
        }
    });
}

function eliminarMascotaPorTipo(tipo) {
    $.ajax({
        url: "http://localhost:8080/eliminarMascotaTipo/" + tipo,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Mascota eliminada");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar la mascota");
        }
    });
}

function selectNombre(){
    const nombreselect = document.querySelector("#mascotaEliminarNombre");
    nombreselect.innerHTML = "<option value='Seleccione Nombre a Eliminar'>Nombre A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarMascota",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(mascota => {
                nombreselect.innerHTML += '<option value="' + mascota['nombre_mascota'] +'">' + mascota['nombre_mascota'] + '</option>'
            });
        }
    })
}

function selectTipo(){
    const tiposelect = document.querySelector("#mascotaEliminarTipo");
    tiposelect.innerHTML = "<option value='Seleccione Tipo a Eliminar'>Tipo A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarMascota",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(mascota => {
                tiposelect.innerHTML += '<option value="' + mascota['tipo_mascota'] +'">' + mascota['tipo_mascota'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectNombre();
    const eliminarMascotaNombreBtn = $("#eliminarMascotaNombreBtn");
    const nombreselect = $("#mascotaEliminarNombre");

    eliminarMascotaNombreBtn.click(function(event) {
        event.preventDefault();
    
        const nombreseleccionado = nombreselect.val();
        console.log(nombreseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarNombreMascota/" + nombreseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar la mascota existente?")) {
                        eliminarMascotaPorNombre(nombreseleccionado);
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
    
    selectTipo();
    const eliminarMascotaTipoBtn = $("#eliminarMascotaTipoBtn");
    const tiposelect = $("#mascotaEliminarTipo");

    eliminarMascotaTipoBtn.click(function(event) {
        event.preventDefault();
    
        const tiposeleccionado = tiposelect.val();
        console.log(tiposeleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarTipoMascota/" + tiposeleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar la mascota existente?")) {
                        eliminarMascotaPorTipo(tiposeleccionado);
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
