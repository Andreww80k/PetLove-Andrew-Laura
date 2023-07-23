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
            url: "http://localhost:8080/agregarProducto",
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: "json",
            success: function(response) {
                console.log(response);
                if (response === "El Producto se registró exitosamente") {
                    console.log("Agregado el producto");
                    alert("Agregado nuevo producto");
                } else if (response === "El Producto ya existe en la base de datos y no se ha registrado") {
                    alert("El producto ya existe en la base de datos");
                } else {
                    // Manejar otros posibles casos aquí
                }
            }
        });
        
    });
});
