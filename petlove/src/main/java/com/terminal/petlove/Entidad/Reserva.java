package com.terminal.petlove.Entidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @Column(unique = true, length = 30)
    private Integer id_reserva;

    @Column(name = "fecha_reserva")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private java.util.Date fecha_reserva;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fecha_desarrollo_reserva;

    @Column(nullable = false, length = 30)
    private String tipo_reserva;

    @Column(nullable = false, length = 30)
    public String estado_reserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_mascota", referencedColumnName = "id_mascota", nullable = false)
    @JsonIgnore
    private Mascota mascota;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ServicioReserva> servicio_reserva;


    public Reserva() {
    }

    public Reserva(Integer id_reserva, Date fecha_reserva, Date fecha_desarrollo_reserva, String tipo_reserva, String estado_reserva, Mascota mascota, Set<ServicioReserva> servicio_reserva) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.fecha_desarrollo_reserva = fecha_desarrollo_reserva;
        this.tipo_reserva = tipo_reserva;
        this.estado_reserva = estado_reserva;
        this.mascota = mascota;
        this.servicio_reserva = servicio_reserva;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_desarrollo_reserva() {
        return fecha_desarrollo_reserva;
    }

    public void setFecha_desarrollo_reserva(Date fecha_desarrollo_reserva) {
        this.fecha_desarrollo_reserva = fecha_desarrollo_reserva;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Set<ServicioReserva> getServicio_reserva() {
        return servicio_reserva;
    }

    public void setServicio_reserva(Set<ServicioReserva> servicio_reserva) {
        this.servicio_reserva = servicio_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id_reserva=" + id_reserva +
                ", fecha_reserva=" + fecha_reserva +
                ", fecha_desarrollo_reserva=" + fecha_desarrollo_reserva +
                ", tipo_reserva='" + tipo_reserva + '\'' +
                ", estado_reserva='" + estado_reserva + '\'' +
                ", mascota=" + mascota +
                ", servicio_reserva=" + servicio_reserva +
                '}';
    }
}
