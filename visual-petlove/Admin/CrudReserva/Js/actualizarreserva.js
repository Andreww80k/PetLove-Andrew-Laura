let tablaReserva = document.querySelector('#consultareserva');
tablaReserva.innerHTML = '';
let estadoReservaBusq = document.querySelector('#estadoReservaBusq');
estadoReservaBusq.addEventListener('input', listarReserva);

// Función para generar los intervalos de horas
function generarHoras() {
    const horas = [];
    for (let h = 8; h <= 12; h++) {
        for (let m = 0; m < 60; m += 30) {
            const hora = new Date();
            hora.setHours(h);
            hora.setMinutes(m);
            horas.push(hora.toISOString().substr(11, 5));
        }
    }
    for (let h = 14; h <= 16; h++) {
        for (let m = 0; m < 60; m += 30) {
            const hora = new Date();
            hora.setHours(h);
            hora.setMinutes(m);
            horas.push(hora.toISOString().substr(11, 5));
        }
    }
    return horas;
}
// Función para llenar el select de horas
function llenarHoras() {
    const horasDisponibles = generarHoras();
    const horaSelect = $("#hora");

    horaSelect.empty();
    horasDisponibles.forEach((hora) => {
        horaSelect.append(`<option value="${hora}">${hora}</option>`);
    });
}

function selectMascota() {
    const mascotaselect = document.querySelector("#mascota");
    mascotaselect.innerHTML = "<option value='Seleccione Mascota'>Mascota A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarMascota",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            Object.values(respuesta).forEach(mascota => {
                mascotaselect.innerHTML += '<option value="' + mascota['id_mascota'] + '">' + mascota['nombre_mascota'] + '</option>';
            });
        }
    });
}
function listarTabla() {
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
                    '</td><td> <input type="button" class="btnListar butto" data-idmascota="' + respuesta[i].id_mascota + '" id="' + respuesta[i].id_reserva + '" value="Actualizar">' +
                    '</td></tr>';
            }
            listarReservaForm();
        }
    });
}

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

function listarReservaForm() {
    $('.btnListar').on('click', function () {
        let btnId = this.getAttribute('id');
        let idMascota = this.getAttribute('data-idmascota'); // Obtener el id_rol_usuario del botón

        $.ajax({
            url: "http://localhost:8080/BuscarReserva/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function (respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    let reserva = respuesta[0];
                    $('#idReserva').val(reserva.id_reserva || '');
                    $('#fecha').val(reserva.fecha_reserva || '');
                    $('#hora').val(reserva.hora_desarrollo_reserva || '');
                    $('#tipo').val(reserva.tipo_reserva || '');
                    $('#estado').val(reserva.estado_reserva || '');

                    // Asignar el id_rol_usuario al select en el formulario
                    $('#mascota').val(idMascota);
                } else {
                    console.error('Usuario no encontrado.');
                }
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    });
}

function validarNull() {
    let datos = document.querySelectorAll('.input-box input:required');
    datos.forEach(valor => {
        if (valor.value == '') {
            valor.setAttribute('style', 'border-color: red;');
        } else {
            valor.setAttribute('style', 'border-color: #595b61;');
        }
    });
}

$(document).ready(function () {

    // Llenar el select de mascotas al cargar la página
    selectMascota();

    // Llenar el select de horas al cargar la página
    llenarHoras();

    // Establecer la fecha actual en el campo de fecha y habilitar solo fechas futuras
    const fechaInput = document.getElementById("fecha");
    fechaInput.valueAsDate = new Date();
    fechaInput.min = new Date().toISOString().split("T")[0];

    // Cuando se cambie la fecha, volver a llenar el select de horas
    $("#fecha").change(function () {
        llenarHoras();
    });

    // Restricción de horas para la selección
    $("#hora").change(function () {
        const horaSeleccionada = $(this).val();
        const horaLimiteInicio = "08:00";
        const horaLimiteFinManana = "13:00";
        const horaLimiteInicioTarde = "14:00";
        const horaLimiteFin = "17:00";

        if (
            (horaSeleccionada >= horaLimiteInicio && horaSeleccionada < horaLimiteFinManana) ||
            (horaSeleccionada >= horaLimiteInicioTarde && horaSeleccionada <= horaLimiteFin)
        ) {
            // La hora seleccionada está dentro del rango permitido
            // Puedes realizar las acciones adicionales que necesites aquí
        } else {
            // La hora seleccionada está fuera del rango permitido
            alert("La hora seleccionada no está permitida.");
            $("#hora").val(""); // Vaciar la selección para que el usuario elija una válida
        }
    });

    selectMascota();
    listarTabla();
    listarReservaForm();

    const actualizarReserva = $("#actualizarReserva");
    const mascotaselect = $("#mascota");

    actualizarReserva.click(function (event) {
        event.preventDefault();

        const idReservaSeleccionado = $('#idReserva').val();
        const fechaseleccionado = $('#fecha').val();
        const horaseleccionado = $('#hora').val();
        const tiposeleccionado = $('#tipo').val();
        const estadoseleccionado = $('#estado').val();

        const mascotaseleccionado = mascotaselect.val();

        const reserva = {
            id_reserva: idReservaSeleccionado,
            fecha_reserva: fechaseleccionado,
            hora_desarrollo_reserva: horaseleccionado,
            tipo_reserva: tiposeleccionado,
            estado_reserva: estadoseleccionado,

            id_mascota: mascotaseleccionado,
        };

        $.ajax({
            url: "http://localhost:8080/actualizarReserva/" + idReservaSeleccionado,
            type: "PUT",
            data: JSON.stringify(reserva),
            contentType: "application/JSON",
            datatype: "JSON",
            success: function (response) {
                console.log(response);
                console.log("Actualizado");
                alert("Actualizado");
                location.reload();
            }
        });
    });
});
