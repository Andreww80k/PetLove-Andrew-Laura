package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.*;
import com.terminal.petlove.Repositorio.RepositorioMascota;
import com.terminal.petlove.Repositorio.RepositorioReserva;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioReserva {

    private RepositorioReserva repositorio;


    //Repositorios de la tabla inner join:


    private RepositorioMascota RepoMas;

    public ServicioReserva(RepositorioReserva repositorio, RepositorioMascota repoMas) {
        this.repositorio = repositorio;
        RepoMas = repoMas;
    }

    //Metodos

    public ArrayList<Reserva> listarReserva(){
        return (ArrayList<Reserva>) repositorio.findAll();
    }
    public List<Object[]>DatosReserva(){
        return repositorio.ListarReservas();
    }

    public ArrayList<Reserva> obtenerReservasPorFecha(LocalDate fecha_reserva) {
        return repositorio.obtenerReservasPorFecha(fecha_reserva);
    }

    public List<Object[]>BuscarReservaInner(Integer dato) {
        return repositorio.ListarReservasInner(dato);
    }

    public List<Object[]> BuscarReservaEstado(String estado_reserva) {
        return repositorio.buscarPorEstado(estado_reserva);
    }

    public List<Object[]> BuscarReservaTipo(String tipo_reserva) {
        return repositorio.buscarPorTipo(tipo_reserva);
    }

        //Metodo para agregar foraneas:


    public String agregarReservaSiNoExiste(Integer id_mascota, Reserva nuevaReserva) {
        if (nuevaReserva.getFecha_reserva() == null || nuevaReserva.getHora_desarrollo_reserva() == null) {
            return "Error: La fecha_reserva y la hora_desarrollo_reserva deben tener valores válidos";
        }

        LocalDate fechaReservaNueva = nuevaReserva.getFecha_reserva();
        LocalTime horaReservaNueva = nuevaReserva.getHora_desarrollo_reserva();

        // Comprobamos si ya existe una reserva con la misma fecha y hora
        List<Reserva> reservasExistentes = repositorio.findAll();
        for (Reserva reservaExistente : reservasExistentes) {
            LocalDate fechaReservaExistente = reservaExistente.getFecha_reserva();
            LocalTime horaReservaExistente = reservaExistente.getHora_desarrollo_reserva();

            if (fechaReservaExistente.equals(fechaReservaNueva) && horaReservaExistente.equals(horaReservaNueva)) {
                return "Ya existe una reserva con la misma fecha y hora";
            }
        }

        // Si no existe, procedemos a agregar la reserva
        // (Puedes implementar tu lógica de validación adicional aquí, si es necesario)
        Optional<Mascota> optionalMascota = RepoMas.findById(id_mascota);
        if (optionalMascota.isPresent()) {
            Mascota mas = optionalMascota.get();
            nuevaReserva.setMascota(mas);
            repositorio.save(nuevaReserva);

            return "Reserva agregada correctamente";
        } else {
            return "Error al agregar Reserva: No se encontró la mascota con ID " + id_mascota;
        }
    }


    public String AgregarReserva(Integer id_mascota, Reserva reservas){
            if (RepoMas.findById(id_mascota).isPresent()) {
                Mascota mas = RepoMas.findById(id_mascota).get();
                reservas.setMascota(mas);
                repositorio.save(reservas);

                return "Reserva agregada correctamente";

            }else {
                return "Error al agregar Reserva";

            }

        }



    public String actualizarReservas(Integer id_reserva, Reserva ReservaActualizada) {
        Optional<Reserva> reservaOptional = repositorio.findById(id_reserva);

        if (reservaOptional.isPresent()) {
            Reserva ReservaExistente = reservaOptional.get();
            if (ReservaActualizada.getFecha_reserva() != null) {
                ReservaExistente.setFecha_reserva(ReservaActualizada.getFecha_reserva());
            }
            if (ReservaActualizada.getHora_desarrollo_reserva() != null) {
                ReservaExistente.setHora_desarrollo_reserva(ReservaActualizada.getHora_desarrollo_reserva());
            }
            if (ReservaActualizada.getTipo_reserva() != null) {
                ReservaExistente.setTipo_reserva(ReservaActualizada.getTipo_reserva());
            }
            if (ReservaActualizada.getEstado_reserva() != null) {
                ReservaExistente.setEstado_reserva(ReservaActualizada.getEstado_reserva());
            }

            repositorio.save(ReservaExistente);
            return "Reserva actualizada exitosamente.";
        } else {
            return "Error al actualizar Reserva rectifica";
        }
    }



    public String EliminarReserva(Integer id_reserva){
        if (repositorio.findById(id_reserva).isPresent()){
            repositorio.deleteById(id_reserva);
            return "Se ha eliminado la reserva por completo";
        } else {
            return "No se registra ninguna reserva para eliminar";
        }
    }

    public String eliminarReservaPorEstado(String estado_reserva) {
        List<Reserva> reservas = repositorio.buscarPorEstadoReserva(estado_reserva);

        if (!reservas.isEmpty()) {
            repositorio.eliminarPorEstadoReserva(estado_reserva);
            return "Se ha eliminado la reserva por su estado";
        } else {
            return "No se ha encontrado la reserva con ese estado";
        }
    }

    public String eliminarReservaPorTipo(String tipo_reserva) {
        List<Reserva> reservas = repositorio.buscarPorTipoReserva(tipo_reserva);

        if (!reservas.isEmpty()) {
            repositorio.eliminarPorTipoReserva(tipo_reserva);
            return "Se han eliminado las reservas por su tipo";
        } else {
            return "No se han encontrado reservas con ese tipo";
        }
    }

}
