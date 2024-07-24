package com.Ucema.demo.Services;

import com.Ucema.demo.Configuration.JwtUtilities;

import com.Ucema.demo.Model.Comprador;
import com.Ucema.demo.Model.Admin;
import com.Ucema.demo.Model.Usuario;

import com.Ucema.demo.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Override
    @Transactional
    public Comprador createComprador(Comprador comprador) {
        comprador.setPassword(passwordEncoder.encode(comprador.getPassword()));
        return usuarioRepository.save(comprador);
    }

    @Override
    @Transactional
    public Admin createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return usuarioRepository.save(admin);
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Usuario usuario) {
        if(usuario.tieneLibros()) {
            return false;
        }
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Usuario> getByDni(String dni) {
        return this.usuarioRepository.findByDni(dni);
    }

    @Override
    public String authenticate(String username, String password) {
        Usuario user = this.usuarioRepository.findByUsername(username).orElse(null);

        if (user == null|| !passwordEncoder.matches(password, user.getPassword())) { return null; }
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole());
        return token;

    }

    @Override
    public Usuario getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.usuarioRepository.findByUsername(username).orElse(null);
    }
}
