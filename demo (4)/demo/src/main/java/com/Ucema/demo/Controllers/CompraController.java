package com.Ucema.demo.Controllers;


import com.Ucema.demo.Dto.NewCompraDTO;
import com.Ucema.demo.Model.Compra;
import com.Ucema.demo.Model.Comprador;
import com.Ucema.demo.Services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Compra")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CompraController
{
    @Autowired
    private CompraService compraService;

    // POST ../api/compra
    @PostMapping(value = "")
    public Compra createCompra(@RequestBody NewCompraDTO compra) {
        return compraService.createCompra(compra.getFechaCompra(), compra.getUsuario(), compra.getLibros());
    }

    // PUT ../api/compra
    @PutMapping(value = "")
    public Compra updateCompra(@RequestBody Compra compra) {
        return compraService.updateCompra(compra);
    }

    // GET ../api/compra/usuario/{nombre}
    @GetMapping(value = "/usuario/{nombre}")
    public List<Compra> getCompraByUsuario(@PathVariable String nombre) {
        return compraService.getCompraByUsuario(nombre);
    }

    @GetMapping(value = "/{id}")
    public Compra getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id);
    }

    @GetMapping(value = "/miscompras")
    public List<Compra> getMisCompras() {
        return compraService.getCompraUser();
    }


}
