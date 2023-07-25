$(document).ready(function(){

  $('#button').on('click', function(){
    var email = $('#email').val();

    validarEmailDB(email);

  });

})


function sendEmail(datos) {

    var contenido = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><title></title><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta name="viewport" content="width=device-width"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous"><style type="text/css">body, html { margin: 0px; padding: 0px; -webkit-font-smoothing: antialiased; text-size-adjust: none; width: 100% !important; }table td, table { }#outlook a { padding: 0px; }.ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div { line-height: 100%; }.ExternalClass { width: 100%; }@media only screen and (max-width: 480px) {table tr td table.edsocialfollowcontainer {width: auto !important;} table, table tr td, table td { width: 100% !important; }img { width: inherit; }.layer_2 { max-width: 100% !important; }.edsocialfollowcontainer table { max-width: 25% !important; }.edsocialfollowcontainer table td { padding: 10px !important; }.edsocialfollowcontainer table { max-width: 25% !important; }.edsocialfollowcontainer table td { padding: 10px !important; }}</style><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous"><link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i &subset=cyrillic,latin-ext" data-name="open_sans" rel="stylesheet" type="text/css"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.css"><link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous"><link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/spectrum/1.8.0/spectrum.min.css"></head><body style="padding:0; margin: 0;background: #f5f6f8" data-new-gr-c-s-check-loaded="14.1091.0" data-gr-ext-installed="" data-new-gr-c-s-loaded="14.1091.0"><table style="height: 100%; width: 100%; background-color: #f5f6f8;" align="center"><tbody><tr><td valign="top" id="dbody" data-version="2.31" style="width: 100%; height: 100%; padding-top: 50px; padding-bottom: 50px; background-color: #f5f6f8;"><!--[if (gte mso 9)|(IE)]><table align="center" style="max-width:640px" width="640" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><!--[if (gte mso 9)|(IE)]><table align="center" style="max-width:600px" width="600" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><!--[if (gte mso 9)|(IE)]><table align="center" style="max-width:600px" width="600" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><!--[if (gte mso 9)|(IE)]><table align="center" style="max-width:600px" width="600" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><table class="layer_1" align="center" border="0" cellpadding="0" cellspacing="0" style="max-width: 640px; box-sizing: border-box; width: 100%; margin: 0px auto;"><tbody><tr><td class="drow" valign="top" align="center" style="background-color: #ffffff; box-sizing: border-box; font-size: 0px; text-align: center;"><!--[if (gte mso 9)|(IE)]><table width="100%" align="center" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><div class="layer_2" style="display: inline-block; vertical-align: top; width: 100%; max-width: 640px;"><table border="0" cellspacing="0" cellpadding="0" class="edcontent" style="border-collapse: collapse;width:100%"><tbody><tr><td valign="top" class="edimg" style="text-align: center; padding: 0px; box-sizing: border-box;"><img src="https://api.smtprelay.co/userfile/05bb2d6a-19cc-4b59-bde6-a00b4a0a4379/logo-name.png" alt="Image" width="1004" style="border-width: 0px; border-style: none; max-width: 1004px; width: 100%;"></td></tr></tbody></table></div><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr><tr><td class="drow" valign="top" align="center" style="background-color: #ffffff; box-sizing: border-box; font-size: 0px; text-align: center;"><!--[if (gte mso 9)|(IE)]><table width="100%" align="center" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><div class="layer_2" style="max-width: 640px; display: inline-block; vertical-align: top; width: 100%;"><table border="0" cellspacing="0" class="edcontent" style="border-collapse: collapse;width:100%"><tbody><tr><td valign="top" class="edtext" style="padding: 32px; text-align: left; color: #5f5f5f; font-size: 15px; font-family: &quot;Open Sans&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; word-break: break-word; direction: ltr; box-sizing: border-box;"><p class="style1 text-center" style="line-height: 1.75em; text-align: center; margin: 0px; padding: 0px; color: #000000; font-size: 32px; font-family: &quot;Open Sans&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif;">Correo de Recuperación</p><p class="text-center" style="line-height: 1.75em; text-align: center; margin: 0px; padding: 0px;">Tu Código de Verificación es:</p><p class="text-center" style="line-height: 1.75em; text-align: center; margin: 0px; padding: 0px;"><br></p><p class="text-center" style="line-height: 1.75em; text-align: center; margin: 0px; padding: 0px;"><span id="code"style="color: #ff8000; font-size: 28px;">' + datos.codigo + '</span></p></td></tr></tbody></table></div><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr><tr><td class="drow" valign="top" align="center" style="background-color: #ffffff; box-sizing: border-box; font-size: 0px; text-align: center;"><!--[if (gte mso 9)|(IE)]><table width="100%" align="center" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><div class="layer_2" style="display: inline-block; vertical-align: top; width: 100%; max-width: 640px;"><table border="0" cellspacing="0" cellpadding="0" class="edcontent" style="border-collapse: collapse;width:100%"><tbody><tr><td valign="top" class="edimg" style="text-align: center; padding: 0px; box-sizing: border-box;"><img src="https://api.smtprelay.co/userfile/05bb2d6a-19cc-4b59-bde6-a00b4a0a4379/mascotas-removebg-preview.png" alt="Image" style="border-width: 0px; border-style: none; max-width: 377px; width: 100%;" width="377"></td></tr></tbody></table></div><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr><tr><td class="drow" valign="top" align="center" style="background-color: #ffffff; box-sizing: border-box; font-size: 0px; text-align: center;"><!--[if (gte mso 9)|(IE)]><table width="100%" align="center" cellpadding="0" cellspacing="0" border="0"><tr><td valign="top"><![endif]--><div class="layer_2" style="max-width: 640px; display: inline-block; vertical-align: top; width: 100%;"><table border="0" cellspacing="0" class="edcontent" style="border-collapse: collapse;width:100%"><tbody><tr><td valign="top" class="edtext" style="padding: 32px; text-align: left; color: #5f5f5f; font-size: 15px; font-family: &quot;Open Sans&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; word-break: break-word; direction: ltr; box-sizing: border-box;"><p style="margin: 0px; padding: 0px;">*Este es un correo automático, por favor no responder al mismo.</p></td></tr></tbody></table></div><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr></tbody></table><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr></tbody></table></body></html>';

    Email.send({
      SecureToken : "7dbe89dc-7a24-4888-8e99-1b79eb23f745",
      To : datos.email,
      From : "petlove.professional.grooming@gmail.com",
      Subject : "Recuperar Contraseña - Cuenta PetLove Web",
      Body : contenido
    }).then(
      message => {
        if (message == 'OK'){
            alert('Correo enviado con éxito.')
            redirigir(datos);
        }else {
            alert(message);
            alert('No se pudo enviar el Correo, por favor, intentalo de nuevo.');
        }
      }
    );
}


function validarEmailDB(email){


  if (email != ''){

      if (validarEmail(email)){

          buscarEmail(email);

      } else {
          alert("Correo no Valido.");
  
      }

  } else {
      alert("Campo Vacio. Por favor, escribe tu correo.");
  }

}


function validarEmail(email){

  var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

  return emailRegex.test(email);

}


function buscarEmail(email){

  $.ajax({
      url: "http://localhost:8080/BuscarUsuarioEmail/" + email,
      type: "GET",
      datatype: "JSON",
      async: false,
      success: function(respuesta){

          if(respuesta.length != 0){

              actualizarCodigo(respuesta[0]);

          } else {
              alert("Usuario no existente.");
          }

      }

  })
  
}


function generarCodigo(){
  var codigo = Math.floor(Math.random() * (9999 - 1000 + 1)) + 1000;
  return codigo;

}


function actualizarCodigo(usuario){

  var code = generarCodigo().toString();
  
  let datos = {
    email: usuario.correo_usuario,
    codigo: code
  }

  sendEmail(datos);

}

function redirigir(datos){

  localStorage.setItem('datos', JSON.stringify(datos));
  window.location.href = 'olvidoCodigo.html';
  
}