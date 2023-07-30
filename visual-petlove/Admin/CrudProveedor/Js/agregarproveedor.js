$(document).ready(function() {
    const GuardaProveedor = $("#GuardaProveedor");

    GuardaProveedor.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = $('#nombre').val();
        const apellidoseleccionado = $('#apellido').val();
        const telefonoseleccionado = $('#telefono').val();
        const direccionseleccionado = $('#direccion').val();
        const correoseleccionado = $('#correo').val();
        const contrasenaseleccionado = $('#contrasena').val();

        const proveedor = {
            nombre_proveedor: nombreseleccionado,
            apellido_proveedor: apellidoseleccionado,
            telefono_proveedor: telefonoseleccionado,
            direccion_proveedor: direccionseleccionado,
            correo_proveedor: correoseleccionado,
            contrasena_proveedor: contrasenaseleccionado,
        };

        let envioDatos = JSON.stringify(proveedor)

        $.ajax({
            url: "http://localhost:8080/agregarProveedor", 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                console.log("Agregado");
                alert("Agregado");
            }
        });
    });
});
