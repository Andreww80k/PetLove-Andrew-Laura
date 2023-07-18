package com.terminal.petlove.Controlador;
import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Entidad.RolUsuario;
import com.terminal.petlove.Servicio.ServicioProducto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControladorProducto {

    //Para instanciar la clase


    private ServicioProducto servicio;

    public ControladorProducto(ServicioProducto servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/ListarProducto")
    public ArrayList<Producto> listarPro() {
        return servicio.listarProducto();
    }


    @GetMapping("/ListarProductos")
    public List<Map<String,Object>>datosProductos(){
        List<Object[]>lista=servicio.DatosProductos();
        List<Map<String,Object>>json=new ArrayList<>();


        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();


            //Segun el orden de la consulta se ingresa
            datos.put("id_producto, ",objects[0]);
            datos.put("descripcion_producto", objects[1]);
            datos.put("nombre_producto",objects[2]);
            datos.put("precio_producto",objects[3]);
            datos.put("stock_producto",objects[4]);
            json.add(datos);
        }
        for (Map<String,Object> Pro:json){
            System.out.println(Pro);
        }
        return json;
    }

    @GetMapping("/BuscarProducto/{dato}")
    public List<Map<String,Object>>datosProductoInner(@PathVariable("dato")Integer dato){
        List<Object[]>lista=servicio.ListarProductoInner(dato);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_producto, ",objects[0]);
            datos.put("descripcion_producto", objects[1]);
            datos.put("nombre_producto",objects[2]);
            datos.put("precio_producto",objects[3]);
            datos.put("stock_producto",objects[4]);

            json.add(datos);
        }

        for (Map<String,Object>Pro:json){
            System.out.println(Pro);
        }
        return json;
    }

    @GetMapping("/BuscarStockProducto/{stock_producto}")
    public List<Map<String,Object>>datosProductoStock(@PathVariable("stock_producto")int stock_producto){
        List<Object[]>lista=servicio.ListarProductoStock(stock_producto);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_producto, ",objects[0]);
            datos.put("descripcion_producto", objects[1]);
            datos.put("nombre_producto",objects[2]);
            datos.put("precio_producto",objects[3]);
            datos.put("stock_producto",objects[4]);

            json.add(datos);
        }

        for (Map<String,Object>Pro:json){
            System.out.println(Pro);
        }
        return json;
    }

    //Buscar por nombre el producto

    @GetMapping("/BuscarNombreProducto/{nombre_producto}")
    public List<Map<String,Object>>datosProductoName(@PathVariable("nombre_producto")String nombre_producto){
        List<Object[]>lista=servicio.ListarProductoNombres(nombre_producto);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_producto, ",objects[0]);
            datos.put("descripcion_producto", objects[1]);
            datos.put("nombre_producto",objects[2]);
            datos.put("precio_producto",objects[3]);
            datos.put("stock_producto",objects[4]);

            json.add(datos);
        }

        for (Map<String,Object>Pro:json){
            System.out.println(Pro);
        }
        return json;
    }


    //Crear el metodo de conntrolador para buscar Usuario





    //Crear metodo de agregar
    @PostMapping("/agregarProducto")
    public String agregarProducto(@RequestBody Producto Productos) {
        return servicio.agregarProducto(Productos);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarProducto")
    public String actualizarProducto(@RequestBody Producto Producto){
        return servicio.actualizarProducto(Producto);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarProducto/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto")Integer id_producto){
        return servicio.EliminarProducto(id_producto);
    }

    @DeleteMapping("/eliminarProductoNombre/{nombre_producto}")
    public String eliminarProductoPorNombre(@PathVariable("nombre_producto") String nombreProducto) {
        return servicio.eliminarProductoPorNombre(nombreProducto);
    }




}
