$('.cambiarPass').on('click', function(){

    const datosRecibidos = JSON.parse(window.localStorage.getItem('dato'));
    let contraseña = $('#password').val();
    let confirmacion = $('#confir').val();

    if (contraseña != '' && confirmacion != ''){
        verificarContraseñas(datosRecibidos.email, contraseña, confirmacion);
        
    } else {
       alert('Campo Vacios. Por favor, llena todos los campos.');

    }

})

function verificarContraseñas(email, contraseña, confirmacion){

    if (contraseña.length >= 8){

        if(confirmacion == contraseña){
            buscarEmail(email, confirmacion);

        } else {
            alert('Las Contraseñas no coinciden.');
        }

    } else {
        alert('Contraseña Invalida. Min. 8 Caracteres.');
    }

}

function buscarEmail(email, contraseña){

    $.ajax({
        url: "http://localhost:8080/BuscarUsuarioEmail/" + email,
        type: "GET",
        datatype: "JSON",
        async: false,
        success: function(respuesta){

            if(respuesta != ''){
                actualizarContraseña(respuesta[0], contraseña);

            }

        }

    })
    
}


function actualizarContraseña(usuario, contraseña){
    usuario.contrasena_usuario = contraseña;
    let actuUsuario = JSON.stringify(usuario);
        
    $.ajax({
        url: "http://localhost:8080/actualizarUsuario/" + usuario.id_usuario,
        type: "PUT",
        data: actuUsuario,
        contentType: "application/JSON",
        datatype: "JSON",

        success: function(response){
            if (response == 'Usuario actualizado exitosamente.'){
                alert('Contraseña Recuperada con éxito.');
                localStorage.setItem('dato', '');
                window.location.href = 'IniciodeSesion.html';

            } else {
                alert(response);
            }
        }
    })

}