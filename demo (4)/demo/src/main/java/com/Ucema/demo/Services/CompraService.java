package com.Ucema.demo.Services;

import com.Ucema.demo.Model.Libro;
import com.Ucema.demo.Model.Compra;
import com.Ucema.demo.Model.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface CompraService
{
    Compra createCompra(LocalDate fechaCompra, Usuario usuario, List<Libro> libros);

    Compra updateCompra(Compra compra);

    Compra getCompraById(Long id);

    List<Compra> getCompraByUsuario(String nombre);

    List<Compra> getCompraUser();
}
