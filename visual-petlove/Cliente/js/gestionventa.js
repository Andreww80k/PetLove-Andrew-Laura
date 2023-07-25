let datosRecibidos = null;
$(document).ready(function(){

    const tabla = document.querySelector('#cuerpo');

    datosRecibidos = JSON.parse(window.localStorage.getItem('dato'));

    buscarUsuario(tabla, datosRecibidos);

})


function buscarUsuario(tabla, dato){

    $.ajax({
        url: "http://localhost:8080/BuscarUsuarioEmail/" + dato.email,
        type: "GET",
        datatype: "JSON",
        success: function(respuesta){
            listarOrdenes(tabla, respuesta[0]);

        }

    })

}

function sumarTotal(respuesta){

    var suma = 0;

    respuesta.forEach(compra => {
        suma += compra.precio_producto;
        
    });

    return suma;

}


function listarOrdenes(tabla, usuario){
    
        // METODO LISTAR    
    
        $.ajax({
            url : "http://localhost:8080/ListarOrdenesCompra/" + usuario.id_usuario,
            type : "GET",
            async: false,
            datatype : "JSON",
            success : function (respuesta){
    
                tabla.innerHTML += '<tr><td>' + respuesta[0].id_venta +
                    '</td><td>' + respuesta[0].id_usuario +
                    '</td><td>' + respuesta[0].nombre_usuario + ' ' + respuesta[0].apellido_usuario +
                    '</td><td>' + respuesta[0].estado_venta + 
                    '</td><td>' + respuesta[0].fecha_venta + 
                    '</td><td>' + respuesta[0].impuesto +
                    '</td><td>' + sumarTotal(respuesta) +
                    '</td><td>' + '<input type="button" class="btn" value="Factura" id="facturar"></input>' +
                    '</td></tr>';

                    $('#facturar').on('click', function(event){
                        event.preventDefault();
                
                        localStorage.setItem('info', JSON.stringify(datosRecibidos));
                        window.location.href = "gestiondetallesventa.html";
                    })
    
            }
        }); 


}