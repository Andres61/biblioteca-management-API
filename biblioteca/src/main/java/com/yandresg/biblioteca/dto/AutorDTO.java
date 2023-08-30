package com.yandresg.biblioteca.dto;

import com.yandresg.biblioteca.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


//Objeto de transferencia de datos que transporta información de autor entre capas de la aplicación.
@Data
@NoArgsConstructor
public class AutorDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private List<LibroDTO> libroDTOS;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellidos = autor.getApellidos();
        this.telefono = autor.getTelefono();

        this.libroDTOS = new ArrayList<>();
        autor.getLibros().forEach(
                libro -> libroDTOS.add(new LibroDTO(libro))
        );
    }
}
