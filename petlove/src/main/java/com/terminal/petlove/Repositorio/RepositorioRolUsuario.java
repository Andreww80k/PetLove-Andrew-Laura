package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RepositorioRolUsuario extends JpaRepository<RolUsuario, Integer > {


}

