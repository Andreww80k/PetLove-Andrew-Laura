package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface RepositorioRolUsuario extends JpaRepository<RolUsuario, Integer > {

    @Query(value = "SELECT rol.id_rol_usuario, rol.nombre_rol_usuario FROM rol_usuario AS rol WHERE rol.nombre_rol_usuario=rol.nombre_rol_usuario", nativeQuery = true)
    List<Object[]> ListarDatosRol();

//Buscar Nombre de rol
    @Query(value = "SELECT rol.id_rol_usuario, rol.nombre_rol_usuario FROM rol_usuario AS rol WHERE rol.nombre_rol_usuario=?1", nativeQuery = true)
    List<Object[]> ListarDatosRolNombre(String nombre_rol_usuario);

    @Query(value = "SELECT * FROM rol_usuario WHERE nombre_rol_usuario = :nombre_rol_usuario", nativeQuery = true)
    List<RolUsuario> buscarPorNombreRolUsuario(String nombre_rol_usuario);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rol_usuario WHERE nombre_rol_usuario = :nombre_rol_usuario", nativeQuery = true)
    void eliminarPorNombreRolUsuario(String nombre_rol_usuario);


}

