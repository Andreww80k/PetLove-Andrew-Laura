function eliminarReservaPorEstado(estado) {
    $.ajax({
        url: "http://localhost:8080/eliminarReservaEstado/" + estado,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Reserva eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar la Reserva");
        }
    });
}

function eliminarReservaPorId(id) {
    $.ajax({
        url: "http://localhost:8080/eliminarReservas/" + id,
        type: "DELETE",
        success: function(response) {
            console.log(response);
            console.log("Eliminado");
            alert("Reserva eliminado");
        },
        error: function(error) {
            console.error(error);
            alert("No se pudo eliminar la Reserva");
        }
    });
}

function selectEstado(){
    const estadoselect = document.querySelector("#estadoEliminar");
    estadoselect.innerHTML = "<option value='Seleccione Estado a Eliminar'>Estado A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarReservas",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(reserva => {
                estadoselect.innerHTML += '<option value="' + reserva['estado_reserva'] +'">' + reserva['estado_reserva'] + '</option>'
            });
        }
    })
}

function selectId(){
    const idselect = document.querySelector("#idEliminar");
    idselect.innerHTML = "<option value='Seleccione ID a Eliminar'>ID A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarReservas",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(reserva => {
                idselect.innerHTML += '<option value="' + reserva['id_reserva'] +'">' + reserva['id_reserva'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectEstado();
    selectId();
    const eliminarReservaBtn = $("#eliminarReservaBtn");
    const eliminarReservaBtn2 = $("#eliminarReservaBtn2");
    const estadoselect = $("#estadoEliminar");
    const idselect = $("#idEliminar");

    eliminarReservaBtn.click(function(event) {
        event.preventDefault();
    
        const estadoseleccionado = estadoselect.val();
        console.log(estadoseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarEstadoReserva/" + estadoseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar la Reserva existente?")) {
                        eliminarReservaPorEstado(estadoseleccionado);
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
    
    eliminarReservaBtn2.click(function(event) {
        event.preventDefault();
    
        const idseleccionado = idselect.val();
        console.log(idseleccionado)
    
        $.ajax({
            url: "http://localhost:8080/BuscarReserva/" + idseleccionado,
            type: "GET",
            datatype: "JSON",
            success: function(response) {
                console.log(response)
                if (response.length != 0) {
                    if (confirm("¿Desea eliminar la Reserva existente?")) {
                        eliminarReservaPorId(idseleccionado);
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
