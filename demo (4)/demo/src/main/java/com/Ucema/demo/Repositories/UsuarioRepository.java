package com.Ucema.demo.Repositories;

import com.Ucema.demo.Model.Compra;
import com.Ucema.demo.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>
{
    @Query("select u from Usuario u join u.prestamos p join p.libros l " +
            "group by u order by count(*)")
    List<Compra> getUsuariosOrdenadosPorCantidadDeLibrosComprados();

    Optional<Usuario> findByDni(String dni);

    Optional<Usuario> findByUsername(String username);
}
