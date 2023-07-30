package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Repositorio.RepositorioRolUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioRolUsuario {

    private RepositorioRolUsuario repoRUsu;



    public ServicioRolUsuario(RepositorioRolUsuario repoRUsu) {
        this.repoRUsu = repoRUsu;
    }


    public List<Object[]>ListarRolInner(Integer id_rol_usuario){
        return repoRUsu.ListarRolInner(id_rol_usuario);
    }

    public ArrayList<RolUsuario> listarRol_Usuario(){
        return (ArrayList<RolUsuario>) repoRUsu.findAll();
    }

    //s
    public List<Object[]>DatosRol(){
        return repoRUsu.ListarDatosRol();
    }

    //Servicio de buscar por nombre de rol

    public List<Object[]>DatosRolNombre(String nombre_rol_usuario){
        return repoRUsu.ListarDatosRolNombre(nombre_rol_usuario);
    }






    //Metodo de buscar Rol_Usuario por Jpa


    public RolUsuario buscarRol_Usuario(Integer id){
        if (repoRUsu.findById(id).isPresent());
        if (repoRUsu.findById(id).isPresent())
            return repoRUsu.findById(id).get();

        else return null;
    }

    //Metodo para agregar:


    public String agregarRol_Usuario(RolUsuario RolUsuario) {
        // Buscar el rol por tipo_rol_usuario en la base de datos
        List<RolUsuario> rolExistente = repoRUsu.buscarPorNombreRolUsuario(RolUsuario.getNombre_rol_usuario());

        if (rolExistente.isEmpty()) {
            // El producto no existe en la base de datos, entonces lo guardamos
            repoRUsu.save(RolUsuario);
            return "El Rol_Usuario se registró satisfactoriamente";
        } else {
            // El producto ya existe en la base de datos
            return "El Rol_Usuario ya esta registrado en nuestra veterinaria, rectifica porfavor";
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

    public String eliminarRolUsuarioPorNombre(String nombre_rol_usuario) {
        List<RolUsuario> rolUsuarios = repoRUsu.buscarPorNombreRolUsuario(nombre_rol_usuario);

        if (!rolUsuarios.isEmpty()) {
            repoRUsu.eliminarPorNombreRolUsuario(nombre_rol_usuario);
            return "Se ha eliminado el rol por su nombre";
        } else {
            return "No se ha encontrado el rol con ese nombre";
        }
    }
}
