package com.terminal.petlove.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(nullable = false, length = 30)
    public String nombre_producto;

    @Column(nullable = false, length = 50)
    private String descripcion_producto;

    @Column(nullable = false, length = 30)
    private int precio_producto;

    @Column(nullable = false, length = 30)
    private int stock_producto;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<DetalleVenta> detalleventa;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Producto_Proveedor> producto_proveedor;


    public Producto() {
    }

    public Producto(Integer id_producto, String nombre_producto, String descripcion_producto, int precio_producto, int stock_producto, Set<DetalleVenta> detalleventa, Set<Producto_Proveedor> producto_proveedor) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
        this.detalleventa = detalleventa;
        this.producto_proveedor = producto_proveedor;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public Set<DetalleVenta> getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(Set<DetalleVenta> detalleventa) {
        this.detalleventa = detalleventa;
    }

    public Set<Producto_Proveedor> getProducto_proveedor() {
        return producto_proveedor;
    }

    public void setProducto_proveedor(Set<Producto_Proveedor> producto_proveedor) {
        this.producto_proveedor = producto_proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", precio_producto=" + precio_producto +
                ", stock_producto=" + stock_producto +
                ", detalleventa=" + detalleventa +
                ", producto_proveedor=" + producto_proveedor +
                '}';
    }
}
