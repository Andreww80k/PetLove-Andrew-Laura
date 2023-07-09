package com.terminal.petlove.Servicio;

import com.terminal.petlove.Entidad.Producto;
import com.terminal.petlove.Entidad.Proveedor;
import com.terminal.petlove.Entidad.Producto_Proveedor;
import com.terminal.petlove.Repositorio.RepositorioProducto;
import com.terminal.petlove.Repositorio.RepositorioProducto_Proveedor;
import com.terminal.petlove.Repositorio.RepositorioProveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProducto_Proveedor {

    private RepositorioProducto_Proveedor repositorioProducto_proveedor;

    //Repositorios de las tablas Inner Join

    private RepositorioProveedor RepoProo;
    private RepositorioProducto RepoPR;

    public ServicioProducto_Proveedor(RepositorioProducto_Proveedor repositorioProducto_proveedor, RepositorioProveedor repoProo, RepositorioProducto repoPR) {
        this.repositorioProducto_proveedor = repositorioProducto_proveedor;
        RepoProo = repoProo;
        RepoPR = repoPR;
    }

    //Metodos

    public List<Object[]> datosProductosProveedor(){
        return repositorioProducto_proveedor.ListarDatosProductosProveedor();

    }

    //Para buscar por inner join
    public List<Object[]>datosProductosProveedorinner(Integer dato){
        return repositorioProducto_proveedor.ListarDatosProductosProveedorinner(dato);

    }


    //Metodo para agregar Foraneas:


    public  String AgregarProductoProveedor (Integer id_producto, Integer id_proveedor){

        Producto_Proveedor PP=new Producto_Proveedor();

        if (RepoProo.findById(id_proveedor).isPresent()&& RepoPR.findById(id_producto).isPresent()){
            Producto Productos=RepoPR.findById(id_producto).get();
            Proveedor Provedores=RepoProo.findById(id_proveedor).get();

            PP.setProveedor(Provedores);
            PP.setProducto(Productos);

            repositorioProducto_proveedor.save(PP);

            return "Datos guardados de forma satisfactoria";
        }else
            return "No se han guardado los datos, rectifica";

    }

}