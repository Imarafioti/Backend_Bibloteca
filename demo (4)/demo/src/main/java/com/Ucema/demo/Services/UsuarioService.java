package com.Ucema.demo.Services;

import com.Ucema.demo.Model.*;

import java.time.LocalDate;
import java.util.Optional;

public interface UsuarioService
{

    Comprador createComprador(Comprador comprador);

    Admin createAdmin(Admin admin);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByDni(String dni);

    String authenticate(String username, String password);

    Usuario getUserInfo();
}
