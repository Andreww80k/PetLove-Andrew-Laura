package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProducto extends JpaRepository<Producto,Integer> {
}
