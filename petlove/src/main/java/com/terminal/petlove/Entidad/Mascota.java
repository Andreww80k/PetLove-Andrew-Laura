package com.terminal.petlove.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue
    @Column(unique = true, length = 30)
    private Integer id_mascota;

    @Column(nullable = false, length = 50)
    private String nombre_mascota;

    @Column(nullable = false, length = 50)
    private String raza_mascota;

    @Column(nullable = false, length = 50)
    private String tipo_mascota;

    @Column(nullable = false, length = 50)
    private String edad_mascota;

    @Column(nullable = false, length = 50)
    private String peso_mascota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<Reserva> reserva;

    public Mascota() {
    }

    public Mascota(Integer id_mascota, String nombre_mascota, String raza_mascota, String tipo_mascota, String edad_mascota, String peso_mascota, Usuario usuario, Set<Reserva> reserva) {
        this.id_mascota = id_mascota;
        this.nombre_mascota = nombre_mascota;
        this.raza_mascota = raza_mascota;
        this.tipo_mascota = tipo_mascota;
        this.edad_mascota = edad_mascota;
        this.peso_mascota = peso_mascota;
        this.usuario = usuario;
        this.reserva = reserva;
    }

    public Integer getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza_mascota() {
        return raza_mascota;
    }

    public void setRaza_mascota(String raza_mascota) {
        this.raza_mascota = raza_mascota;
    }

    public String getTipo_mascota() {
        return tipo_mascota;
    }

    public void setTipo_mascota(String tipo_mascota) {
        this.tipo_mascota = tipo_mascota;
    }

    public String getEdad_mascota() {
        return edad_mascota;
    }

    public void setEdad_mascota(String edad_mascota) {
        this.edad_mascota = edad_mascota;
    }

    public String getPeso_mascota() {
        return peso_mascota;
    }

    public void setPeso_mascota(String peso_mascota) {
        this.peso_mascota = peso_mascota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id_mascota=" + id_mascota +
                ", nombre_mascota='" + nombre_mascota + '\'' +
                ", raza_mascota='" + raza_mascota + '\'' +
                ", tipo_mascota='" + tipo_mascota + '\'' +
                ", edad_mascota='" + edad_mascota + '\'' +
                ", peso_mascota='" + peso_mascota + '\'' +
                ", usuario=" + usuario +
                ", reserva=" + reserva +
                '}';
    }
}
