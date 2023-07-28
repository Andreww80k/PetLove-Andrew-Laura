let tablaProductos = document.querySelector('#consultaproducto');
tablaProductos.innerHTML = '';
let nombreProdBusq = document.querySelector('#nombreProdBusq');
nombreProdBusq.addEventListener('input', listarProductos);

$(document).ready(function(){


    // METODO LISTAR    

    $.ajax({
        url : "http://localhost:8080/ListarProductos",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            for (let i = 0; i < respuesta.length; i++) {
                tablaProductos.innerHTML += '<tr><td>' + respuesta[i].id_producto +
                    '</td><td>' + respuesta[i].nombre_producto +
                    '</td><td>' + respuesta[i].descripcion_producto + 
                    '</td><td>' + respuesta[i].precio_producto + 
                    '</td><td>' + respuesta[i].stock_producto + 
                    '</td></tr>';
            }
        }
    });  

})

function listarProductos() {
    let valNombreProd = nombreProdBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaProductos.rows.length; i++) {
        let fila = tablaProductos.rows[i];
        let nombreProd = fila.cells[1].textContent.toLowerCase();

        if (nombreProd.includes(valNombreProd)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}