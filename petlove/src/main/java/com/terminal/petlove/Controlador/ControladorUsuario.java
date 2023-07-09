package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Repositorio.RepositorioRolUsuario;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import com.terminal.petlove.Servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ControladorUsuario {

    private ServicioUsuario servicio;
    private RepositorioRolUsuario repoRol;
    private RepositorioUsuario repoUsu;

    public ControladorUsuario(ServicioUsuario servicio, RepositorioRolUsuario repoRol, RepositorioUsuario repoUsu) {
        this.servicio = servicio;
        this.repoRol = repoRol;
        this.repoUsu = repoUsu;
    }

    //Crear la ruta que retorna un ArrayList

    @GetMapping("/ListarUsuario")
    public List<Map<String, Object>> datosUsuario() {
        List<Object[]> lista = servicio.DatosUsuario();
        List<Map<String, Object>> json = new ArrayList<>();
        //For para recorrer ttodos los datos traidos del Inner Join
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_rol_usuario", objects[0]);
            datos.put("id_usuario", objects[1]);
            datos.put("apellido_usuario", objects[2]);
            datos.put("contrasena_usuario", objects[3]);
            datos.put("correo_usuario", objects[4]);
            datos.put("direccion_usuario", objects[5]);
            datos.put("nombre_usuario", objects[6]);
            datos.put("telefono_usuario", objects[7]);

            json.add(datos);
        }

        for (Map<String, Object> Usu : json) {
            System.out.println(Usu);
        }

        return json;

    }

    //Crear un metodo para buscar las foraneas:
    @GetMapping("/BuscarUsuario/{dato}")
    public List<Map<String, Object>> datosUsuarioInner(@PathVariable("dato") Integer dato) {
        List<Object[]> lista = servicio.buscarUusarioInner(dato);
        List<Map<String, Object>> json = new ArrayList<>();

        //For para recorrer datos del inner

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden de la consulta:
            datos.put("id_rol_usuario", objects[0]);
            datos.put("id_usuario", objects[1]);
            datos.put("apellido_usuario", objects[2]);
            datos.put("contrasena_usuario", objects[3]);
            datos.put("correo_usuario", objects[4]);
            datos.put("direccion_usuario", objects[5]);
            datos.put("nombre_usuario", objects[6]);
            datos.put("telefono_usuario", objects[7]);

            json.add(datos);
        }
        for (Map<String, Object> Usu : json) {
            System.out.println(Usu);
        }
        return json;
    }


    //Para agregar Foranea
    @PostMapping("/AgregarUsuario/{id_rol_usuario}")
    public String AgregarUsuario(@RequestBody Usuario usuario, @PathVariable("id_rol_usuario") Integer id_rol_usuario) {
        return servicio.AgregarUsuario(id_rol_usuario, usuario);
    }

    //Actualizar:
    @PutMapping("/actualizarUsuario/{id_usuario}")
    public String actualizarMascota(@PathVariable("id_usuario") Integer id_usuario, @RequestBody Usuario usuarioActualizado) {
        return servicio.AgregarUsuario(id_usuario, usuarioActualizado);
    }

    //Eliminar
    @DeleteMapping("/eliminarUsuario/{id_usuario}")
    public String eliminarUsuario(@PathVariable("id_usuario")Integer id_usuario){
        return servicio.EliminarUsuario(id_usuario);
    }
}