package com.terminal.petlove.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "producto_proveedor")
public class Producto_Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto_proveedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto", nullable = false)
    @JsonIgnore
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @JsonIgnore
    private Proveedor proveedor;

    public Producto_Proveedor(Integer id_producto_proveedor, Producto producto, Proveedor proveedor) {
        this.id_producto_proveedor = id_producto_proveedor;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public Producto_Proveedor() {
    }

    public Integer getId_producto_proveedor() {
        return id_producto_proveedor;
    }

    public void setId_producto_proveedor(Integer id_producto_proveedor) {
        this.id_producto_proveedor = id_producto_proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto_Proveedor{" +
                "id_producto_proveedor=" + id_producto_proveedor +
                ", producto=" + producto +
                ", proveedor=" + proveedor +
                '}';
    }
}
