package com.terminal.petlove.Controlador;


import com.terminal.petlove.Entidad.Usuario;
import com.terminal.petlove.Entidad.VentaCompra;
import com.terminal.petlove.Repositorio.RepositorioCompraVenta;
import com.terminal.petlove.Repositorio.RepositorioUsuario;
import com.terminal.petlove.Servicio.ServicioCompraVenta;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ControladorCompraVenta {

    private ServicioCompraVenta servicio;

    private RepositorioUsuario repoUsu;

    private RepositorioCompraVenta RepoComVen;


    public ControladorCompraVenta(ServicioCompraVenta servicio, RepositorioUsuario repoUsu, RepositorioCompraVenta repoComVen) {
        this.servicio = servicio;
        this.repoUsu = repoUsu;
        RepoComVen = repoComVen;
    }


    //Crear la ruta retorna un arraylist:


    //Listar
        @GetMapping("/ListarCompraVenta")
    public List<Map<String,Object>>datosCompraVenta(){
        List<Object[]> lista = servicio.DatosCompraVenta();
        List<Map<String, Object>> json = new ArrayList<>();

        //for para recorrer el inner

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_usuario", objects[0]);
            datos.put("id_venta", objects[1]);
            datos.put("estado_venta", objects[2]);
            datos.put("fecha_venta", objects[3]);
            datos.put("impuesto", objects[4]);
            datos.put("total", objects[5]);
            json.add(datos);
        }
        for (Map<String, Object> Usu : json) {
            System.out.println(Usu);
        }

        return json;
    }


//Buscar
    @GetMapping("/BuscarCompraVenta/{dato}")
    public List<Map<String,Object>>datosVentaCompraInner(@PathVariable("dato")Integer dato){
        List<Object[]>lista=servicio.DatosCompraVentaInner(dato);
        List<Map<String,Object>>json=new ArrayList<>();

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_usuario", objects[0]);
            datos.put("id_venta", objects[1]);
            datos.put("estado_venta", objects[2]);
            datos.put("fecha_venta", objects[3]);
            datos.put("impuesto", objects[4]);
            datos.put("total", objects[5]);
            json.add(datos);
        }
        for (Map<String, Object> Usu : json) {
            System.out.println(Usu);
        }

        return json;
    }


    //Buscar por elestado de compra


        @GetMapping("/BuscarEstadoVenta/{estado_venta}")
    public List<Map<String,Object>>datosEstadoVenta(@PathVariable("estado_venta")String estado_venta){
        List<Object[]>lista=servicio.BuscarDetalleVentaEstado(estado_venta);

        List<Map<String,Object>>json=new ArrayList<>();

        for (Object[] objects : lista) {
            Map<String, Object> datos = new LinkedHashMap<>();

            //Segun el orden la consulta se ingresa
            datos.put("id_venta", objects[0]);
            datos.put("estado_venta", objects[1]);
            datos.put("fecha_venta", objects[2]);
            datos.put("impuesto", objects[3]);
            datos.put("total", objects[4]);
            json.add(datos);
        }
        for (Map<String, Object> Venta : json) {
            System.out.println(Venta);
        }

        return json;
    }


    //Agregar:

    @PostMapping("/AgregarCompraVenta/{id_usuario}")
    public String Compraventa(@RequestBody VentaCompra ventaCompra,@PathVariable("id_usuario")Integer id_usuario){
        return servicio.AgregarCompraVenta(id_usuario,ventaCompra);
    }

    //Actualizar: por primaria
    @PutMapping("/actualizarCompraventa/{id_venta}")
    public String actualizarMascota(@PathVariable("id_venta") Integer id_venta, @RequestBody VentaCompra ComVemnActualizado) {
        return servicio.actualizarVentaCompra(id_venta, ComVemnActualizado);
    }


    //Eliminar:

    @DeleteMapping("/eliminarCompraVenta/{id_venta}")
    public String eliminarCompraVenta(@PathVariable("id_venta")Integer id_venta){
        return servicio.EliminarCompraVenta(id_venta);
    }


    }

