package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    //Consulta de inner join para usuario


    @Query(value = "select ru.id_rol_usuario,u.id_usuario, u.apellido_usuario, u.contrasena_usuario, u.correo_usuario ,u.direccion_usuario, u.nombre_usuario, u.telefono_usuario from rol_usuario as ru inner join usuario as u on ru.id_rol_usuario=u.id_rol_usuario", nativeQuery = true)
    List<Object[]>ListarDatosUsuarios();


    //Para buscar por un id siendo un inner join con llave foranea

    @Query(value = "select ru.id_rol_usuario,u.id_usuario, u.apellido_usuario, u.contrasena_usuario, u.correo_usuario ,u.direccion_usuario, u.nombre_usuario, u.telefono_usuario from rol_usuario as ru inner join usuario as u on ru.id_rol_usuario=u.id_rol_usuario=:dato",nativeQuery = true)
    List<Object[]>ListarDatosUsuarioInner(Integer dato);
}
