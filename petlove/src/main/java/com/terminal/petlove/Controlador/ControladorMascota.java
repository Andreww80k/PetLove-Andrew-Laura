package com.terminal.petlove.Controlador;

import com.terminal.petlove.Entidad.Mascota;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Repositorio.RepositorioMascota;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import com.terminal.petlove.Servicio.ServicioMascota;
import com.terminal.petlove.Servicio.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ControladorMascota {

    private ServicioMascota servicio;
    private RepositorioMascota repoMas;
    private RepositorioUsuario RepoUsu;

    public ControladorMascota(ServicioMascota servicio, RepositorioMascota repoMas, RepositorioUsuario repoUsu) {
        this.servicio = servicio;
        this.repoMas = repoMas;
        RepoUsu = repoUsu;
    }

    //Crear ruta que retorne a un arraylist

    @GetMapping("/ListarMascota")
    public List<Map<String,Object>>datosMascota(){
        List<Object[]>lista=servicio.DatosMascota();
        List<Map<String,Object>>json=new ArrayList<>();

        //For para recorrer todos los datos traidos del inner join


        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();


            //Segun el orden de la consulta se ingresa


            datos.put("id_usuario",objects[0]);
            datos.put("id_mascota", objects[1]);
            datos.put("edad_mascota",objects[2]);
            datos.put("nombre_mascota",objects[3]);
            datos.put("peso_mascota",objects[4]);
            datos.put("raza_mascota",objects[5]);
            datos.put("tipo_mascota",objects[6]);


            json.add(datos);
        }

        for (Map<String,Object> Mas:json){
            System.out.println(Mas);
        }

        return json;
    }


    //Crear metodo para buscar


    @GetMapping("BuscarMascota/{dato}")
    public List<Map<String,Object>>datosMascotaInner(@PathVariable("dato")Integer dato){
        List<Object[]>lista=servicio.buscarMascotaInner(dato);
        List<Map<String,Object>>json=new ArrayList<>();


        //For para recorrer los datos de los inner

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:


            datos.put("id_usuario",objects[0]);
            datos.put("id_mascota", objects[1]);
            datos.put("edad_mascota",objects[2]);
            datos.put("nombre_mascota",objects[3]);
            datos.put("peso_mascota",objects[4]);
            datos.put("raza_mascota",objects[5]);
            datos.put("tipo_mascota",objects[6]);

            json.add(datos);
        }

        for (Map<String,Object>Mas:json){
            System.out.println(Mas);
        }
        return json;
    }

    //Para agregar foranea:

    @PostMapping("/AgregarMascota/{id_usuario}")
    public String AgregarMascota(@PathVariable("id_usuario")Integer id_usuario, @RequestBody Mascota mascotas){
        return servicio.agregarMascota(id_usuario, mascotas);
    }

    //CONTROLADOR ACTUALIZAR:
    @PutMapping("/actualizarMascota/{id_mascota}")
    public String actualizarMascota(@PathVariable("id_mascota") Integer id_mascota, @RequestBody Mascota mascotaActualizada) {
        return servicio.actualizarMascota(id_mascota, mascotaActualizada);
    }


    //Eliminar
    @DeleteMapping("/eliminarMascota/{id_mascota}")
    public String eliminarUsuario(@PathVariable("id_mascota")Integer id_mascota){
        return servicio.EliminarMascota(id_mascota);
    }


}


