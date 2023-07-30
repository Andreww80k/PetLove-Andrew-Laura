package com.terminal.petlove.Entidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "rol_usuario")
public class RolUsuario {
    @Id
    @Column(unique = true, length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol_usuario;

    @Column(unique = true, length = 30)
    public String nombre_rol_usuario;

    @OneToMany(mappedBy = "rol_usuario", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<Usuario> usuario;


    public RolUsuario() {
    }


    public RolUsuario(Integer id_rol_usuario, String nombre_rol_usuario, Set<Usuario> usuario) {
        this.id_rol_usuario = id_rol_usuario;
        this.nombre_rol_usuario = nombre_rol_usuario;
        this.usuario = usuario;
    }

    public Integer getId_rol_usuario() {
        return id_rol_usuario;
    }

    public void setId_rol_usuario(Integer id_rol_usuario) {
        this.id_rol_usuario = id_rol_usuario;
    }

    public String getNombre_rol_usuario() {
        return nombre_rol_usuario;
    }

    public void setNombre_rol_usuario(String nombre_rol_usuario) {
        this.nombre_rol_usuario = nombre_rol_usuario;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }


}
