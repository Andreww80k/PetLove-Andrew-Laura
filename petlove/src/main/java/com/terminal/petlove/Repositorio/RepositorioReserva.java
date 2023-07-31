package com.terminal.petlove.Repositorio;

import com.terminal.petlove.Entidad.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepositorioReserva extends JpaRepository<Reserva, Integer> {


    //Consulta inner join para usuario:



    @Query(value = "SELECT * FROM reserva",nativeQuery = true)
    List<Object[]>ListarReservas();

    //Para buscar por id siendo un inner join con llave foranea:


    @Query(value = "SELECT * FROM Reserva WHERE id_reserva =:dato",nativeQuery = true)
    List<Object[]>ListarReservasInner(Integer dato);

    @Query(value = "SELECT * FROM Reserva WHERE id_reserva =:id_reserva",nativeQuery = true)
    List<Reserva>buscarPorId(Integer id_reserva);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Reserva WHERE id_reserva = :id_reserva", nativeQuery = true)
    void eliminarPorIdReserva(Integer id_reserva);

    @Query(value = "SELECT * FROM Reserva WHERE estado_reserva = :estado_reserva", nativeQuery = true)
    List<Object[]> buscarPorEstado(String estado_reserva);

    @Query(value = "SELECT * FROM Reserva WHERE tipo_reserva = :tipo_reserva", nativeQuery = true)
    List<Object[]> buscarPorTipo(String tipo_reserva);

    @Query(value = "SELECT * FROM Reserva WHERE estado_reserva = :estado_reserva", nativeQuery = true)
    List<Reserva> buscarPorEstadoReserva(String estado_reserva);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Reserva WHERE estado_reserva = :estado_reserva", nativeQuery = true)
    void eliminarPorEstadoReserva(String estado_reserva);

    @Query(value = "SELECT * FROM Reserva WHERE tipo_reserva = :tipo_reserva", nativeQuery = true)
    List<Reserva> buscarPorTipoReserva(String tipo_reserva);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Reserva WHERE tipo_reserva = :tipo_reserva", nativeQuery = true)
    void eliminarPorTipoReserva(String tipo_reserva);

    @Query("SELECT r FROM Reserva r WHERE r.fecha_reserva = ?1")
    ArrayList<Reserva> obtenerReservasPorFecha(LocalDate fecha_reserva);

}
