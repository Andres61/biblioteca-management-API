package com.yandresg.biblioteca.model;

import com.yandresg.biblioteca.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Representa un autor en la biblioteca.
@Data

@NoArgsConstructor

@Entity

@Table(name = "autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    @OneToMany(mappedBy =  "autor")
    private List<Libro> libros;

    public Autor(AutorDTO autorDTO) {
        this.id = autorDTO.getId();
        this.nombre = autorDTO.getNombre();
        this.apellidos = autorDTO.getApellidos();
        this.telefono = autorDTO.getTelefono();
    }
}
