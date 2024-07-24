package com.Ucema.demo.Model;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Admin extends Usuario
{
    @OneToMany(mappedBy = "vendedor")
    private List<Libro> librosEnVenta;

    public Admin(String username, String password, String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento) {
        super(username, password, nombreCompleto, identificacion, dni, email, fechaNacimiento);
        this.librosEnVenta = new ArrayList<>();
    }

    public Admin() {

    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Admin"));
        return authorities;
    }
    public List<Libro> getLibrosEnVenta() {
        return librosEnVenta;
    }

    public void setLibrosEnVenta(List<Libro> librosEnVenta) {
        this.librosEnVenta = librosEnVenta;
    }

    public void agregarLibro(Libro libro) {
        librosEnVenta.add(libro);
        libro.setAdmin(this);
    }

    public void eliminarLibro(Libro libro) {
        librosEnVenta.remove(libro);
        libro.setAdmin(null);
    }

    public void modificarLibro(Libro libro, String nuevoTitulo, String nuevoAutor, String nuevoEstado) {
        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        libro.setEstado(nuevoEstado);
    }

    public List<Libro> leerLibros() {
        return librosEnVenta;
    }
}
