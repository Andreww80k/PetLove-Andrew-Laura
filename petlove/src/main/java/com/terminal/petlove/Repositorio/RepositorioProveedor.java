package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProveedor extends JpaRepository <Proveedor,Integer>{
}
