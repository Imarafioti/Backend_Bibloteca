package com.Ucema.demo.Services;

import com.Ucema.demo.Model.Libro;
import com.Ucema.demo.Model.Compra;
import com.Ucema.demo.Model.Usuario;

import com.Ucema.demo.Repositories.LibroRepository;
import com.Ucema.demo.Repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraServiceImpl implements CompraService
{
    @Autowired
    private CompraRepository CompraRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    @Transactional
    public Compra createCompra(LocalDate fechaCompra, Usuario usuario, List<Libro> libros) {
        Compra compra = new Compra(fechaCompra, usuario, libros);
        for (Libro libro : compra.getLibros()) {
            libro.setEstado("COMPRADO");
            this.libroRepository.save(libro);
        }
        this.CompraRepository.save(compra);
        return compra;
    }

    @Override
    @Transactional
    public Compra updateCompra(Compra compra)
    {
        return this.CompraRepository.save(compra);
    }

    @Override
    @Transactional(readOnly = true)
    public Compra getCompraById(Long id) {
        return this.CompraRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Compra> getCompraByUsuario(String nombre) {
        return this.CompraRepository.findByUsuario_NombreCompleto(nombre);
    }

    @Override
    public List<Compra> getCompraUser() {
        // Obtengo el usuario autenticado desde el contexto de Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        Usuario usuario = (Usuario) authentication.getPrincipal(); //Obtengo el usuario autenticado
        String name = authentication.getName(); //Obtengo el nombre del usuario autenticado
        return this.CompraRepository.findByUsuario_Username(usuario.getUsername());
    }
}
