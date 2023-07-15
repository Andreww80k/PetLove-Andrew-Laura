package com.terminal.petlove.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false,length = 50)
    private String nombre_usuario;

    @Column(nullable = false,length = 50)
    private String apellido_usuario;

    @Column(nullable = false,length = 50)
    private String telefono_usuario;

    @Column(nullable = false,length = 50)
    private String direccion_usuario;

    @Column(nullable = false,length = 50)
    public String correo_usuario;

    @Column(length = 50)
    private String contrasena_usuario;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_rol_usuario", referencedColumnName = "id_rol_usuario", nullable = false)
    @JsonIgnore
    private RolUsuario rol_usuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<Mascota> mascota;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<VentaCompra> venta_compra;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre_usuario, String apellido_usuario, String telefono_usuario, String direccion_usuario, String correo_usuario, String contrasena_usuario, RolUsuario rol_usuario, Set<Mascota> mascota, Set<VentaCompra> venta_compra) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.telefono_usuario = telefono_usuario;
        this.direccion_usuario = direccion_usuario;
        this.correo_usuario = correo_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.rol_usuario = rol_usuario;
        this.mascota = mascota;
        this.venta_compra = venta_compra;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public RolUsuario getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(RolUsuario rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public Set<Mascota> getMascota() {
        return mascota;
    }

    public void setMascota(Set<Mascota> mascota) {
        this.mascota = mascota;
    }

    public Set<VentaCompra> getVenta_compra() {
        return venta_compra;
    }

    public void setVenta_compra(Set<VentaCompra> venta_compra) {
        this.venta_compra = venta_compra;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", apellido_usuario='" + apellido_usuario + '\'' +
                ", telefono_usuario='" + telefono_usuario + '\'' +
                ", direccion_usuario='" + direccion_usuario + '\'' +
                ", correo_usuario='" + correo_usuario + '\'' +
                ", contrasena_usuario='" + contrasena_usuario + '\'' +
                ", rol_usuario=" + rol_usuario +
                ", mascota=" + mascota +
                ", venta_compra=" + venta_compra +
                '}';
    }
}
