package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Repositorio.RepositorioRolUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ServicioRolUsuario {

    private RepositorioRolUsuario repoRUsu;



    public ServicioRolUsuario(RepositorioRolUsuario repoRUsu) {
        this.repoRUsu = repoRUsu;
    }


    public ArrayList<RolUsuario> listarRol_Usuario(){
        return (ArrayList<RolUsuario>) repoRUsu.findAll();
    }


    //Metodo de buscar Rol_Usuario por Jpa


    public RolUsuario buscarRol_Usuario(Integer id){
        if (repoRUsu.findById(id).isPresent());
        if (repoRUsu.findById(id).isPresent())
            return repoRUsu.findById(id).get();

        else return null;
    }

    //Metodo para agregar:



    public String agregarRol_Usuario(RolUsuario Rol_Usuario) {
        //Pregutan si existe:
        if (repoRUsu.findById(Rol_Usuario.getId_rol_usuario()).isPresent())
            return "El Rol_Usuario ya esta registrado en nuestra veterinaria, rectifica porfavor";


        else{
            repoRUsu.save(Rol_Usuario);
            return "El Rol_Usuario se registro satisfactoriamente";
        }
    }


    //Metodo de actualizar:

    public String actualizarRol_Usuario(RolUsuario Rol_Usuario) {


        if (repoRUsu.findById(Rol_Usuario.getId_rol_usuario()).isPresent()){
            repoRUsu.save(Rol_Usuario);
            return "El Rol_Usuario se actualizo de forma exitosa";
        }
        else{
            return "El Rol_Usuario no se encuentra registrado actualemente";
        }
    }



    //Para eliminar

    public String eliminarRol_Usuario(Integer id){
        if (repoRUsu.findById(id).isPresent()){
            repoRUsu.deleteById(id);
            return "El Rol_Usuario ha sido Eliminado";
        }
        else {
            return "Ahora el Rol_Usuario no se encuentra registrado";
        }
    }
}
