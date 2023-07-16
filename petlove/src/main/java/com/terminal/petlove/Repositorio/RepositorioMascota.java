package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Query("SELECT m FROM Mascota m WHERE m.nombre_mascota = :nombre_mascota")
    List<Mascota> buscarPorNombreMascota(String nombre_mascota);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Mascota m WHERE m.nombre_mascota = ?1")
    void eliminarPorNombreMascota(String nombre_mascota);

    @Query("SELECT m FROM Mascota m WHERE m.tipo_mascota = :tipo_mascota")
    List<Mascota> buscarPorTipoMascota(String tipo_mascota);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Mascota m WHERE m.tipo_mascota = ?1")
    void eliminarPorTipoMascota(String tipo_mascota);

}
