package com.Ucema.demo;

import com.Ucema.demo.Model.*;
import com.Ucema.demo.Services.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private LibroService libroService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private CompraService compraService;

	@Test
	void contextLoads() {
	}

	@Test
	void createAndGetEntitiesTest() {

		// Crear y verificar Libros
		Libro libro1 = new Libro("0000001111", "Cien años de soledad", "Garcia Marquez", "una editorial", 1982);
		Assert.notNull(libro1.getId(), "No se ha asignado un id");

		Libro libro2 = new Libro("0000001112", "1984", "George Orwell", "una editorial", 1949);

		List<Libro> list1 = this.libroService.getAll();
		Assert.isTrue(list1.size() == 2, "No se han obtenido los libros correctamente");

		List<Libro> list2 = this.libroService.getByTitulo("1984");
		Assert.isTrue(list2.size() == 1, "No se han obtenido los libros correctamente");
		Assert.isTrue(Objects.equals(list2.get(0).getIsbn(), "0000001112"), "No se han obtenido los libros correctamente");

	}
}


