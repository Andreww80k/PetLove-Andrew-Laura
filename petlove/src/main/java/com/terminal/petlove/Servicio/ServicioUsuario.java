package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Repositorio.RepositorioRolUsuario;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ServicioUsuario {


    //ARREGLAR METODOS---------------------------------------------------------------------------------------------------------
    private RepositorioUsuario repositorio;

    //Repositorio de la tabla inner join

    private RepositorioRolUsuario repositoriRol;

    public ServicioUsuario(RepositorioUsuario repositorio, RepositorioRolUsuario repositoriRol) {
        this.repositorio = repositorio;
        this.repositoriRol = repositoriRol;
    }

    //Metodos

    public List<Object[]>DatosUsuario(){
        return  repositorio.ListarDatosUsuarios();
    }

    public List<Object[]> buscarUusarioInner(Integer dato){
        return repositorio.ListarDatosUsuarioInner(dato);
    }

    public List<Object[]> buscarUusarioEmail(String email){
        return repositorio.ListarDatosUsuarioEmail(email);
    }

    public List<Object[]> buscarUsuarioNombre(String nombre_usuario){
        return repositorio.ListarDatosUsuarioNombre(nombre_usuario);
    }
    //Metodo para agregar Foraneas




 //Llamamos al dato de la foranea

    public String AgregarUsuario(Integer id_rol_usuario, Usuario usuarios){
        if (repositoriRol.findById(id_rol_usuario).isPresent()){
            RolUsuario usu = repositoriRol.findById(id_rol_usuario).get();
            usuarios.setRol_usuario(usu);
            repositorio.save(usuarios);
            return "usuario agregada correctamente";
        } else {
            return "Error al agregar la usuario";
        }
    }

    public String actualizarUsuario(Integer id_usuario, Usuario UsuarioActualizado) {
        Optional<Usuario> usuarioOptional = repositorio.findById(id_usuario);

        if (usuarioOptional.isPresent()) {
            Usuario UsuarioExistente = usuarioOptional.get();
            if (UsuarioActualizado.getNombre_usuario() != null) {
                UsuarioExistente.setNombre_usuario(UsuarioActualizado.getNombre_usuario());
            }
            if (UsuarioActualizado.getApellido_usuario() != null) {
                UsuarioExistente.setApellido_usuario(UsuarioActualizado.getApellido_usuario());
            }
            if (UsuarioActualizado.getTelefono_usuario() != null) {
                UsuarioExistente.setTelefono_usuario(UsuarioActualizado.getTelefono_usuario());
            }
            if (UsuarioActualizado.getDireccion_usuario() != null) {
                UsuarioExistente.setDireccion_usuario(UsuarioActualizado.getDireccion_usuario());
            }
            if (UsuarioActualizado.getCorreo_usuario() != null) {
                UsuarioExistente.setCorreo_usuario(UsuarioActualizado.getCorreo_usuario());
            }
            if (UsuarioActualizado.getContrasena_usuario() != null) {
                UsuarioExistente.setContrasena_usuario(UsuarioActualizado.getContrasena_usuario());
            }


            repositorio.save(UsuarioExistente);
            return "Usuario actualizado exitosamente.";
        } else {
            return "Error al actualizar Usuario rectifica";
        }
    }


    public String EliminarUsuario(Integer id_usuario){
       if (repositorio.findById(id_usuario).isPresent()){
           repositorio.deleteById(id_usuario);
           return "Se ha eliminado el usuario por completo";
       } else {
           return "No se registra ningun usuario para eliminar";
       }
    }//

    //En Progreso de eliminar por correo


    // Eliminar Usuario por Correo:
    public String eliminarUsuarioPorCorreo(String correoUsuario) {
        repositorio.eliminarPorCorreoUsuario(correoUsuario);
        return "Se ha eliminado el usuario por su correo";
    }


}





