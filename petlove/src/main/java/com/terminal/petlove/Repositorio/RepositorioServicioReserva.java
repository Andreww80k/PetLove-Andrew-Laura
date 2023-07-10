package com.terminal.petlove.Repositorio;


import com.terminal.petlove.Entidad.ServicioReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioServicioReserva extends JpaRepository<ServicioReserva, Integer> {
    @Query(value = "select sr.id_servicio_reserva,s.tipo_servicio, re.id_reserva, re.estado_reserva, re.fecha_entrega, re.fecha_reserva, re.tipo_reserva from servicio_reserva as sr inner join reserva as re on sr.id_reserva=re.id_reserva inner join servicio as s on sr.id_servicio=s.id_servicio", nativeQuery = true)
    List<Object[]> ListarDatosDetalleVenta();



    @Query(value = "select sr.id_servicio_reserva,s.tipo_servicio, re.id_reserva, re.estado_reserva, re.fecha_entrega, re.fecha_reserva, re.tipo_reserva from servicio_reserva as sr inner join reserva as re on sr.id_reserva=re.id_reserva inner join servicio as s on sr.id_servicio=s.id_servicio=:dato", nativeQuery = true)
    List<Object[]> ListarDatosDetalleVentaInner(Integer dato);
}
