package com.Ucema.demo.Dto;

import com.Ucema.demo.Model.Libro;
import com.Ucema.demo.Model.Usuario;

import java.time.LocalDate;
import java.util.List;
public class NewCompraDTO
{

    private LocalDate fechaCompra;
    private Usuario usuario;
    private List<Libro> libros;

    public NewCompraDTO(LocalDate fechaCompra, Usuario usuario, List<Libro> libros) {
        this.fechaCompra = fechaCompra;
        this.usuario = usuario;
        this.libros = libros;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
