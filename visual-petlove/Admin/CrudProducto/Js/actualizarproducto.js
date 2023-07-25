let tablaProductos = document.querySelector('#consultaproducto');
tablaProductos.innerHTML = '';
let nombreProdBusq = document.querySelector('#nombreProdBusq');
nombreProdBusq.addEventListener('input', listarProductos);

let validacionNull = document.querySelector('#valNull');

$(document).ready(function(){
    listarTabla();
    
    $('#actualizarProd').on('click', function(){
        let idproducto = $('#idProducto').val();
        let nombre_producto = $('#nombre').val();
        let descripcion_producto = $('#descripcion').val();
        let precio_producto = $('#precio').val();
        let stock_producto = $('#stock').val();
        
        validarNull();

        if (idproducto !== '' && nombre_producto !== '' && descripcion_producto !== '' && precio_producto !== '' && stock_producto !== '') {
            validacionNull.textContent = '';
            // Aquí puedes agregar más validaciones si es necesario
            // ...

            if (confirm("¿Estás seguro de actualizar este producto?")) {
                let producto = {
                    idproducto: idproducto,
                    nombre_producto: nombre_producto,
                    descripcion_producto: descripcion_producto,
                    precio_producto: precio_producto,
                    stock_producto: stock_producto,
                };

                let productoActualizado = JSON.stringify(producto);
                console.log(producto)

                $.ajax({
                    url: "http://localhost:8080/actualizarProducto",
                    type: "PUT",
                    data: productoActualizado,
                    contentType: "application/JSON",
                    datatype: "JSON",

                    success: function(response){
                        alert(response);
                        location.reload();
                    }
                });
            } else {
                alert('No se actualizó el producto.');
            }
        } else {
            validacionNull.textContent = "Campos Vacíos. Por favor, llena todos los campos.";
        }
    });
});

function listarTabla() {
    // Lógica para obtener la lista de productos desde la API
    // Reemplaza "https://tu-api-para-listar-productos" con la URL correcta de tu API
    $.ajax({
        url : "http://localhost:8080/ListarProductos",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            for (let i = 0; i < respuesta.length; i++) {
                tablaProductos.innerHTML += '<tr><td>' + respuesta[i].idproducto +
                    '</td><td>' + respuesta[i].nombre_producto +
                    '</td><td>' + respuesta[i].descripcion_producto + 
                    '</td><td>' + respuesta[i].precio_producto + 
                    '</td><td>' + respuesta[i].stock_producto + 
                    '</td><td> <input type="button" class="btnListar butto" id="' + respuesta[i].idproducto + '" value="Actualizar">' + 
                    '</td></tr>';
            }
            listarProductoForm();
        }
    }); 
}

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

function listarProductoForm() {
    $('.btnListar').on('click', function() {
        let btnId = this.getAttribute('id');

        $.ajax({
            url: "http://localhost:8080/BuscarProducto/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function(respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    // Si la respuesta es un array con al menos un elemento, tomamos el primer elemento
                    // ya que asumimos que es el producto buscado.
                    let producto = respuesta[0];

                    // Asegurarse de que las propiedades existen en el objeto producto antes de asignar los valores.
                    // Asegúrate de que los nombres de las propiedades coinciden con los esperados.
                    // Si los nombres son diferentes, ajusta el código en consecuencia.

                    $('#idProducto').val(producto.idproducto || '');
                    $('#nombre').val(producto.nombre_producto || '');
                    $('#descripcion').val(producto.descripcion_producto || '');
                    $('#precio').val(producto.precio_producto || '');
                    $('#stock').val(producto.stock_producto || '');
                } else {
                    // Si la respuesta no es un array o está vacía, se asume que no se encontró el producto.
                    // Aquí puedes manejar el caso en el que el producto no existe o mostrar un mensaje de error.
                    console.error('Producto no encontrado.');
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
