$(document).ready(function() {
    const GuardaProducto = $("#GuardaProducto");

    GuardaProducto.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = $('#nombre').val();
        const descripcionseleccionado = $('#descripcion').val();
        const precioseleccionado = $('#precio').val();
        const stockseleccionado = $('#stock').val();

        const producto = {
            nombre_producto: nombreseleccionado,
            descripcion_producto: descripcionseleccionado,
            precio_producto: precioseleccionado,
            stock_producto: stockseleccionado,
        };

        let envioDatos = JSON.stringify(producto)

        $.ajax({
            url: "http://localhost:8080/AgregarProducto", 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                console.log("Agregada el producto");
                alert("Agregada nuevo producto");
            }
        });
    });
});
