$(document).ready(function() {
    const GuardaRol = $("#GuardaRol");

    GuardaRol.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = $('#nombre').val();

        const rol = {
            nombre_rol_usuario: nombreseleccionado,
        };

        let envioDatos = JSON.stringify(rol)

        $.ajax({
            url: "http://localhost:8080/agregarRolUsuario", 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                if (response === "El Rol_Usuario se registró satisfactoriamente") {
                    console.log("El Rol_Usuario se registró satisfactoriamente");
                    alert("Agregado nuevo rol");
                } else if (response === "El Rol_Usuario ya esta registrado en nuestra veterinaria, rectifica porfavor") {
                    alert("El Rol_Usuario ya esta registrado en nuestra veterinaria, rectifica porfavor");
                } else {
                    alert("Problemas Técnicos")
                }
            }
        });
    });
});
