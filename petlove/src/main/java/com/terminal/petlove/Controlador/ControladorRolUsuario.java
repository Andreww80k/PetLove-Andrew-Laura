package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Servicio.ServicioRolUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorRolUsuario {

    private ServicioRolUsuario servicio;

    public ControladorRolUsuario(ServicioRolUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarRolUsuario")
    public ArrayList<RolUsuario> listarRolUsuario() {
        return servicio.listarRol_Usuario();
    }


    //Crear el metodo de conntrolador para buscar Rol

    @GetMapping("/buscarRolUsuario/{id}")
    public RolUsuario buscarRolUsuario(@PathVariable("id") Integer id) {
        return servicio.buscarRol_Usuario(id);

    }


    //Crear metodo de agregar
    @PostMapping("/agregarRolUsuario")
    public String agregarRolUsuario(@RequestBody RolUsuario RolUsuario) {
        return servicio.agregarRol_Usuario(RolUsuario);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarRolUsuario")
    public String actualizarRolUsuario(@RequestBody RolUsuario RolUsuario){
        return servicio.actualizarRol_Usuario(RolUsuario);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarRolUsuario/{id}")
    public String eliminarRolUsuario(@PathVariable("id")Integer id){
        return  servicio.eliminarRol_Usuario(id);
    }

}
