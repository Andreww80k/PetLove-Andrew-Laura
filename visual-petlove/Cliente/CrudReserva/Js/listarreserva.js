// Función para llenar el select de mascotas
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

// Función para generar los intervalos de horas
function generarHoras() {
    const horas = [];
    for (let h = 8; h <= 12; h++) {
        for (let m = 0; m < 60; m += 30) {
            const hora = `${h.toString().padStart(2, '0')}:${m.toString().padStart(2, '0')}`;
            horas.push(hora);
        }
    }
    for (let h = 14; h <= 16; h++) {
        for (let m = 0; m < 60; m += 30) {
            const hora = `${h.toString().padStart(2, '0')}:${m.toString().padStart(2, '0')}`;
            horas.push(hora);
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

    // Código para manejar el formulario y la lógica de agregar reserva
    const GuardaReserva = $("#GuardaReserva");
    const mascotaselect = $("#mascota");

    GuardaReserva.click(function (event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const fechaseleccionada = $('#fecha').val();
        const horaseleccionada = $('#hora').val();
        const tiposeleccionado = $('#tipo').val();
        const estadoseleccionado = $('#estado').val();
        const mascotaseleccionada = mascotaselect.val();

        const reserva = {
            fecha_reserva: fechaseleccionada,
            hora_desarrollo_reserva: horaseleccionada,
            tipo_reserva: tiposeleccionado,
            estado_reserva: estadoseleccionado,
        };

        let envioDatos = JSON.stringify(reserva);

        $.ajax({
            url: "http://localhost:8080/AgregarReservas/" + mascotaseleccionada,
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: "JSON",
            success: function (response) {
                console.log(response);
                if (response === "Reserva agregada correctamente") {
                    alert("Reserva agregada correctamente");
                } else if (response === "Ya existe una reserva con la misma fecha y hora") {
                    alert("Ya existe una reserva con esta misma hora o día por favor escoje otra hora o cambia el día de tu cita");
                } else {
                    alert("Problemas Técnicos")
                }
            }
        });
    });
});
