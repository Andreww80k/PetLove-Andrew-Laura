package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Entidad.Servicio;
import com.terminal.petlove.Repositorio.RepositorioServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio {

    private RepositorioServicio repositorio;

    public ServicioServicio(RepositorioServicio repositorio) {
        this.repositorio = repositorio;
    }


    public ArrayList<Servicio> listarServicio(){
        return (ArrayList<Servicio>) repositorio.findAll();
    }


    //Metodo de buscar Servicio por Jpa


    public Servicio buscarServicio(Integer id){
        if (repositorio.findById(id).isPresent());
        if (repositorio.findById(id).isPresent())
            return repositorio.findById(id).get();

        else return null;
    }

    public List<Object[]> BuscarServicioTipo(String tipo_servicio) {
        return repositorio.buscarPorTipo(tipo_servicio);
    }
    //Metodo para agregar:



    public String agregarServicio(Servicio Servicio) {
        //Pregutan si existe:
        if (repositorio.findById(Servicio.getId_servicio()).isPresent())
            return "El Servicio ya esta registrado en nuestra veterinaria, rectifica porfavor";


        else{
            repositorio.save(Servicio);
            return "El Servicio se registro satisfactoriamente";
        }
    }


    //Metodo de actualizar:

    public String actualizarServicio(Servicio Servicio) {


        if (repositorio.findById(Servicio.getId_servicio()).isPresent()){
            repositorio.save(Servicio);
            return "El Servicio se actualizo de forma exitosa";
        }
        else{
            return "El Servicio no se encuentra registrado actualemente";
        }
    }



    //Para eliminar

    public String eliminarServicio(Integer id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return "El Servicio ha sido Eliminado";
        }
        else {
            return "Ahora el Servicio no se encuentra registrado";
        }
    }

    public String eliminarServicioPorTipo(String tipo_servicio) {
        List<Servicio> servicios = repositorio.buscarPorTipoServicio(tipo_servicio);

        if (servicios.isEmpty()) {
            repositorio.eliminarPorTipoServicio(tipo_servicio);
            return "Se ha eliminado el servicio por su tipo";
        } else {
            return "No se ha encontrado el servicio con ese tipo";
        }
    }
}
