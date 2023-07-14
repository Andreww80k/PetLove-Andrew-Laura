package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Servicio.ServicioRolUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ControladorRolUsuario {

    private ServicioRolUsuario servicio;

    public ControladorRolUsuario(ServicioRolUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarRolUsuario")
    public ArrayList<RolUsuario> listarRolUsuario() {
        return servicio.listarRol_Usuario();
    }


    //Listar usuario por consulta

    @GetMapping("/ListarRolesUsuarios")
    public List<Map<String,Object>>datosRol(){
        List<Object[]>lista=servicio.DatosRol();
        List<Map<String,Object>>json=new ArrayList<>();

        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();


            //Segun el orden de la consulta se ingresa
            datos.put("id_rol_usuario, ",objects[0]);
            datos.put("nombre_rol_usuario", objects[1]);
            json.add(datos);
        }
        for (Map<String,Object> Rol:json){
            System.out.println(Rol);
        }
        return json;
    }


    @GetMapping("/BuscarNombreRol/{nombre_rol_usuario}")
    public List<Map<String,Object>>datosRolName(@PathVariable("nombre_rol_usuario")String nombre_rol_usuario){
        List<Object[]>lista=servicio.DatosRolNombre(nombre_rol_usuario);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_rol_usuario, ",objects[0]);
            datos.put("nombre_rol_usuario", objects[1]);
            json.add(datos);

        }

        for (Map<String,Object>Rol:json){
            System.out.println(Rol);
        }
        return json;
    }




    //Crear el metodo de conntrolador para buscar Rol

    @GetMapping("/buscarRolUsuario/{id}")
    public RolUsuario buscarRolUsuario(@PathVariable("id") Integer id) {
        return servicio.buscarRol_Usuario(id);

    }


    //Crear metodo de agregar
    @PostMapping("/agregarRolUsuario")
    public String agregarRolUsuario(@RequestBody RolUsuario RolUsuario) {
        return servicio.agregarRol_Usuario(RolUsuario);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarRolUsuario")
    public String actualizarRolUsuario(@RequestBody RolUsuario RolUsuario){
        return servicio.actualizarRol_Usuario(RolUsuario);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarRolUsuario/{id}")
    public String eliminarRolUsuario(@PathVariable("id")Integer id){
        return  servicio.eliminarRol_Usuario(id);
    }

}
