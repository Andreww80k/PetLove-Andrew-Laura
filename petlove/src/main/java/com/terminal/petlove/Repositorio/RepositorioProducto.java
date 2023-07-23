package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RepositorioProducto extends JpaRepository<Producto,Integer> {

    @Query(value ="SELECT pr.idproducto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.nombre_producto=pr.nombre_producto", nativeQuery = true)
    List<Object[]> ListarDatosProducto();

    //Consulta para consultar y buscar por el nombre

    @Query(value = "SELECT pr.idproducto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.nombre_producto=?1",nativeQuery = true)
    List<Object[]>ListarProductoNombres(String nombre_producto);

    @Query(value = "SELECT pr.idproducto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.stock_producto=?1",nativeQuery = true)
    List<Object[]>ListarProductoStock(int stock_producto);

    @Query(value = "SELECT pr.idproducto, pr.descripcion_producto, pr.nombre_producto, pr.precio_producto, pr.stock_producto FROM producto AS pr WHERE pr.idproducto=:dato",nativeQuery = true)
    List<Object[]>ListarProductoInner(Integer dato);

    //Eliminar nombre:
    @Query(value = "SELECT * FROM Producto WHERE nombre_producto = :nombre_producto", nativeQuery = true)
    List<Producto> buscarPorNombreProducto(String nombre_producto);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Producto WHERE nombre_producto = :nombre_producto", nativeQuery = true)
    void eliminarPorNombreProducto(String nombre_producto);





}
