package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Proveedor;
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


    @GetMapping("/ListarReserva")
    public ArrayList<Reserva> listarReserva() {
        return servicio.listarReserva();
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
            datos.put("id_reserva", objects[0]);
            datos.put("estado_reserva", objects[1]);
            datos.put("fecha_entrega", objects[2]);
            datos.put("fecha_reserva", objects[3]);
            datos.put("tipo_reserva", objects[4]);
            datos.put("id_mascota", objects[5]);

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
            datos.put("id_reserva", objects[0]);
            datos.put("estado_reserva", objects[1]);
            datos.put("fecha_entrega", objects[2]);
            datos.put("fecha_reserva", objects[3]);
            datos.put("tipo_reserva", objects[4]);
            datos.put("id_mascota", objects[5]);

            json.add(datos);
        }

            for (Map<String, Object> Res : json) {
                System.out.println(Res);
            }

            return json;
    }

    @GetMapping("/BuscarEstadoReserva/{estado_reserva}")
    public List<Map<String, Object>> datosReservaEstado(@PathVariable("estado_reserva") String estado_reserva) {
        List<Object[]> lista = servicio.BuscarReservaEstado(estado_reserva);
        List<Map<String, Object>> json = new ArrayList<>();

        //For
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_reserva", objects[0]);
            datos.put("estado_reserva", objects[1]);
            datos.put("fecha_entrega", objects[2]);
            datos.put("fecha_reserva", objects[3]);
            datos.put("tipo_reserva", objects[4]);
            datos.put("id_mascota", objects[5]);

            json.add(datos);
        }

        for (Map<String, Object> Res : json) {
            System.out.println(Res);
        }

        return json;
    }


    @GetMapping("/BuscarTipoReserva/{tipo_reserva}")
    public List<Map<String, Object>> datosReservaTipo(@PathVariable("tipo_reserva") String tipo_reserva) {
        List<Object[]> lista = servicio.BuscarReservaTipo(tipo_reserva);
        List<Map<String, Object>> json = new ArrayList<>();

        //For
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_reserva", objects[0]);
            datos.put("estado_reserva", objects[1]);
            datos.put("fecha_entrega", objects[2]);
            datos.put("fecha_reserva", objects[3]);
            datos.put("tipo_reserva", objects[4]);
            datos.put("id_mascota", objects[5]);

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

    @DeleteMapping("/eliminarReservaEstado/{estado_reserva}")
    public String eliminarReservaPorEstado(@PathVariable("estado_reserva") String estadoReserva) {
        return servicio.eliminarReservaPorEstado(estadoReserva);
    }

    @DeleteMapping("/eliminarReservaTipo/{tipo_reserva}")
    public String eliminarReservaPorTipo(@PathVariable("tipo_reserva") String tipoReserva) {
        return servicio.eliminarReservaPorTipo(tipoReserva);
    }

}