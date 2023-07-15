package com.terminal.petlove.Controlador;

import com.terminal.petlove.Entidad.Proveedor;
import com.terminal.petlove.Servicio.ServicioProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class ControladorProveedor {
    private ServicioProveedor servicio;

    public ControladorProveedor(ServicioProveedor servicio) {
        this.servicio = servicio;
    }


    //Crear la ruta y retorna a un arraylist

    @GetMapping("/ListarProveedor")
    public ArrayList<Proveedor> listarProveedor() {
        return servicio.listarProveedor();
    }

    @GetMapping("/ListarProveedores")
    public List<Map<String,Object>>datosProveedores(){
        List<Object[]>lista=servicio.DatosProveedores();
        List<Map<String,Object>>json=new ArrayList<>();


        for (Object[] objects: lista){
            Map<String,Object>datos=new LinkedHashMap<>();


            //Segun el orden de la consulta se ingresa


            datos.put("id_proveedor, ",objects[0]);
            datos.put("apellido_proveedor", objects[1]);
            datos.put("contraseña_proveedor",objects[2]);
            datos.put("correo_proveedor",objects[3]);
            datos.put("direccion_proveedor",objects[4]);
            datos.put("nombre_proveedor",objects[5]);
            datos.put("telefono_proveedor",objects[6]);

            json.add(datos);
        }

        for (Map<String,Object> Prov:json){
            System.out.println(Prov);
        }
        return json;
    }

    //Crear el metodo de conntrolador para buscar Usuario

    @GetMapping("/BuscarNombreProveedor/{nombre_proveedor}")
    public List<Map<String,Object>>datosProveedorName(@PathVariable("nombre_proveedor")String nombre_proveedor){
        List<Object[]>lista=servicio.ListarProveedorNombre(nombre_proveedor);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_proveedor, ",objects[0]);
            datos.put("apellido_proveedor", objects[1]);
            datos.put("contraseña_proveedor",objects[2]);
            datos.put("correo_proveedor",objects[3]);
            datos.put("direccion_proveedor",objects[4]);
            datos.put("nombre_proveedor",objects[5]);
            datos.put("telefono_proveedor",objects[6]);

            json.add(datos);
        }

        for (Map<String,Object>Prov:json){
            System.out.println(Prov);
        }
        return json;
    }


    @GetMapping("/BuscarCorreoProveedor/{correo_proveedor}")
    public List<Map<String,Object>>datosProveedorCorreo(@PathVariable("correo_proveedor")String correo_proveedor){
        List<Object[]>lista=servicio.buscarProveedorCorreo(correo_proveedor);
        List<Map<String,Object>> json=new ArrayList<>();

        for (Object[]objects:lista){
            Map<String,Object>datos=new LinkedHashMap<>();

            //Segun el orden de la consulta nuevamente:

            datos.put("id_proveedor, ",objects[0]);
            datos.put("apellido_proveedor", objects[1]);
            datos.put("contraseña_proveedor",objects[2]);
            datos.put("correo_proveedor",objects[3]);
            datos.put("direccion_proveedor",objects[4]);
            datos.put("nombre_proveedor",objects[5]);
            datos.put("telefono_proveedor",objects[6]);

            json.add(datos);
        }

        for (Map<String,Object>Prov:json){
            System.out.println(Prov);
        }
        return json;
    }



    //Crear metodo de agregar
    @PostMapping("/agregarProveedor")
    public String agregarProveedor(@RequestBody Proveedor Proveedors) {
        return servicio.agregarProveedor(Proveedors);
    }


    //Metodo para Actualizar con Put

    @PutMapping("/actualizarProveedor")
    public String actualizarProveedor(@RequestBody Proveedor Proveedors){
        return servicio.actualizarProveedor(Proveedors);

    }

    //Metodo para Eliminar
    @DeleteMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id")Integer id){
        return  servicio.eliminarProveedor(id);
    }

    @DeleteMapping("/eliminarProveedorCorreo/{correo_proveedor}")
    public String eliminarProveedorPorCorreo(@PathVariable("correo_proveedor") String correoProveedor) {
        return servicio.eliminarProveedorPorCorreo(correoProveedor);
    }
}
