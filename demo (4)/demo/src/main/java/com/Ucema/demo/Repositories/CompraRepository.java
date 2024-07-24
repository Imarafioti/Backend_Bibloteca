package com.Ucema.demo.Repositories;

import com.Ucema.demo.Model.Compra;
import com.Ucema.demo.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
public interface CompraRepository extends CrudRepository<Compra, Long>
{
    List<Compra> findByUsuario(Usuario usuario);

    List<Compra> findByLibros_Isbn(String isbn);

    List<Compra> findByUsuario_DniAndLibros_Titulo(String dni, String libro);

    List<Compra> findByUsuario_NombreCompleto(String nombre);

    List<Compra> findByUsuario_Username(String username);
}
