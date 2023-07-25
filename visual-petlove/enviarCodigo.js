$('.codigoEnvio').on('click', function(){

    const datosRecibidos = JSON.parse(window.localStorage.getItem('datos'));
    let codigo = $('#codigo').val();

    if (codigo != ''){
        verificarCodigo(datosRecibidos, codigo);
        
    } else {
        alert('Campo Vacio. Por favor, escribe el Código enviado a tu correo.');

    }

})

function verificarCodigo(datos, codigo){

    if (datos.codigo == codigo){

        let dato = {
            email: datos.email
        };
    
        localStorage.setItem('dato', JSON.stringify(dato));
        window.location.replace('cambiaContrasena.html');

    } else {
        alert('Código Incorrecto.');
        
    }
    
}