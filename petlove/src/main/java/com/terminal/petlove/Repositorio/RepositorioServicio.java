package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioServicio extends JpaRepository<Servicio, Integer> {
}
