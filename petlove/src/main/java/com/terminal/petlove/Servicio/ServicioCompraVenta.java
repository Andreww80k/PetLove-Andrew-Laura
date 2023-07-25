package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Entidad.VentaCompra;
import com.terminal.petlove.Repositorio.RepositorioCompraVenta;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioCompraVenta {

    private RepositorioCompraVenta repositorio;

    //repositorio inner:
    private RepositorioUsuario RepoUsu;

    public ServicioCompraVenta(RepositorioCompraVenta repositorio, RepositorioUsuario repoUsu) {
        this.repositorio = repositorio;
        RepoUsu = repoUsu;
    }

    //Metodos

    public List<Object[]>DatosCompraVenta(){
        return repositorio.ListarDatosCompraVenta();
    }


    public List<Object[]>DatosCompraVentaInner(Integer dato){
        return  repositorio.ListarDatosCompraVentaInner(dato);
    }


    public List<Object[]>BuscarDetalleVentaEstado(String estado_venta){
        return repositorio.ListarCompraVentaEstado(estado_venta);
    }

    public List<Object[]> ListarOrdenesCompra(Integer idUsuario){
        return repositorio.ListarOrdenesCompra(idUsuario);
    }



    //Agregar:


    public String AgregarCompraVenta(Integer id_usuario, VentaCompra ventacompra){
        if (RepoUsu.findById(id_usuario).isPresent()){
            Usuario Usu=RepoUsu.findById(id_usuario).get();
            ventacompra.setUsuario(Usu);
            repositorio.save(ventacompra);
            return "VentaCompra Agregada correctamente";
        }else {
            return "Error al agregar compraventa, rectifica";
        }
    }


    public String actualizarVentaCompra(Integer id_venta, VentaCompra VenComActualizado) {
        Optional<VentaCompra> VentComOptional = repositorio.findById(id_venta);

        if (VentComOptional.isPresent()) {
            VentaCompra VenComExistente = VentComOptional.get();
            if (VenComActualizado.getFecha_venta() != null) {
                VenComExistente.setFecha_venta(VenComActualizado.getFecha_venta());
            }
            if (VenComActualizado.getImpuesto() != null) {
                VenComExistente.setImpuesto(VenComActualizado.getImpuesto());
            }
            if (VenComActualizado.getTotal() != null) {
                VenComExistente.setTotal(VenComActualizado.getTotal());
            }
            if (VenComActualizado.getEstado_venta() != null) {
                VenComExistente.setEstado_venta(VenComActualizado.getEstado_venta());
            }

            repositorio.save(VenComExistente);
            return "CompraVenta actualizado exitosamente.";
        } else {
            return "Error al actualizar la Compraventa rectifica";
        }
    }


    public  String EliminarCompraVenta(Integer id_venta){
        if (repositorio.findById(id_venta).isPresent()){
            repositorio.deleteById(id_venta);
            return "Se ha eliminado la Compraventa por completa";
        }else{
            return "No se registra ninguna Compraventa para eliminar";
        }
    }
}
