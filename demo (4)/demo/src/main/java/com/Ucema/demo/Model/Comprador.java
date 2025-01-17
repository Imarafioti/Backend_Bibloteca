package com.Ucema.demo.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Comprador extends Usuario
{

    public Comprador(String username, String password, String nombreCompleto, String identificacion, String dni, String email, LocalDate fechaNacimiento) {
        super(username, password, nombreCompleto, identificacion, dni, email, fechaNacimiento);

    }

    public Comprador() {

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
        authorities.add(new SimpleGrantedAuthority("Comprador"));
        return authorities;
    }

    @Override
    public String getRole() {
        return "Comprador";
    }


}
