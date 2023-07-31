let tablaUsuario = document.querySelector('#consultausuario');
tablaUsuario.innerHTML = '';
let correoUsuarioBusq = document.querySelector('#correoUsuarioBusq');
correoUsuarioBusq.addEventListener('input', listarUsuario);

function selectRol() {
    const rolselect = document.querySelector("#rol");
    rolselect.innerHTML = "<option value='Seleccione Rol'>Rol A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarRolUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            Object.values(respuesta).forEach(rol => {
                rolselect.innerHTML += '<option value="' + rol['id_rol_usuario'] + '">' + rol['nombre_rol_usuario'] + '</option>';
            });
        }
    });
}

function listarTabla() {
    $.ajax({
        url: "http://localhost:8080/ListarUsuario",
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            for (let i = 0; i < respuesta.length; i++) {
                console.log("Valor de id_usuario:", respuesta[i].id_usuario);
                tablaUsuario.innerHTML += '<tr><td>' + respuesta[i].id_usuario +
                    '</td><td>' + respuesta[i].nombre_usuario +
                    '</td><td>' + respuesta[i].apellido_usuario +
                    '</td><td>' + respuesta[i].telefono_usuario +
                    '</td><td>' + respuesta[i].direccion_usuario +
                    '</td><td>' + respuesta[i].correo_usuario +
                    '</td><td>' + respuesta[i].contrasena_usuario +
                    '</td><td> <input type="button" class="btnListar butto" data-idrol="' + respuesta[i].id_rol_usuario + '" id="' + respuesta[i].id_usuario + '" value="Actualizar">' +
                    '</td></tr>';
            }
            listarUsuarioForm();
        }
    });
}

function listarUsuario() {
    let valCorreoUsuario = correoUsuarioBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaUsuario.rows.length; i++) {
        let fila = tablaUsuario.rows[i];
        let correoUsu = fila.cells[5].textContent.toLowerCase();

        if (correoUsu.includes(valCorreoUsuario)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}

function listarUsuarioForm() {
    $('.btnListar').on('click', function () {
        let btnId = this.getAttribute('id');
        let idRolUsuario = this.getAttribute('data-idrol'); // Obtener el id_rol_usuario del botón

        $.ajax({
            url: "http://localhost:8080/BuscarUsuario/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function (respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    let usuario = respuesta[0];
                    $('#idUsuario').val(usuario.id_usuario || '');
                    $('#nombre').val(usuario.nombre_usuario || '');
                    $('#apellido').val(usuario.apellido_usuario || '');
                    $('#direccion').val(usuario.direccion_usuario || '');
                    $('#telefono').val(usuario.telefono_usuario || '');
                    $('#correo').val(usuario.correo_usuario || '');
                    $('#contrasena').val(usuario.contrasena_usuario || '');

                    // Asignar el id_rol_usuario al select en el formulario
                    $('#rol').val(idRolUsuario);
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
    selectRol();
    listarTabla();
    listarUsuarioForm();

    const actualizarUsuario = $("#actualizarUsuario");
    const rolselect = $("#rol");

    actualizarUsuario.click(function (event) {
        event.preventDefault();

        const idUsuarioSeleccionado = $('#idUsuario').val();
        const nombreseleccionado = $('#nombre').val();
        const apellidoseleccionado = $('#apellido').val();
        const direccionseleccionado = $('#direccion').val();
        const telefonoseleccionado = $('#telefono').val();
        const correoseleccionado = $('#correo').val();
        const contrasenaseleccionado = $('#contrasena').val();
        const rolseleccionado = rolselect.val();

        const usuario = {
            id_usuario: idUsuarioSeleccionado,
            nombre_usuario: nombreseleccionado,
            apellido_usuario: apellidoseleccionado,
            direccion_usuario: direccionseleccionado,
            telefono_usuario: telefonoseleccionado,
            correo_usuario: correoseleccionado,
            contrasena_usuario: contrasenaseleccionado,
            id_rol_usuario: rolseleccionado,
        };

        $.ajax({
            url: "http://localhost:8080/actualizarUsuario/" + idUsuarioSeleccionado,
            type: "PUT",
            data: JSON.stringify(usuario),
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
