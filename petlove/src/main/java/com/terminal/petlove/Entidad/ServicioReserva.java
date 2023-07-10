package com.terminal.petlove.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "servicio_reserva")
public class ServicioReserva {

    @Id
    @Column(unique = true, length = 30)
    private Integer id_servicio_reserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", nullable = false)
    @JsonIgnore
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    @JsonIgnore
    private Servicio servicio;

    public ServicioReserva(Integer id_servicio_reserva, Reserva reserva, Servicio servicio) {
        this.id_servicio_reserva = id_servicio_reserva;
        this.reserva = reserva;
        this.servicio = servicio;
    }

    public ServicioReserva() {
    }

    public Integer getId_servicio_reserva() {
        return id_servicio_reserva;
    }

    public void setId_servicio_reserva(Integer id_servicio_reserva) {
        this.id_servicio_reserva = id_servicio_reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "ServicioReserva{" +
                "id_servicio_reserva=" + id_servicio_reserva +
                ", reserva=" + reserva +
                ", servicio=" + servicio +
                '}';
    }
}
