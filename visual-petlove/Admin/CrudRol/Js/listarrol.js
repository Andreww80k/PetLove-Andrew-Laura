let tablaRol = document.querySelector('#consultarol');
tablaRol.innerHTML = '';
let nombreRolBusq = document.querySelector('#nombreRolBusq');
nombreRolBusq.addEventListener('input', listarRol);

$(document).ready(function(){

    // METODO LISTAR    

    $.ajax({
        url : "http://localhost:8080/ListarRolesUsuarios",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            console.log(respuesta)
            for (let i = 0; i < respuesta.length; i++) {
                tablaRol.innerHTML += '<tr><td>' + respuesta[i].id_rol_usuario +
                    '</td><td>' + respuesta[i].nombre_rol_usuario +
                    '</td></tr>';
            }
        }
    }); 
})

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
