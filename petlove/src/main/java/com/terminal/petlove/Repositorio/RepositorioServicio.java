package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioServicio extends JpaRepository<Servicio, Integer> {

    @Query(value = "SELECT * FROM Servicio WHERE tipo_servicio = :tipo_servicio", nativeQuery = true)
    List<Object[]> buscarPorTipo(String tipo_servicio);

    @Query(value = "SELECT * FROM Servicio WHERE tipo_servicio = :tipo_servicio", nativeQuery = true)
    List<Servicio> buscarPorTipoServicio(String tipo_servicio);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Servicio WHERE tipo_servicio = :tipo_servicio", nativeQuery = true)
    void eliminarPorTipoServicio(String tipo_servicio);
}
