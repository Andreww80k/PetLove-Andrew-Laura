let tablaMascota = document.querySelector('#consultamascota');
tablaMascota.innerHTML = '';
let nombreMascotaBusq = document.querySelector('#nombreMascotaBusq');
nombreMascotaBusq.addEventListener('input', listarMascota);

$(document).ready(function(){

    // METODO LISTAR

    $.ajax({
        url: "http://localhost:8080/ListarMascota",
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            for (let i = 0; i < respuesta.length; i++) {
                tablaMascota.innerHTML += '<tr><td>' + respuesta[i].id_mascota +
                    '</td><td>' + respuesta[i].nombre_mascota +
                    '</td><td>' + respuesta[i].raza_mascota +
                    '</td><td>' + respuesta[i].tipo_mascota +
                    '</td><td>' + respuesta[i].edad_mascota +
                    '</td><td>' + respuesta[i].peso_mascota +
                    '</td></tr>';
            }
        }
    });
})

function listarMascota() {
    let valNombreMascota = nombreMascotaBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaMascota.rows.length; i++) {
        let fila = tablaMascota.rows[i];
        let nombreMas = fila.cells[1].textContent.toLowerCase();

        if (nombreMas.includes(valNombreMascota)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}