package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.Proveedor;
import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Repositorio.RepositorioMascota;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMascota {


        private RepositorioMascota repositorio;
        private RepositorioUsuario repoUsu;

        public ServicioMascota(RepositorioMascota repositorio, RepositorioUsuario repoUsu) {
            this.repositorio = repositorio;
            this.repoUsu = repoUsu;
        }

        // Resto del código del servicio...


    //Metodo de buscar Mascota por Jpa

    public List<Object[]>DatosMascota(){
        return repositorio.ListarDatosMascotas();
    }


    public List<Object[]>buscarMascotaInner(Integer dato){
        return repositorio.ListarDatosMascotasInner(dato);
    }

//Para buscar por nombre:

    public List<Object[]>buscarMascotaNombre(String nombre_mascota){
            return repositorio.ListarMascotasNombre(nombre_mascota);
    }

    public List<Object[]>buscarMascotaTipo(String tipo_mascota){
        return repositorio.ListarMascotasTipo(tipo_mascota);
    }

    public List<Object[]>buscarMascotaRaza(String raza_mascota){
        return repositorio.ListarMascotasRaza(raza_mascota);
    }


    //Metodo para agregar Foraneas

    //llamamos al dato de la foranea:

    public String agregarMascota(Integer id_usuario, Mascota mascota) {
        if (repoUsu.findById(id_usuario).isPresent()){
            Usuario usu = repoUsu.findById(id_usuario).get();
            mascota.setUsuario(usu);
            repositorio.save(mascota);
            return "Mascota agregada correctamente";
        } else {
            return "Error al agregar la mascota";
        }
    }




    //METODO ACTUALIZAR:
    public String actualizarMascota(Integer id_mascota, Mascota mascotaActualizada) {
        Optional<Mascota> mascotaOptional = repositorio.findById(id_mascota);

        if (mascotaOptional.isPresent()) {
            Mascota mascotaExistente = mascotaOptional.get();
            if (mascotaActualizada.getNombre_mascota() != null) {
                mascotaExistente.setNombre_mascota(mascotaActualizada.getNombre_mascota());
            }
            if (mascotaActualizada.getRaza_mascota() != null) {
                mascotaExistente.setRaza_mascota(mascotaActualizada.getRaza_mascota());
            }
            if (mascotaActualizada.getTipo_mascota() != null) {
                mascotaExistente.setTipo_mascota(mascotaActualizada.getTipo_mascota());
            }
            if (mascotaActualizada.getEdad_mascota() != null) {
                mascotaExistente.setEdad_mascota(mascotaActualizada.getEdad_mascota());
            }
            if (mascotaActualizada.getPeso_mascota() != null) {
                mascotaExistente.setPeso_mascota(mascotaActualizada.getPeso_mascota());
            }
            if (mascotaActualizada.getUsuario() != null) {
                mascotaExistente.setUsuario(mascotaActualizada.getUsuario());
            }

            repositorio.save(mascotaExistente);
            return "Mascota actualizada exitosamente.";
        } else {
            return "ERROR: Mascota no encontrada.";
        }
    }

    public String EliminarMascota(Integer id_Mascota){
        if (repositorio.findById(id_Mascota).isPresent()){
            repositorio.deleteById(id_Mascota);
            return "Se ha eliminado la Mascota por completo";
        } else {
            return "No se registra ninguna Mascota para eliminar";
        }
    }

    public String eliminarMascotaPorNombre(String nombre_mascota) {
        List<Mascota> mascotas = repositorio.buscarPorNombreMascota(nombre_mascota);

        if (!mascotas.isEmpty()) {
            repositorio.eliminarPorNombreMascota(nombre_mascota);
            return "Se ha eliminado la mascota por su nombre";
        } else {
            return "No se ha encontrado la mascota con ese nombre";
        }
    }

    public String eliminarMascotaPorTipo(String tipo_mascota) {
        List<Mascota> mascotas = repositorio.buscarPorTipoMascota(tipo_mascota);

        if (!mascotas.isEmpty()) {
            repositorio.eliminarPorTipoMascota(tipo_mascota);
            return "Se ha eliminado la mascota por su tipo";
        } else {
            return "No se ha encontrado la mascota con ese tipo";
        }
    }

}
