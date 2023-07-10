package com.terminal.petlove.Servicio;


import com.terminal.petlove.Repositorio.RepositorioCompraVenta;
import com.terminal.petlove.Repositorio.RepositorioDetalleVenta;
import com.terminal.petlove.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioDetalleVenta {

    private RepositorioDetalleVenta repositorio;


    //Repositorio del inners:

    private RepositorioProducto RepoPro;
    private RepositorioCompraVenta RepoComVen;

    public ServicioDetalleVenta(RepositorioDetalleVenta repositorio, RepositorioProducto repoPro, RepositorioCompraVenta repoComVen) {
        this.repositorio = repositorio;
        RepoPro = repoPro;
        RepoComVen = repoComVen;
    }

    //Metodos:
}
