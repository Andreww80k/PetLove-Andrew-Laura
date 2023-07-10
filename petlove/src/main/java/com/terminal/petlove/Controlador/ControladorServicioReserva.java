package com.terminal.petlove.Controlador;


import com.terminal.petlove.Servicio.ServicioReserva;
import com.terminal.petlove.Servicio.ServicioServicioReserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControladorServicioReserva {

    private ServicioServicioReserva servicio;

    public ControladorServicioReserva(ServicioServicioReserva servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarServicioReserva")
    public List<Map<String,Object>>datosServicioReserva(){
        List<Object[]>lista=servicio.datosServicioReserva();
        List<Map<String,Object>>json=new ArrayList<>();

        //recorrer con for innerjoin

        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta se ingresa

            datos.put("id_servicio_reserva",objects[0]);
            datos.put("tipo_servicio",objects[1]);
            datos.put("id_reserva", objects[2]);
            datos.put("estado_reserva",objects[3]);
            datos.put("fecha_entrega",objects[4]);
            datos.put("fecha_reserva",objects[5]);
            datos.put("tipo_reserva",objects[6]);
            json.add(datos);
        }
        for (Map<String, Object> ser: json){
            System.out.println(ser);
        }
        return json;
    }


    //Crear el metodo de buscar

    @GetMapping("/BuscarServicioReserva/{dato}")
    public List<Map<String,Object>>datosServicioReservainner(@PathVariable("dato")Integer dato){
        List<Object[]>lista=servicio.datosServicioReservainner(dato);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta se ingresa

            datos.put("id_servicio_reserva",objects[0]);
            datos.put("tipo_servicio",objects[1]);
            datos.put("id_reserva", objects[2]);
            datos.put("estado_reserva",objects[3]);
            datos.put("fecha_entrega",objects[4]);
            datos.put("fecha_reserva",objects[5]);
            datos.put("tipo_reserva",objects[6]);
            json.add(datos);
        }
        for (Map<String, Object> ser: json){
            System.out.println(ser);
        }
        return json;

    }


}

