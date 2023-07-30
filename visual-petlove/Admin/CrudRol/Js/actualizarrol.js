let tablaRol = document.querySelector('#consultarol');
tablaRol.innerHTML = '';
let nombreRolBusq = document.querySelector('#nombreRolBusq');
nombreRolBusq.addEventListener('input', listarRol);

let validacionNull = document.querySelector('#valNull');

$(document).ready(function(){
    listarTabla();
    
    $('#actualizarRol').on('click', function(){
        let id_rol_usuario = $('#idRol').val();
        let nombre_rol_usuario = $('#nombre').val();
        
        validarNull();

        if (id_rol_usuario !== '' && nombre_rol_usuario !== '') {
            validacionNull.textContent = '';
            // Aquí puedes agregar más validaciones si es necesario
            // ...

            if (confirm("¿Estás seguro de actualizar este Rol?")) {
                let rol = {
                    id_rol_usuario: id_rol_usuario,
                    nombre_rol_usuario: nombre_rol_usuario,
                };

                let rolActualizado = JSON.stringify(rol);
                console.log(rol)

                $.ajax({
                    url: "http://localhost:8080/actualizarRolUsuario",
                    type: "PUT",
                    data: rolActualizado,
                    contentType: "application/JSON",
                    datatype: "JSON",

                    success: function(response){
                        alert(response);
                        location.reload();
                    }
                });
            } else {
                alert('No se actualizó el rol.');
            }
        } else {
            validacionNull.textContent = "Campos Vacíos. Por favor, llena todos los campos.";
        }
    });
});

function listarTabla() {

    $.ajax({
        url : "http://localhost:8080/ListarRolesUsuarios",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            console.log(respuesta)
            for (let i = 0; i < respuesta.length; i++) {
                console.log("Valor de id_rol_usuario:", respuesta[i].id_rol_usuario); // Agregar esta línea para depurar
                tablaRol.innerHTML += '<tr><td>' + respuesta[i].id_rol_usuario +
                    '</td><td>' + respuesta[i].nombre_rol_usuario +
                    '</td><td> <input type="button" class="btnListar butto" id="' + respuesta[i].id_rol_usuario + '" value="Actualizar">' + 
                    '</td></tr>';
            }
            listarRolForm();
        }
    }); 
}

function listarRol() {
    let valNombreRol = nombreRolBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaRol.rows.length; i++) {
        let fila = tablaRol.rows[i];
        let nombreProd = fila.cells[1].textContent.toLowerCase();

        if (nombreProd.includes(valNombreRol)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}

function listarRolForm() {
    $('.btnListar').on('click', function() {
        let btnId = this.getAttribute('id');

        $.ajax({
            url: "http://localhost:8080/buscarRolUsuario/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function(respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    // Si la respuesta es un array con al menos un elemento, tomamos el primer elemento
                    // ya que asumimos que es el producto buscado.
                    let rol_usuario = respuesta[0];

                    // Asegurarse de que las propiedades existen en el objeto producto antes de asignar los valores.
                    // Asegúrate de que los nombres de las propiedades coinciden con los esperados.
                    // Si los nombres son diferentes, ajusta el código en consecuencia.

                    $('#idRol').val(rol_usuario.id_rol_usuario || '');
                    $('#nombre').val(rol_usuario.nombre_rol_usuario || '');
                } else {
                    // Si la respuesta no es un array o está vacía, se asume que no se encontró el producto.
                    // Aquí puedes manejar el caso en el que el producto no existe o mostrar un mensaje de error.
                    console.error('Rol no encontrado.');
                }
            },
            error: function(xhr, status, error) {
                console.error(error); // Imprimir el error en la consola para depuración.
            }
        });
    });
}


function validarNull(){
    let datos = document.querySelectorAll('.input-box input:required');
    datos.forEach(valor => {
        if(valor.value == ''){
            valor.setAttribute('style', 'border-color: red;');
        } else {
            valor.setAttribute('style', 'border-color: #595b61;');
        }                       
    });
}
