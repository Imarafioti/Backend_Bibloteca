package com.Ucema.demo.Controllers;

import com.Ucema.demo.Model.Comprador;
import com.Ucema.demo.Model.Admin;
import com.Ucema.demo.Model.Usuario;
import com.Ucema.demo.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    // POST ../api/usuario/comprador
    @PostMapping(value = "/Comprador")
    public Usuario createComprador(@RequestBody Comprador usuario) {
        return usuarioService.createComprador(usuario);
    }

    // POST ../api/usuario/Admin (Vendedor)
    @PostMapping(value = "/Admin")
    public Usuario createAdmin(@RequestBody Admin usuario) {
        return usuarioService.createAdmin(usuario);
    }

    // PUT ../api/usuario
    @PutMapping(value = "")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    // DELETE ../api/usuario
    @DeleteMapping(value = "")
    public boolean deleteUsuario(@RequestBody Usuario usuario) {
        return usuarioService.deleteUsuario(usuario);
    }

    // GET ../api/usuario/dni/{dni}
    @GetMapping(value = "dni/{dni}")
    public Usuario getByDni(@PathVariable String dni) {
        return usuarioService.getByDni(dni).orElse(null);
    }

    /**
     * Endpoint para obtener la información del usuario logueado mediante jwt
     */
    @GetMapping(value = "/info")
    public Usuario getUserInfo() {
        return usuarioService.getUserInfo();
    }

}
