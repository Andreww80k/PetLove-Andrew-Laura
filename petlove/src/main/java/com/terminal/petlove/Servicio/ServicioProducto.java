package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioProducto {
    private RepositorioProducto repositorio;

    public ServicioProducto(RepositorioProducto repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Producto> listarProducto(){
        return (ArrayList<Producto>) repositorio.findAll();
    }

    public Producto buscarProducto(Integer doc) {
        if(repositorio.findById(doc).isPresent())
            return repositorio.findById(doc).get();
        else return null;
    }

    public String agregarProducto(Producto Producto){
        if(repositorio.findById(Producto.getId_producto()).isPresent())
            return "El Producto ya se encuentra registardo";
        else repositorio.save(Producto);
        return "El Producto se registro exitosamente";
    }

    public String actualizarProducto(Producto productos){
        if(repositorio.findById(productos.getId_producto()).isPresent()) {
            repositorio.save(productos);
            return "El Producto se actualizo exitosamente";
        }
        else {return "El Producto no se puede actualizar porque no existe";}
    }

    public String eliminarProducto(Integer id){
        if(repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return "Producto eliminado exitosamente";
        }
        else return "Producto no registrado";
    }
}