let tablaServicio = document.querySelector('#consultaservicio');
tablaServicio.innerHTML = '';
let tipoServicioBusq = document.querySelector('#tipoServicioBusq');
tipoServicioBusq.addEventListener('input', listarServicio);

let validacionNull = document.querySelector('#valNull');

$(document).ready(function(){
    listarTabla();
    
    $('#actualizarServicio').on('click', function(){
        let id_servicio = $('#idServicio').val();
        let tipo_servicio = $('#tipo').val();
        
        validarNull();

        if (id_servicio !== '' && tipo_servicio !== '') {
            validacionNull.textContent = '';
            // Aquí puedes agregar más validaciones si es necesario
            // 

            if (confirm("¿Estás seguro de actualizar este Servicio?")) {
                let servicio = {
                    id_servicio: id_servicio,
                    tipo_servicio: tipo_servicio,
                };

                let servicioActualizado = JSON.stringify(servicio);
                console.log(servicio)

                $.ajax({
                    url: "http://localhost:8080/actualizarServicio",
                    type: "PUT",
                    data: servicioActualizado,
                    contentType: "application/JSON",
                    datatype: "JSON",

                    success: function(response){
                        alert(response);
                        location.reload();
                    }
                });
            } else {
                alert('No se actualizó el servicio.');
            }
        } else {
            validacionNull.textContent = "Campos Vacíos. Por favor, llena todos los campos.";
        }
    });
});

function listarTabla() {

    $.ajax({
        url : "http://localhost:8080/ListarServicios",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            console.log(respuesta)
            for (let i = 0; i < respuesta.length; i++) {
                console.log("Valor de id_servicio:", respuesta[i].id_servicio); // Agregar esta línea para depurar
                tablaServicio.innerHTML += '<tr><td>' + respuesta[i].id_servicio +
                    '</td><td>' + respuesta[i].tipo_servicio +
                    '</td><td> <input type="button" class="btnListar butto" id="' + respuesta[i].id_servicio + '" value="Actualizar">' + 
                    '</td></tr>';
            }
            listarServicioForm();
        }
    }); 
}

function listarServicio() {
    let valTipoServicio = tipoServicioBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaServicio.rows.length; i++) {
        let fila = tablaServicio.rows[i];
        let tipoProd = fila.cells[1].textContent.toLowerCase();

        if (tipoProd.includes(valTipoServicio)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}

function listarServicioForm() {
    $('.btnListar').on('click', function() {
        let btnId = this.getAttribute('id');

        $.ajax({
            url: "http://localhost:8080/BuscarServicios/" + btnId,
            type: "GET",
            datatype: "JSON",
            async: false,
            success: function(respuesta) {
                if (Array.isArray(respuesta) && respuesta.length > 0) {
                    // Si la respuesta es un array con al menos un elemento, tomamos el primer elemento
                    // ya que asumimos que es el producto buscado.
                    let servicio = respuesta[0];

                    // Asegurarse de que las propiedades existen en el objeto producto antes de asignar los valores.
                    // Asegúrate de que los nombres de las propiedades coinciden con los esperados.
                    // Si los nombres son diferentes, ajusta el código en consecuencia.

                    $('#idServicio').val(servicio.id_servicio || '');
                    $('#tipo').val(servicio.tipo_servicio || '');
                } else {
                    // Si la respuesta no es un array o está vacía, se asume que no se encontró el producto.
                    // Aquí puedes manejar el caso en el que el producto no existe o mostrar un mensaje de error.
                    console.error('Servicio no encontrado.');
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
