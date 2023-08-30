package com.yandresg.biblioteca.service;

import com.yandresg.biblioteca.dto.AutorDTO;
import com.yandresg.biblioteca.model.Autor;

import java.util.ArrayList;
import java.util.List;

public class FabricaAutorService {
    public Autor createAutor(AutorDTO autorDTO){//Crea un objeto Autor a partir de un AutorDTO.
        return new Autor(autorDTO);
    }

    public AutorDTO createAutorDTO(Autor autor){// Crea un objeto AutorDTO a partir de un Autor.
        return  new AutorDTO(autor);
    }

    public List<AutorDTO>createAutoresDTO(List<Autor>listaAutores){// Convierte una lista de objetos Autor en una lista de objetos AutorDTO.
        List<AutorDTO> autorDTOS= new ArrayList<>();
        listaAutores.stream().forEach(
                autor -> {
                    autorDTOS.add(createAutorDTO(autor));
                }
        );
        return autorDTOS;
    }
}
