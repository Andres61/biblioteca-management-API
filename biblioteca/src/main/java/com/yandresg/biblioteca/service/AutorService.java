package com.yandresg.biblioteca.service;

import com.yandresg.biblioteca.dto.AutorDTO;
import com.yandresg.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // Indica que esta clase es un servicio de Spring.
public class AutorService {
    @Autowired
    private  FabricaAutorService fabricaAutorService;
    @Autowired
    private AutorRepository autorRepository;
    public AutorDTO save(AutorDTO autorDTO){ //Maneja la lógica para guardar un nuevo autor en la base de datos.
        return fabricaAutorService.createAutorDTO(autorRepository.save(fabricaAutorService.createAutor(autorDTO)));
    }

    public List<AutorDTO> findAll(){ //Maneja la lógica para obtener todos los autores.
        return fabricaAutorService.createAutoresDTO(autorRepository.findAll());
    }

    public AutorDTO findById(Integer id){ //Maneja la lógica para obtener un autor por su ID.
        return  fabricaAutorService.createAutorDTO(autorRepository.findById(id).get());
    }

    public void deleteById(Integer id){// Maneja la lógica para eliminar un autor por su ID.
        autorRepository.deleteById(id);
    }
}
