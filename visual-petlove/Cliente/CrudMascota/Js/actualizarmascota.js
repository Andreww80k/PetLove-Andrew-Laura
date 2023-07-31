let tablaMascota = document.querySelector('#consultamascota');
tablaMascota.innerHTML = '';
let nombreMascotaBusq = document.querySelector('#nombreMascotaBusq');
nombreMascotaBusq.addEventListener('input', listarMascota);

function selectUsuario(){
    const usuarioselect = document.querySelector("#usuario");
    usuarioselect.innerHTML = "<option value='Seleccione Usuario'>Usuario A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(usuario => {
                usuarioselect.innerHTML += '<option value="' + usuario['id_usuario'] +'">' + usuario['nombre_usuario'] + ' ' + usuario['apellido_usuario'] + '</option>'
            });
        }
    })
}

function listarTabla() {
    $.ajax({
        url: "http://localhost:8080/ListarMascota",
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            for (let i = 0; i < respuesta.length; i++) {
                console.log("Valor de id_mascota:", respuesta[i].id_mascota);
                tablaMascota.innerHTML += '<tr><td>' + respuesta[i].id_mascota +
                    '</td><td>' + respuesta[i].nombre_mascota +
                    '</td><td>' + respuesta[i].raza_mascota +
                    '</td><td>' + respuesta[i].tipo_mascota +
                    '</td><td>' + respuesta[i].edad_mascota +
                    '</td><td>' + respuesta[i].peso_mascota +
                    '</td><td> <input type="button" class="btnListar butto" data-idusuario="' + respuesta[i].id_usuario + '" id="' + respuesta[i].id_mascota + '" value="Actualizar">' +
                    '</td></tr>';
            }
            listarMascotaForm();
        }
    });
}

function listarMascota() {
    let valNombreMascota = nombreMascotaBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaMascota.rows.length; i++) {
        let fila = tablaMascota.rows[i];
        let nombreMas = fila.cells[1].textContent.toLowerCase();

        if (nombreMas.includes(valNombreMascota)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}

function listarMascotaForm() {
    $('.btnListar').on('click', function () {
        let btnId = this.getAttribute('id');
        let idUsuario = this.getAttribute('data-idusuario'); // Obtener el id_rol_usuario del botón

        $.ajax({
            url: "http://localhost:8080/BuscarMascota/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function (respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    let mascota = respuesta[0];
                    $('#idMascota').val(mascota.id_mascota || '');
                    $('#nombre').val(mascota.nombre_mascota || '');
                    $('#raza').val(mascota.raza_mascota || '');
                    $('#tipo').val(mascota.tipo_mascota || '');
                    $('#edad').val(mascota.edad_mascota || '');
                    $('#peso').val(mascota.peso_mascota || '');

                    // Asignar el id_rol_usuario al select en el formulario
                    $('#usuario').val(idUsuario);
                } else {
                    console.error('Mascota no encontrada.');
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
    selectUsuario();
    listarTabla();
    listarMascotaForm();

    const actualizarMascota = $("#actualizarMascota");
    const usuarioselect = $("#usuario");

    actualizarMascota.click(function (event) {
        event.preventDefault();

        const idMascotaSeleccionado = $('#idMascota').val();
        const nombreseleccionado = $('#nombre').val();
        const razaseleccionado = $('#raza').val();
        const tiposeleccionado = $('#tipo').val();
        const edadseleccionado = $('#edad').val();
        const pesoseleccionado = $('#peso').val();
        const usuarioseleccionado = usuarioselect.val();

        const mascota = {
            id_mascota: idMascotaSeleccionado,
            nombre_mascota: nombreseleccionado,
            raza_mascota: razaseleccionado,
            tipo_mascota: tiposeleccionado,
            edad_mascota: edadseleccionado,
            peso_mascota: pesoseleccionado,
            id_usuario: usuarioseleccionado,
        };

        $.ajax({
            url: "http://localhost:8080/actualizarMascota/" + idMascotaSeleccionado,
            type: "PUT",
            data: JSON.stringify(mascota),
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
