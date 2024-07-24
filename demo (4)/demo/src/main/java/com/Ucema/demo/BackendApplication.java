package com.Ucema.demo;

import com.Ucema.demo.Model.Comprador;
import com.Ucema.demo.Model.Libro;
import com.Ucema.demo.Model.Admin;
import com.Ucema.demo.Services.LibroService;
import com.Ucema.demo.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	CommandLineRunner init(@Autowired LibroService libroService, @Autowired UsuarioService usuarioService) {
		return (args) -> {
			usuarioService.createComprador(new Comprador("Comprador1", "1234", "Juan", "100", "40000000", "emailcomprador@gmail.com", null));
			usuarioService.createComprador(new Comprador("Comprador2", "1234", "Pedro", "101", "40000001", "emailcomprador2@gmail.com", null));
			usuarioService.createAdmin(new Admin("Vendedor1", "1234", "Carlos", "200", "30000000", "emailvendedor1@gmail.com", null));
			libroService.createLibro(new Libro("0000001111", "1984", "Orwell", "una editorial", 1948));
			libroService.createLibro(new Libro("0000001113", "El Aleph", "Borges", "una editorial", 1949));
			libroService.createLibro(new Libro("0000001114", "El principito", "Saint-Exupery", "una editorial", 1943));
			libroService.createLibro(new Libro("0000001115", "El señor de los anillos", "Tolkien", "una editorial", 1954));
			libroService.createLibro(new Libro("0000001116", "JoJo's Bizarre Adventure", "Hirohiko Araki", "Ivrea", 1987));
			System.out.println("BibliotecaApplication started");
		};
	}


}
