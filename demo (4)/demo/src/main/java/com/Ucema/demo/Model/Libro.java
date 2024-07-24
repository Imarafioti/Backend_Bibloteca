package com.Ucema.demo.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, length = 100)
    @ManyToOne
    @JoinColumn(name = "Admin_id")
    private Admin admin;


    private String editorial;

    private int anio;


    private String estado;

    @ManyToMany(mappedBy = "libros")
    private List<Compra> compras;


    public Libro(String isbn, String titulo, String autor, String editorial, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.estado = "Disponible";
        this.compras = new ArrayList<>();
    }

    public Libro() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public boolean sinCompras() {
        return this.compras.isEmpty();
    }

    public Admin getAdmin(){ return admin;}
    public void setAdmin(Admin admin) {this.admin = admin;}
}
