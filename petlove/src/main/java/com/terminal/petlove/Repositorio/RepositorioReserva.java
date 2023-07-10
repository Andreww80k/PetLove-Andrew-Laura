package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioReserva extends JpaRepository<Reserva, Integer> {


    //Consulta inner join para usuario:



    @Query(value = "select mas.id_mascota, res.id_reserva, res.estado_reserva, res.fecha_entrega , res.fecha_reserva,res.tipo_reserva from reserva as res inner join mascota as mas on mas.id_mascota=res.id_mascota",nativeQuery = true)
    List<Object[]>ListarReservas();



    //Para buscar por id siendo un inner join con llave foranea:


    @Query(value = "select mas.id_mascota, res.id_reserva, res.estado_reserva, res.fecha_entrega , res.fecha_reserva,res.tipo_reserva from reserva as res inner join mascota as mas on mas.id_mascota=res.id_mascota=:dato",nativeQuery = true)
    List<Object[]>ListarReservasInner(Integer dato);
}
