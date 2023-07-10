package com.terminal.petlove.Controlador;

import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Servicio.ServicioProducto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorProducto {

    //Para instanciar la clase


    private ServicioProducto servicio;

    public ControladorProducto(ServicioProducto servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/ListarProducto")
    public ArrayList<Producto> listarPro() {
        return servicio.listarProducto();
    }


    //Crear el metodo de conntrolador para buscar Usuario

    @GetMapping("/buscarProducto/{id}")
    public Producto buscarProducto(@PathVariable("id") Integer id) {
        return servicio.buscarProducto(id);

    }


    //Crear metodo de agregar
    @PostMapping("/agregarProducto")
    public String agregarProducto(@RequestBody Producto Productos) {
        return servicio.agregarProducto(Productos);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarProducto")
    public String actualizarProducto(@RequestBody Producto Producto){
        return servicio.actualizarProducto(Producto);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id")Integer id){
        return  servicio.eliminarProducto(id);
    }
}
