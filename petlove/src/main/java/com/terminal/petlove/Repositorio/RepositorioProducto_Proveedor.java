package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Producto_Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioProducto_Proveedor extends JpaRepository<Producto_Proveedor,Integer> {
    //Inner Join Makio

    @Query(value ="select pp.id_producto_proveedor,p.nombre_proveedor, p.id_proveedor, p.correo_proveedor, pr.id_producto, pr.nombre_producto, pr.precio_producto from producto_proveedor as pp inner join proveedor as p on pp.id_proveedor=p.id_proveedor inner join producto as pr on pp.id_producto=pr.id_producto", nativeQuery = true)
    List<Object[]> ListarDatosProductosProveedor();


    //Para buscar por un id siendo inner join con llave foranea
    @Query(value ="select pp.id_producto_proveedor,p.nombre_proveedor, p.id_proveedor, p.correo_proveedor, pr.id_producto, pr.nombre_producto, pr.precio_producto from producto_proveedor as pp inner join proveedor as p on pp.id_proveedor=p.id_proveedor inner join producto as pr on pp.id_producto=pr.id_producto where pp.id_producto_proveedor=:dato", nativeQuery = true)
    List<Object[]>ListarDatosProductosProveedorinner(Integer dato);
}
