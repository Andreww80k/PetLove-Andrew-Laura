$(document).ready(function() {
    const GuardaServicio = $("#GuardaServicio");

    GuardaServicio.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const tiposeleccionado = $('#tipo').val();

        const servicio = {
            tipo_servicio: tiposeleccionado,
        };

        let envioDatos = JSON.stringify(servicio)

        $.ajax({
            url: "http://localhost:8080/agregarServicio", 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                if (response === "El Servicio se registro satisfactoriamente") {
                    console.log("El Servicio se registro satisfactoriamente");
                    alert("Agregado nuevo rol");
                } else if (response === "El Servicio ya esta registrado en nuestra veterinaria, rectifica porfavor") {
                    alert("El Servicio ya esta registrado en nuestra veterinaria, rectifica porfavor");
                } else {
                    alert("Problemas Técnicos")
                }
            }
        });
    });
});
