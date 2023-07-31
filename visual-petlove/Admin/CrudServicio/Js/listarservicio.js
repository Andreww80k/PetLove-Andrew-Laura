let tablaServicio = document.querySelector('#consultaservicio');
tablaServicio.innerHTML = '';
let tipoServicioBusq = document.querySelector('#tipoServicioBusq');
tipoServicioBusq.addEventListener('input', listarServicio);

$(document).ready(function(){

    // METODO LISTAR  

    $.ajax({
        url : "http://localhost:8080/ListarServicios",
        type : "GET",
        async: false,
        datatype : "JSON",
        success : function (respuesta){
            console.log(respuesta)
            for (let i = 0; i < respuesta.length; i++) {
                tablaServicio.innerHTML += '<tr><td>' + respuesta[i].id_servicio +
                    '</td><td>' + respuesta[i].tipo_servicio +
                    '</td></tr>';
            }
        }
    }); 
})

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