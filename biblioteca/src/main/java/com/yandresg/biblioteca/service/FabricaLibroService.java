package com.yandresg.biblioteca.service;

import com.yandresg.biblioteca.dto.LibroDTO;
import com.yandresg.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//FabricaAutorService, pero relacionados con operaciones de libros.
@Service
public class FabricaLibroService {

    public Libro createLibro(LibroDTO libroDTO){ // Crea y devuelve un objeto Libro a partir de un LibroDTO
        return new Libro(libroDTO);
    }
    public LibroDTO createLibroDTO(Libro libro){ //Crea y devuelve un objeto LibroDTO a partir de un Libro.
        return new LibroDTO(libro);
    }

    public List<LibroDTO> createLibrosDTO(List<Libro> libros){ //Convierte una lista de objetos Libro en una lista de objetos LibroDTO.
        List<LibroDTO>libroDTOS = new ArrayList<>();
        libros.stream().forEach(
                libro -> {
                    libroDTOS.add(new LibroDTO(libro));
                }
        );
        return libroDTOS;
    }
}
