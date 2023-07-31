let tablaReserva = document.querySelector('#consultareserva');
tablaReserva.innerHTML = '';
let estadoReservaBusq = document.querySelector('#estadoReservaBusq');
estadoReservaBusq.addEventListener('input', listarReserva);

$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/ListarReservas",
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            for (let i = 0; i < respuesta.length; i++) {
                console.log("Valor de id_usuario:", respuesta[i].id_reserva);
                tablaReserva.innerHTML += '<tr><td>' + respuesta[i].id_reserva +
                    '</td><td>' + respuesta[i].fecha_reserva +
                    '</td><td>' + respuesta[i].hora_desarrollo_reserva +
                    '</td><td>' + respuesta[i].tipo_reserva +
                    '</td><td>' + respuesta[i].estado_reserva +
                    '</td></tr>';
            }
        }
    });
})

function listarReserva() {
    let valEstadoReserva = estadoReservaBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaReserva.rows.length; i++) {
        let fila = tablaReserva.rows[i];
        let estadoRes = fila.cells[4].textContent.toLowerCase();

        if (estadoRes.includes(valEstadoReserva)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}