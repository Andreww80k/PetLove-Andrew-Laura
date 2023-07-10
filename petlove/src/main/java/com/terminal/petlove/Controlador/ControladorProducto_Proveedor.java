package com.terminal.petlove.Controlador;

import com.terminal.petlove.Servicio.ServicioProducto_Proveedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ControladorProducto_Proveedor {

    private ServicioProducto_Proveedor servicio;

    public ControladorProducto_Proveedor(ServicioProducto_Proveedor servicio)
    {
        this.servicio=servicio;
    }

    @GetMapping("/listarProductoProveedor")
    public List<Map<String,Object>> datosProductoProveedor(){
        List<Object[]>lista= servicio.datosProductosProveedor();
        List<Map<String,Object>> json=new ArrayList<>();

        //For para recorrer todos los datos traidos del Inner Join

        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta se ingresa

            datos.put("id_producto_proveedor",objects[0]);
            datos.put("nombre_proveedor",objects[1]);
            datos.put("id_proveedor", objects[2]);
            datos.put("correo_proveedor",objects[3]);
            datos.put("id_producto",objects[4]);
            datos.put("nombre_producto",objects[5]);
            datos.put("precio_producto",objects[6]);
            json.add(datos);
        }
        for (Map<String, Object> Pr: json){
            System.out.println(Pr);
        }
        return json;
    }

    //Crear el metodo de encontrar la foranea

    @GetMapping("/BuscarProductoProveedor/{dato}")
    public List<Map<String,Object>> datosProductoProveedorinner(@PathVariable("dato")Integer dato){
        List<Object[]>lista= servicio.datosProductosProveedorinner(dato);
        List<Map<String,Object>> json=new ArrayList<>();

        //For para recorrer todos los datos traidos del Inner Join

        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta se ingresa

            datos.put("id_producto_proveedor",objects[0]);
            datos.put("nombre_proveedor",objects[1]);
            datos.put("id_proveedor", objects[2]);
            datos.put("correo_proveedor",objects[3]);
            datos.put("id_producto",objects[4]);
            datos.put("nombre_producto",objects[5]);
            datos.put("precio_producto",objects[6]);

            json.add(datos);
        }

        for (Map<String, Object> Pr: json){
            System.out.println(Pr);
        }

        return json;
    }


    //Agregar pero no se pa que si es un puente jksajmksa

    @PostMapping("/AgregarProductoProveedor/{id_producto}/{id_proveedor}")
    public String agregarPP(@PathVariable("id_producto")Integer id_producto,@PathVariable("id_proveedor")Integer id_proveedor){
        return servicio.AgregarProductoProveedor(id_producto,id_proveedor);
    }


}
