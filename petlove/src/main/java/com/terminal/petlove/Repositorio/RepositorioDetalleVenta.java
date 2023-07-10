package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDetalleVenta extends JpaRepository<DetalleVenta,Integer> {


}


