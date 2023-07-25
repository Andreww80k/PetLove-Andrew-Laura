package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.VentaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCompraVenta extends JpaRepository<VentaCompra, Integer> {


    @Query(value = "select usu.id_usuario, vent.id_venta, vent.estado_venta, vent.fecha_venta , vent.impuesto ,vent.total from venta_compra as vent inner join usuario as usu on usu.id_usuario=vent.id_usuario", nativeQuery = true)
    List<Object[]> ListarDatosCompraVenta();


    @Query(value = "select usu.id_usuario, vent.id_venta, vent.estado_venta, vent.fecha_venta , vent.impuesto ,vent.total from venta_compra as vent inner join usuario as usu on usu.id_usuario=vent.id_usuario=:dato",nativeQuery = true)
    List<Object[]>ListarDatosCompraVentaInner(Integer dato);


    @Query(value = "SELECT vc.id_venta, vc.estado_venta, vc.fecha_venta, vc.impuesto, vc.total FROM venta_compra AS vc WHERE vc.estado_venta=?1",nativeQuery = true)
    List<Object[]>ListarCompraVentaEstado(String estado_venta);

    @Query(value = "select d.id_venta, v.estado_venta, v.fecha_venta, v.impuesto, v.total, v.id_usuario, u.nombre_usuario, u.apellido_usuario, u.correo_usuario, u.telefono_usuario, u.direccion_usuario, d.id_producto, p.descripcion_producto, p.nombre_producto, p.precio_producto from detalle_venta as d inner join venta_compra as v on d.id_venta = v.id_venta inner join usuario as u on v.id_usuario = u.id_usuario inner join producto as p on d.id_producto = p.id_producto where u.id_usuario =:idusuario", nativeQuery = true)
    List<Object[]> ListarOrdenesCompra(Integer idusuario);


}
