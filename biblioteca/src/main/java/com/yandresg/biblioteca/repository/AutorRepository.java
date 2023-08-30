package com.yandresg.biblioteca.repository;

import com.yandresg.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indica que esta interfaz es un bean de repositorio de Spring que maneja operaciones de acceso a datos.

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    //Descripción: Proporciona métodos predefinidos para realizar operaciones CRUD en la base de datos para la entidad Autor.
}
