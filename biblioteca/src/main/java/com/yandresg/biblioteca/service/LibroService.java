package com.yandresg.biblioteca.service;

import com.yandresg.biblioteca.dto.LibroDTO;
import com.yandresg.biblioteca.model.Autor;
import com.yandresg.biblioteca.repository.AutorRepository;
import com.yandresg.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Métodos similares a AutorService, pero relacionados con operaciones de libro
@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private FabricaLibroService fabricaLibroService;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private FabricaAutorService fabricaAutorService;

    public LibroDTO save(LibroDTO libroDTO) {
        // Buscar autor
        Autor autor = autorRepository.findById(libroDTO.getIdAutor()).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        libroDTO.setAutorDto(fabricaAutorService.createAutorDTO(autor));

        return fabricaLibroService.createLibroDTO(libroRepository.save(fabricaLibroService.createLibro(libroDTO)));
    }

    public List<LibroDTO> findAll() {
        return fabricaLibroService.createLibrosDTO(libroRepository.findAll());
    }

    public LibroDTO findById(Integer id) {
        return fabricaLibroService.createLibroDTO(libroRepository.findById(id).orElse(null));
    }

    public void deleteById(Integer id) {
        libroRepository.deleteById(id);
    }
}
