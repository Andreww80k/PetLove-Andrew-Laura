package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Reserva;
import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Repositorio.RepositorioMascota;
import com.terminal.petlove.Repositorio.RepositorioReserva;
import com.terminal.petlove.Servicio.ServicioReserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ControladorReserva {

    //Llamos a los repositorios:


    private ServicioReserva servicio;

    private RepositorioMascota RepoMas;

    private RepositorioReserva RepoRes;

    public ControladorReserva(ServicioReserva servicio, RepositorioMascota repoMas, RepositorioReserva repoRes) {
        this.servicio = servicio;
        RepoMas = repoMas;
        RepoRes = repoRes;
    }


    //Crera la ruta que retorna un Arraylist

    @GetMapping("/ListarReservas")
    public List<Map<String, Object>> datosReserva() {
        List<Object[]> lista = servicio.DatosReserva();
        List<Map<String, Object>> json = new ArrayList<>();


        //For para recorrer todos los datos traidos del inner join

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_mascota", objects[0]);
            datos.put("id_reserva", objects[1]);
            datos.put("estado_reserva", objects[2]);
            datos.put("fecha_entrega", objects[3]);
            datos.put("fecha_reserva", objects[4]);
            datos.put("tipo_reserva", objects[5]);

            json.add(datos);
        }
            for (Map<String, Object> Res : json) {
                System.out.println(Res);
            }

            return json;
        }


    //Buscar

    @GetMapping("/BuscarReserva/{dato}")
    public List<Map<String, Object>> datosReservaInner(@PathVariable("dato") Integer dato) {
        List<Object[]> lista = servicio.BuscarReservaInner(dato);
        List<Map<String, Object>> json = new ArrayList<>();

        //For
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_mascota", objects[0]);
            datos.put("id_reserva", objects[1]);
            datos.put("estado_reserva", objects[2]);
            datos.put("fecha_entrega", objects[3]);
            datos.put("fecha_reserva", objects[4]);
            datos.put("tipo_reserva", objects[5]);

            json.add(datos);
        }

            for (Map<String, Object> Res : json) {
                System.out.println(Res);
            }

            return json;
    }

    //Agregar


    @PostMapping("/AgregarReserva/{id_mascota}")
    public String AgregaReserva(@RequestBody Reserva reservas,@PathVariable("id_mascota")Integer id_mascota){
        return servicio.AgregarReserva(id_mascota,reservas);
    }


    //Actualizar:
    @PutMapping("/actualizarReserva/{id_reserva}")
    public String actualizarReserva(@PathVariable("id_reserva") Integer id_reserva, @RequestBody Reserva ReservaActualizada) {
        return servicio.actualizarReservas(id_reserva, ReservaActualizada);
    }

    //Eliminar
    @DeleteMapping("/eliminarReserva/{id_reserva}")
    public String eliminarReserva(@PathVariable("id_reserva")Integer id_reserva){
        return servicio.EliminarReserva(id_reserva);
    }

}