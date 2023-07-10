package com.terminal.petlove.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @Column(unique = true, length = 30)
    private Integer id_detalleventa;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", nullable = false)
    @JsonIgnore
    private VentaCompra venta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @JsonIgnore


    private Producto producto;


    public DetalleVenta() {
    }

    public DetalleVenta(Integer id_detalleventa, VentaCompra venta, Producto producto) {
        this.id_detalleventa = id_detalleventa;
        this.venta = venta;
        this.producto = producto;
    }

    public Integer getId_detalleventa() {
        return id_detalleventa;
    }

    public void setId_detalleventa(Integer id_detalleventa) {
        this.id_detalleventa = id_detalleventa;
    }

    public VentaCompra getVenta() {
        return venta;
    }

    public void setVenta(VentaCompra venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalleventa=" + id_detalleventa +
                ", venta=" + venta +
                ", producto=" + producto +
                '}';
    }
}
