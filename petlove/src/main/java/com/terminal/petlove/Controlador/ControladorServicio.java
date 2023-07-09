package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Servicio;
import com.terminal.petlove.Servicio.ServicioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorServicio {

    private ServicioServicio servicio;

    public ControladorServicio(ServicioServicio servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/listarServicio")
    public ArrayList<Servicio> listarMasc() {
        return servicio.listarServicio();
    }


    //Crear el metodo de conntrolador para buscar Servicio

    @GetMapping("/buscarServicio/{id}")
    public Servicio buscarServicio(@PathVariable("id") Integer id) {
        return servicio.buscarServicio(id);

    }


    //Crear metodo de agregar
    @PostMapping("/agregarServicio")
    public String agregarServicio(@RequestBody Servicio Servicios) {
        return servicio.agregarServicio(Servicios);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarServicio")
    public String actualizarServicio(@RequestBody Servicio Servicio){
        return servicio.actualizarServicio(Servicio);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarServicio/{id}")
    public String eliminarServicio(@PathVariable("id")Integer id){
        return  servicio.eliminarServicio(id);
    }

}
