let tablaMascotas = document.querySelector('#consultamascota');
tablaMascotas.innerHTML = '';
let nombreMascotaBusq = document.querySelector('#nombreMascotaBusq');
let razaMascotaBusq = document.querySelector('#razaMascotaBusq');
let tipoMascotaBusq = document.querySelector('#tipoMascotaBusq');
nombreMascotaBusq.addEventListener('input', listarMascotas);
razaMascotaBusq.addEventListener('input', listarMascotas);
tipoMascotaBusq.addEventListener('input', listarMascotas);


$(document).ready(function(){

    // METODO LISTAR    

    $.ajax({
        url: "http://localhost:8080/ListarMascota", // Cambiar la URL por la que corresponda para obtener la lista de mascotas
        type: "GET",
        async: false,
        datatype: "JSON",
        success: function (respuesta) {
            for (let i = 0; i < respuesta.length; i++) {
                tablaMascotas.innerHTML += '<tr><td>' + respuesta[i].id_mascota +
                    '</td><td>' + respuesta[i].id_usuario +
                    '</td><td>' + respuesta[i].nombre_mascota +
                    '</td><td>' + respuesta[i].raza_mascota +
                    '</td><td>' + respuesta[i].tipo_mascota +
                    '</td><td>' + respuesta[i].edad_mascota +
                    '</td><td>' + respuesta[i].peso_mascota +
                    '</td></tr>';
            }
        }
    });  

});

function listarMascotas() {
    let valNombreMascota = nombreMascotaBusq.value.toLowerCase();
    let valRazaMascota = razaMascotaBusq.value.toLowerCase();
    let valTipoMascota = tipoMascotaBusq.value.toLowerCase();
    
    for (let i = 0; i < tablaMascotas.rows.length; i++) {
        let fila = tablaMascotas.rows[i];

        let nombreMascota = fila.cells[2].textContent.toLowerCase();
        let razaMascota = fila.cells[2].textContent.toLowerCase();
        let tipoMascota = fila.cells[2].textContent.toLowerCase();

        if (nombreMascota.includes(valNombreMascota) && razaMascota.includes(valRazaMascota) && tipoMascota.includes(valTipoMascota)) {
            fila.style.display = '';
        } else {
            fila.style.display = 'none';
        }
    }
}
