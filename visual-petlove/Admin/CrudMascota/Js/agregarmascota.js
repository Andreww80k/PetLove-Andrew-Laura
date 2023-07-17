function selectUsuario(){
    const usuarioselect = document.querySelector("#usuario");
    usuarioselect.innerHTML = "<option value='Seleccione Usuario'>Usuario A elegir</option>";

    $.ajax({
        url: "http://localhost:8080/ListarUsuario",
        type: "GET",
        datatype: "JSON",
        success: function (respuesta){
            console.log(respuesta)
            Object.values(respuesta).forEach(usuario => {
                usuarioselect.innerHTML += '<option value="' + usuario['id_usuario'] +'">' + usuario['nombre_usuario'] + ' ' + usuario['apellido_usuario'] + '</option>'
            });
        }
    })
}

$(document).ready(function() {
    selectUsuario();
    const GuardaMascota = $("#GuardaMascota");
    const usuarioselect = $("#usuario");

    GuardaMascota.click(function(event) {
        event.preventDefault(); // Evita el comportamiento predeterminado del enlace

        const nombreseleccionado = $('#nombre').val();
        const razaseleccionado = $('#raza').val();
        const tiposeleccionado = $('#tipo').val();
        const edadseleccionado = $('#edad').val();
        const pesoseleccionado = $('#peso').val();
        const usuarioseleccionado = usuarioselect.val();

        const mascota = {
            nombre_mascota: nombreseleccionado,
            raza_mascota: razaseleccionado,
            tipo_mascota: tiposeleccionado,
            edad_mascota: edadseleccionado,
            peso_mascota: pesoseleccionado,
        };

        let envioDatos = JSON.stringify(mascota)

        $.ajax({
            url: "http://localhost:8080/AgregarMascota/" + usuarioseleccionado, 
            type: "POST",
            data: envioDatos,
            contentType: "application/JSON",
            async: false,
            datatype: JSON,
            success: function(response) {
                console.log(response);
                console.log("Agregada la mascota");
                alert("Agregada nueva mascota");
            }
        });
    });
});
