package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioProducto extends JpaRepository<Producto,Integer> {


    @Query(value ="SELECT pr.id_producto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.nombre_producto", nativeQuery = true)
    List<Object[]> ListarDatosProducto();

    //Consulta para consultar y buscar por el nombre

    @Query(value = "SELECT pr.id_producto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.nombre_producto=?1",nativeQuery = true)
    List<Object[]>ListarProductoNombres(String nombre_producto);


    //Eliminar nombre:

    @Modifying
    @Query(value = "Delete from producto where nombre_producto=?1",nativeQuery = true)
    void eliminarProductoPorNombre(String nombre_producto);








}
