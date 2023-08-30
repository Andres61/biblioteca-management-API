package com.yandresg.biblioteca.controller;

import com.yandresg.biblioteca.dto.LibroDTO;
import com.yandresg.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indica que esta clase es un controlador de Spring que manejará solicitudes REST.
@RestController
//Mapea las solicitudes a la URL base para las operaciones relacionadas con libros.
@RequestMapping("/api/v1/biblioteca/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;


//Métodos similares a AutorController, pero relacionados con operaciones de libros.
    @PostMapping
    public ResponseEntity<LibroDTO> save(@RequestBody LibroDTO libroDTO) {
        try {
            LibroDTO savedLibroDTO = libroService.save(libroDTO);
            return new ResponseEntity<>(savedLibroDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<LibroDTO>> findAll(){
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(libroService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleById(@PathVariable Integer id){
        try {
            libroService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
