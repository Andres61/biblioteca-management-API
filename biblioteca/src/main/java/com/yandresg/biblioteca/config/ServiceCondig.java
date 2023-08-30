package com.yandresg.biblioteca.config;

import com.yandresg.biblioteca.service.FabricaAutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indica que la clase es una configuración de Spring que define beans y configuraciones para la aplicación.
@Configuration

public class ServiceCondig {

    //Indica que el método fabricaAutorService() es un bean de Spring que devuelve una instancia de FabricaAutorService, que se gestionará y se podrá inyectar en otras partes de la aplicación.
    @Bean

//Define un bean de Spring llamado fabricaAutorService. Cada vez que se necesite un FabricaAutorService, Spring lo creará usando este método.
    public FabricaAutorService fabricaAutorService(){
        return new FabricaAutorService();
    }
}
