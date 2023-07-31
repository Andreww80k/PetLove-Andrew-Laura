package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Servicio;
import com.terminal.petlove.Servicio.ServicioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ControladorServicio {

    private ServicioServicio servicio;

    public ControladorServicio(ServicioServicio servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/ListarServicio")
    public ArrayList<Servicio> listarServicio() {
        return servicio.listarServicio();
    }

    @GetMapping("/ListarServicios")
    public List<Map<String,Object>>datosServicio(){
        List<Object[]>lista=servicio.DatosServicio();
        List<Map<String,Object>>json=new ArrayList<>();

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_servicio", objects[0]);
            datos.put("tipo_servicio", objects[1]);

            json.add(datos);
        }

        for (Map<String, Object> Ser : json) {
            System.out.println(Ser);
        }
        return json;
    }


    //Crear el metodo de controlador para buscar Servicio

    @GetMapping("/buscarServicio/{id}")
    public Servicio buscarServicio(@PathVariable("id") Integer id) {
        return servicio.buscarServicio(id);
    }

    @GetMapping("/BuscarTipoServicio/{tipo_servicio}")
    public List<Map<String, Object>> datosServicioTipo(@PathVariable("tipo_servicio") String tipo_servicio) {
        List<Object[]> lista = servicio.BuscarServicioTipo(tipo_servicio);
        List<Map<String, Object>> json = new ArrayList<>();

        //For
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_servicio", objects[0]);
            datos.put("tipo_servicio", objects[1]);

            json.add(datos);
        }

        for (Map<String, Object> Ser : json) {
            System.out.println(Ser);
        }

        return json;
    }


    @GetMapping("/BuscarServicios/{dato}")
    public List<Map<String, Object>> buscarServicios(@PathVariable("dato") Integer dato) {
        List<Object[]> lista = servicio.ListarServicioInner(dato);
        List<Map<String, Object>> json = new ArrayList<>();

        //For
        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_servicio", objects[0]);
            datos.put("tipo_servicio", objects[1]);

            json.add(datos);
        }

        for (Map<String, Object> Ser : json) {
            System.out.println(Ser);
        }

        return json;
    }


    //Crear metodo de agregar
    @PostMapping("/agregarServicio")
    public String agregarServicio(@RequestBody Servicio Servicios) {
        return servicio.agregarServicio(Servicios);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarServicio")
    public String actualizarServicio(@RequestBody Servicio Servicio){
        return servicio.actualizarServicio(Servicio);
    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarServicio/{id}")
    public String eliminarServicio(@PathVariable("id")Integer id){
        return  servicio.eliminarServicio(id);
    }

    @DeleteMapping("/eliminarServicioTipo/{tipo_servicio}")
    public String eliminarServicioPorTipo(@PathVariable("tipo_servicio") String tipoServicio) {
        return servicio.eliminarServicioPorTipo(tipoServicio);
    }

}
