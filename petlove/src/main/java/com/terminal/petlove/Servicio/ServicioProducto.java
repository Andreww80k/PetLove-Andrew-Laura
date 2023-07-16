package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProducto {
    private RepositorioProducto repositorio;

    public ServicioProducto(RepositorioProducto repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Producto> listarProducto(){
        return (ArrayList<Producto>) repositorio.findAll();
    }

    public List<Object[]>DatosProductos(){
        return repositorio.ListarDatosProducto();
    }


    //Servicio para buscar por nombre
    public List<Object[]>ListarProductoNombres(String nombre_producto){
        return repositorio.ListarProductoNombres(nombre_producto);
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

    public String EliminarProducto(Integer id_producto){
        if (repositorio.findById(id_producto).isPresent()){
            repositorio.deleteById(id_producto);
            return "Se ha eliminado El producto por completo";
        } else {
            return "No se registra ningun producto para eliminar";
        }
    }

    public String eliminarProductoPorNombre(String nombre_producto) {
        List<Producto> productos = repositorio.buscarPorNombreProducto(nombre_producto);

        if (productos.isEmpty()) {
            repositorio.eliminarPorNombreProducto(nombre_producto);
            return "Se ha eliminado el producto por su nombre";
        } else {
            return "No se ha encontrado el producto con ese nombre";
        }
    }




}