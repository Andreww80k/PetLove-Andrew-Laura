package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioProveedor extends JpaRepository <Proveedor,Integer>{



    //Consulta con consultas MySql

    @Query(value ="SELECT pro.id_proveedor, pro.apellido_proveedor, pro.contraseña_proveedor, pro.correo_proveedor, pro.direccion_proveedor, pro.nombre_proveedor,pro.telefono_proveedor FROM proveedor AS pro WHERE pro.nombre_proveedor=pro.nombre_proveedor", nativeQuery = true)
    List<Object[]> ListarDatosProveedor();

    @Query(value = "SELECT pro.id_proveedor, pro.apellido_proveedor, pro.contraseña_proveedor, pro.correo_proveedor, pro.direccion_proveedor, pro.nombre_proveedor,pro.telefono_proveedor FROM proveedor AS pro WHERE pro.id_proveedor=:dato",nativeQuery = true)
    List<Object[]>ListarDatosProveedorInner(Integer dato);

    //Para buscar por nombre:

    @Query(value ="SELECT pro.id_proveedor, pro.apellido_proveedor, pro.contraseña_proveedor, pro.correo_proveedor, pro.direccion_proveedor, pro.nombre_proveedor,pro.telefono_proveedor FROM proveedor AS pro WHERE pro.nombre_proveedor=?1", nativeQuery = true)
    List<Object[]> ListaProveedorNombre(String nombre_proveedor);



    //Meotod para buscar por gmail o correo del proveedor

    @Query(value ="SELECT pro.id_proveedor, pro.apellido_proveedor, pro.contraseña_proveedor, pro.correo_proveedor, pro.direccion_proveedor, pro.nombre_proveedor,pro.telefono_proveedor FROM proveedor AS pro WHERE pro.correo_proveedor=?1", nativeQuery = true)
    List<Object[]> ListaProveedorCorreo(String correo_proveedor);


    @Query("SELECT p FROM Proveedor p WHERE p.correo_proveedor = :correo_proveedor")
    List<Proveedor> buscarPorCorreoProveedor(String correo_proveedor);
    //para eliminar por string
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Proveedor p WHERE p.correo_proveedor = ?1", nativeQuery = true)
    void eliminarPorCorreoProveedor(String correo_proveedor);


}
