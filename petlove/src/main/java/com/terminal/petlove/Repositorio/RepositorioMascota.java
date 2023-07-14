package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMascota extends JpaRepository<Mascota, Integer> {

    @Query(value ="select u.id_usuario, m.id_mascota, m.edad_mascota ,m.nombre_mascota, m.peso_mascota, m.raza_mascota,m.tipo_mascota from usuario as u inner join mascota as m on u.id_usuario=m.id_usuario;", nativeQuery = true)
    List<Object[]> ListarDatosMascotas();



    //Para buscar por llaves foraneas:
    @Query(value ="select u.id_usuario, m.id_mascota, m.edad_mascota ,m.nombre_mascota, m.peso_mascota, m.raza_mascota,m.tipo_mascota from usuario as u inner join mascota as m on u.id_usuario=m.id_usuario=:dato", nativeQuery = true)
    List<Object[]> ListarDatosMascotasInner(Integer dato);



    //Para buscar por nombre de la mascota

    @Query(value = "SELECT m.id_mascota, m.edad_mascota, m.nombre_mascota , m.peso_mascota, m.raza_mascota, m.tipo_mascota FROM mascota AS m WHERE m.nombre_mascota= ?1",nativeQuery = true)
    List <Object[]>ListarMascotasNombre(String nombre_mascota);
}
