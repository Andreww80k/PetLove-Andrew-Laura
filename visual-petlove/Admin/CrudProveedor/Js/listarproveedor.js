let tablaProveedor = document.querySelector('#consultaproveedor');
tablaProveedor.innerHTML = '';
let correoProveeBusq = document.querySelector('#correoProveeBusq');
correoProveeBusq.addEventListener('input', listarProveedores);
let nombreProveeBusq = document.querySelector('#nombreProveeBusq');
nombreProveeBusq.addEventListener('input', listarProveedores);

$(document).ready(function(){

    // METODO LISTAR    

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
                    '</td></tr>';
            }
        }
    }); 
})

function listarProveedores() {
    let valCorreoProvee = correoProveeBusq.value.toLowerCase();
    let valNombreProvee = nombreProveeBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaProveedor.rows.length; i++) {
        let fila = tablaProveedor.rows[i];
        let correoProvee = fila.cells[5].textContent.toLowerCase();
        let nombreProvee = fila.cells[1].textContent.toLowerCase();

        if (correoProvee.includes(valCorreoProvee) && nombreProvee.includes(valNombreProvee)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}