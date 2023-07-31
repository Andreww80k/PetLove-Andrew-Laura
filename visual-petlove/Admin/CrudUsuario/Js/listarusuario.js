let tablaUsuario = document.querySelector('#consultausuario');
tablaUsuario.innerHTML = '';
let correoUsuarioBusq = document.querySelector('#correoUsuarioBusq');
correoUsuarioBusq.addEventListener('input', listarUsuario);

$(document).ready(function(){

    // METODO LISTAR

    $.ajax({
        url: "http://localhost:8080/ListarUsuario",
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            for (let i = 0; i < respuesta.length; i++) {
                tablaUsuario.innerHTML += '<tr><td>' + respuesta[i].id_usuario +
                    '</td><td>' + respuesta[i].nombre_usuario +
                    '</td><td>' + respuesta[i].apellido_usuario +
                    '</td><td>' + respuesta[i].telefono_usuario +
                    '</td><td>' + respuesta[i].direccion_usuario +
                    '</td><td>' + respuesta[i].correo_usuario +
                    '</td><td>' + respuesta[i].contrasena_usuario +
                    '</td></tr>';
            }
        }
    });
})

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