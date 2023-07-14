package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositorioRolUsuario extends JpaRepository<RolUsuario, Integer > {

    @Query(value = "SELECT rol.id_rol_usuario, rol.nombre_rol_usuario FROM rol_usuario AS rol WHERE rol.nombre_rol_usuario", nativeQuery = true)
    List<Object[]> ListarDatosRol();

//Buscar Nombre de rol
    @Query(value = "SELECT rol.id_rol_usuario, rol.nombre_rol_usuario FROM rol_usuario AS rol WHERE rol.nombre_rol_usuario=?1", nativeQuery = true)
    List<Object[]> ListarDatosRolNombre(String nombre_rol_usuario);

}

