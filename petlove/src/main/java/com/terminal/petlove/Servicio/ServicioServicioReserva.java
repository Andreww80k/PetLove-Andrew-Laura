package com.terminal.petlove.Servicio;


import com.terminal.petlove.Entidad.Reserva;
import com.terminal.petlove.Entidad.Servicio;
import com.terminal.petlove.Repositorio.RepositorioReserva;
import com.terminal.petlove.Repositorio.RepositorioServicio;
import com.terminal.petlove.Repositorio.RepositorioServicioReserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioServicioReserva {

    private RepositorioServicioReserva repositorio;

    //Repositorios de las tablas inner:

    private RepositorioReserva RepoRes;

    private RepositorioServicio RepoSer;


    public ServicioServicioReserva(RepositorioServicioReserva repositorio, RepositorioReserva repoRes, RepositorioServicio repoSer) {
        this.repositorio = repositorio;
        RepoRes = repoRes;
        RepoSer = repoSer;
    }

    //Metodos

    public List<Object[]>datosServicioReserva(){
        return repositorio.ListarDatosDetalleVenta();
    }


    //Bsucar por inner join:

    public List<Object[]>datosServicioReservainner(Integer dato){
        return repositorio.ListarDatosDetalleVentaInner(dato);

    }



}
