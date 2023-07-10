package com.terminal.petlove.Controlador;

import com.terminal.petlove.Entidad.Proveedor;
import com.terminal.petlove.Servicio.ServicioProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class ControladorProveedor {
    private ServicioProveedor servicio;

    public ControladorProveedor(ServicioProveedor servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/ListarProveedor")
    public ArrayList<Proveedor> listarProvee() {
        return servicio.listarProveedor();
    }


    //Crear el metodo de conntrolador para buscar Usuario

    @GetMapping("/buscarProveedor/{id}")
    public Proveedor buscarProveedor(@PathVariable("id") Integer id) {
        return servicio.buscarProveedor(id);

    }

    //Crear metodo de agregar
    @PostMapping("/agregarProveedor")
    public String agregarProveedor(@RequestBody Proveedor Proveedors) {
        return servicio.agregarProveedor(Proveedors);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarProveedor")
    public String actualizarProveedor(@RequestBody Proveedor Proveedors){
        return servicio.actualizarProveedor(Proveedors);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id")Integer id){
        return  servicio.eliminarProveedor(id);
    }
}
