package com.yandresg.biblioteca.dto;

import com.yandresg.biblioteca.model.Libro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


//Objeto de transferencia de datos que transporta información de libro entre capas de la aplicación.
@Data
@NoArgsConstructor
public class LibroDTO {

    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fechaEdicion;
    private AutorDTO autorDto;
    private Integer idAutor;


    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.isbn = libro.getIsbn();
        this.nombre = libro.getNombre();
        this.editorial = libro.getEditorial();
        this.genero = libro.getGenero();
        this.numeroPaginas = libro.getNumeroPaginas();
        this.precio = libro.getPrecio();
        this.fechaEdicion = libro.getFechaEdicion();
        //this.autorDto = new AutorDTO((libro.getAutor()));
    }
}
