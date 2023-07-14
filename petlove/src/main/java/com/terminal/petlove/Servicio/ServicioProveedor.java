package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.Proveedor;
import com.terminal.petlove.Repositorio.RepositorioProveedor;

import java.util.ArrayList;
import java.util.List;

public class ServicioProveedor {

    private RepositorioProveedor repositorio;

    public ServicioProveedor(RepositorioProveedor repositorio){
        this.repositorio = repositorio;
    }

    public ArrayList<Proveedor> listarProveedor(){
        return (ArrayList<Proveedor>) repositorio.findAll();
    }


    public List<Object[]>DatosProveedores(){
        return repositorio.ListarDatosProveedor();
    }

    //Servicio para buscar por nombre de proveedor:

    public List<Object[]>ListarProveedorNombre(String nombre_proveedor){
        return repositorio.ListaProveedorNombre(nombre_proveedor);
    }

    public List<Object[]> buscarProveedorCorreo(String correo_proveedor) {
        return repositorio.ListaProveedorCorreo(correo_proveedor);

    }
    public Proveedor buscarProveedor(Integer id) {
        if(repositorio.findById(id).isPresent())
            return repositorio.findById(id).get();
        else return null;
    }

    public String agregarProveedor(Proveedor Proveedors){
        if(repositorio.findById(Proveedors.getId_proveedor()).isPresent())
            return "El Proveedor ya se encuentra registardo";
        else repositorio.save(Proveedors);
        return "El Proveedor se registro exitosamente";
    }

    public String actualizarProveedor(Proveedor Proveedors){
        if(repositorio.findById(Proveedors.getId_proveedor()).isPresent()) {
            repositorio.save(Proveedors);
            return "El Proveedor se actualizo exitosamente";
        }
        else {return "El Proveedor no se puede actualizar porque no existe";}
    }

    public String eliminarProveedor(Integer id){
        if(repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return "Proveedor eliminado exitosamente";
        }
        else return "Proveedor no registrado";
    }
}
