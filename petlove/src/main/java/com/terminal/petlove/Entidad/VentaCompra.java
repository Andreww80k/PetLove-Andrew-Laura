package com.terminal.petlove.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "venta_compra")
public class VentaCompra {


    @Id
    @Column(unique = true, length = 30)
    private Integer id_venta;

    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;

    @Column(nullable = false,length = 50)
    private String impuesto;

    @Column(nullable = false,length = 50)
    private String total;

    @Column(nullable = false,length = 50)
    private String estado_venta;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JsonIgnore
    private Set<DetalleVenta> detalleventa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;




    public VentaCompra() {
    }

    public VentaCompra(Integer id_venta, Date fecha_venta, String impuesto, String total, String estado_venta, Set<DetalleVenta> detalleventa, Usuario usuario) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.impuesto = impuesto;
        this.total = total;
        this.estado_venta = estado_venta;
        this.detalleventa = detalleventa;
        this.usuario = usuario;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEstado_venta() {
        return estado_venta;
    }

    public void setEstado_venta(String estado_venta) {
        this.estado_venta = estado_venta;
    }

    public Set<DetalleVenta> getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(Set<DetalleVenta> detalleventa) {
        this.detalleventa = detalleventa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "VentaCompra{" +
                "id_venta=" + id_venta +
                ", fecha_venta=" + fecha_venta +
                ", impuesto='" + impuesto + '\'' +
                ", total='" + total + '\'' +
                ", estado_venta='" + estado_venta + '\'' +
                ", detalleventa=" + detalleventa +
                ", usuario=" + usuario +
                '}';
    }
}
