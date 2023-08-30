package com.yandresg.biblioteca.controller;

import com.yandresg.biblioteca.dto.AutorDTO;
import com.yandresg.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indica que esta clase es un controlador de Spring que manejará solicitudes REST.
@RestController
//Mapea las solicitudes a la URL base para las operaciones relacionadas con autores.
@RequestMapping("/api/v1/biblioteca/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping
    //Maneja solicitudes POST para guardar un autor en la base de datos.
    public ResponseEntity <AutorDTO> save(@RequestBody AutorDTO autorDTO){
        return new ResponseEntity<>( autorService.save(autorDTO), HttpStatus.CREATED);

    }
    @GetMapping
    //Maneja solicitudes GET para obtener todos los autores.
    public ResponseEntity <List<AutorDTO>> findAll(){
        return new ResponseEntity<>( autorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    // Maneja solicitudes GET para obtener un autor por su ID.
    public ResponseEntity<AutorDTO> findById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(autorService.findById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Maneja solicitudes DELETE para eliminar un autor por su ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        try {
            autorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
