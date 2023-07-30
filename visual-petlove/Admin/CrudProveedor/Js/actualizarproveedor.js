let tablaProveedor = document.querySelector('#consultaproveedor');
tablaProveedor.innerHTML = '';
let correoProveeBusq = document.querySelector('#correoProveeBusq');
correoProveeBusq.addEventListener('input', listarProveedores);

let validacionNull = document.querySelector('#valNull');

$(document).ready(function(){
    listarTabla();
    
    $('#actualizarProvee').on('click', function(){
        let id_proveedor = $('#idProveedor').val();
        let nombre_proveedor = $('#nombre').val();
        let apellido_proveedor = $('#apellido').val();
        let telefono_proveedor = $('#telefono').val();
        let direccion_proveedor = $('#direccion').val();
        let correo_proveedor = $('#correo').val();
        let contrasena_proveedor = $('#contrasena').val();
        
        validarNull();

        if (id_proveedor !== '' && nombre_proveedor !== '' && apellido_proveedor !== '' && telefono_proveedor !== '' && direccion_proveedor !== '' && correo_proveedor !== '' && contrasena_proveedor !== '') {
            validacionNull.textContent = '';
            // Aquí puedes agregar más validaciones si es necesario
            // ...

            if (confirm("¿Estás seguro de actualizar este proveedor?")) {
                let proveedor = {
                    id_proveedor: id_proveedor,
                    nombre_proveedor: nombre_proveedor,
                    apellido_proveedor: apellido_proveedor,
                    telefono_proveedor: telefono_proveedor,
                    direccion_proveedor: direccion_proveedor,
                    correo_proveedor: correo_proveedor,
                    contrasena_proveedor: contrasena_proveedor,
                };

                let proveedorActualizado = JSON.stringify(proveedor);
                console.log(proveedor)

                $.ajax({
                    url: "http://localhost:8080/actualizarProveedor",
                    type: "PUT",
                    data: proveedorActualizado,
                    contentType: "application/JSON",
                    datatype: "JSON",

                    success: function(response){
                        alert(response);
                        location.reload();
                    }
                });
            } else {
                alert('No se actualizó el proveedor.');
            }
        } else {
            validacionNull.textContent = "Campos Vacíos. Por favor, llena todos los campos.";
        }
    });
});

function listarTabla() {
    $.ajax({
        url : "http://localhost:8080/ListarProveedores",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            for (let i = 0; i < respuesta.length; i++) {
                tablaProveedor.innerHTML += '<tr><td>' + respuesta[i].id_proveedor +
                    '</td><td>' + respuesta[i].nombre_proveedor +
                    '</td><td>' + respuesta[i].apellido_proveedor + 
                    '</td><td>' + respuesta[i].telefono_proveedor + 
                    '</td><td>' + respuesta[i].direccion_proveedor + 
                    '</td><td>' + respuesta[i].correo_proveedor + 
                    '</td><td>' + respuesta[i].contrasena_proveedor + 
                    '</td><td> <input type="button" class="btnListar butto" id="' + respuesta[i].id_proveedor + '" value="Actualizar">' + 
                    '</td></tr>';
            }
            listarProveedorForm();
        }
    }); 
}

function listarProveedores() {
    let valCorreoProvee = correoProveeBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaProveedor.rows.length; i++) {
        let fila = tablaProveedor.rows[i];
        let correoProvee = fila.cells[5].textContent.toLowerCase();

        if (correoProvee.includes(valCorreoProvee)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}

function listarProveedorForm() {
    $('.btnListar').on('click', function() {
        let btnId = this.getAttribute('id');

        $.ajax({
            url: "http://localhost:8080/BuscarProveedor/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function(respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    // Si la respuesta es un array con al menos un elemento, tomamos el primer elemento
                    // ya que asumimos que es el proveedor buscado.
                    let proveedor = respuesta[0];

                    // Asegurarse de que las propiedades existen en el objeto proveedor antes de asignar los valores.
                    // Asegúrate de que los nombres de las propiedades coinciden con los esperados.
                    // Si los nombres son diferentes, ajusta el código en consecuencia.

                    $('#idProveedor').val(proveedor.id_proveedor || '');
                    $('#nombre').val(proveedor.nombre_proveedor || '');
                    $('#apellido').val(proveedor.apellido_proveedor || '');
                    $('#telefono').val(proveedor.telefono_proveedor || '');
                    $('#direccion').val(proveedor.direccion_proveedor || '');
                    $('#correo').val(proveedor.correo_proveedor || '');
                    $('#contrasena').val(proveedor.contrasena_proveedor || '');
                } else {
                    // Si la respuesta no es un array o está vacía, se asume que no se encontró el proveedor.
                    // Aquí puedes manejar el caso en el que el proveedor no existe o mostrar un mensaje de error.
                    console.error('Proveedor no encontrado.');
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
