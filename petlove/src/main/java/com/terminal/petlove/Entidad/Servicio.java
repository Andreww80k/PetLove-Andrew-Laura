package com.terminal.petlove.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @Column(unique = true, length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_servicio;

    @Column(nullable = false, length = 30)
    public String tipo_servicio;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<ServicioReserva> servicio_reserva;



    public Servicio() {
    }

    public Servicio(Integer id_servicio, String tipo_servicio, Set<ServicioReserva> servicio_reserva) {
        this.id_servicio = id_servicio;
        this.tipo_servicio = tipo_servicio;
        this.servicio_reserva = servicio_reserva;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Set<ServicioReserva> getServicio_reserva() {
        return servicio_reserva;
    }

    public void setServicio_reserva(Set<ServicioReserva> servicio_reserva) {
        this.servicio_reserva = servicio_reserva;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id_servicio=" + id_servicio +
                ", tipo_servicio='" + tipo_servicio + '\'' +
                ", servicio_reserva=" + servicio_reserva +
                '}';
    }
}
