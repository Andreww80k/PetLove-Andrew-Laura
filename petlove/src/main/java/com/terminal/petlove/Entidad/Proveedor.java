package com.terminal.petlove.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

    @Entity
    @Table(name = "proveedor")
    public class Proveedor {
        @Id
        @Column(unique = true, length = 30)
        private Integer id_proveedor;

        @Column(nullable = false, length = 50)
        private String nombre_proveedor;

        @Column(nullable = false, length = 50)
        private String apellido_proveedor;

        @Column(nullable = false, length = 50)
        private String telefono_proveedor;

        @Column(nullable = false, length = 50)
        private String direccion_proveedor;

        @Column(nullable = false, length = 50)
        private String correo_proveedor;

        @Column(nullable = false, length = 50)
        private String contraseña_proveedor;

        @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonIgnore
        private Set<Producto_Proveedor> producto_proveedor;

        public Proveedor(Integer id_proveedor, String nombre_proveedor, String apellido_proveedor, String telefono_proveedor, String direccion_proveedor, String correo_proveedor, String contraseña_proveedor, Set<Producto_Proveedor> producto_proveedor) {
            this.id_proveedor = id_proveedor;
            this.nombre_proveedor = nombre_proveedor;
            this.apellido_proveedor = apellido_proveedor;
            this.telefono_proveedor = telefono_proveedor;
            this.direccion_proveedor = direccion_proveedor;
            this.correo_proveedor = correo_proveedor;
            this.contraseña_proveedor = contraseña_proveedor;
            this.producto_proveedor = producto_proveedor;
        }

        public Proveedor() {
        }

        public Integer getId_proveedor() {
            return id_proveedor;
        }

        public void setId_proveedor(Integer id_proveedor) {
            this.id_proveedor = id_proveedor;
        }

        public String getNombre_proveedor() {
            return nombre_proveedor;
        }

        public void setNombre_proveedor(String nombre_proveedor) {
            this.nombre_proveedor = nombre_proveedor;
        }

        public String getApellido_proveedor() {
            return apellido_proveedor;
        }

        public void setApellido_proveedor(String apellido_proveedor) {
            this.apellido_proveedor = apellido_proveedor;
        }

        public String getTelefono_proveedor() {
            return telefono_proveedor;
        }

        public void setTelefono_proveedor(String telefono_proveedor) {
            this.telefono_proveedor = telefono_proveedor;
        }

        public String getDireccion_proveedor() {
            return direccion_proveedor;
        }

        public void setDireccion_proveedor(String direccion_proveedor) {
            this.direccion_proveedor = direccion_proveedor;
        }

        public String getCorreo_proveedor() {
            return correo_proveedor;
        }

        public void setCorreo_proveedor(String correo_proveedor) {
            this.correo_proveedor = correo_proveedor;
        }

        public String getContraseña_proveedor() {
            return contraseña_proveedor;
        }

        public void setContraseña_proveedor(String contraseña_proveedor) {
            this.contraseña_proveedor = contraseña_proveedor;
        }

        public Set<Producto_Proveedor> getProducto_proveedor() {
            return producto_proveedor;
        }

        public void setProducto_proveedor(Set<Producto_Proveedor> producto_proveedor) {
            this.producto_proveedor = producto_proveedor;
        }

        @Override
        public String toString() {
            return "Proveedor{" +
                    "id_proveedor=" + id_proveedor +
                    ", nombre_proveedor='" + nombre_proveedor + '\'' +
                    ", apellido_proveedor='" + apellido_proveedor + '\'' +
                    ", telefono_proveedor='" + telefono_proveedor + '\'' +
                    ", direccion_proveedor='" + direccion_proveedor + '\'' +
                    ", correo_proveedor='" + correo_proveedor + '\'' +
                    ", contraseña_proveedor='" + contraseña_proveedor + '\'' +
                    ", producto_proveedor=" + producto_proveedor +
                    '}';
        }

    }
