package com.curso.clientecoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * La clase principal para iniciar la aplicación Spring Boot relacionada con "Clientecoche".
 * 
 * Esta clase contiene la configuración y el punto de entrada principal 
 * para una aplicación Spring Boot que interactúa con coches.
 * 
 * @author Luis Miguel Albarracín Castillo
 * 
 */
@EntityScan(basePackages = {"com.curso.model"})
@EnableJpaRepositories(basePackages = {"com.curso.dao"})
@SpringBootApplication(scanBasePackages = {"com.curso.controller", "com.curso.service"})
public class ClientecocheApplication {

    /**
     * El punto de entrada principal de la aplicación.
     * 
     * @param args argumentos de línea de comandos pasados ​​al programa.
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientecocheApplication.class, args);
    }

    /**
     * Crea y devuelve un nuevo objeto RestTemplate.
     * 
     * Este bean se utiliza para realizar operaciones basadas en HTTP, 
     * como enviar una solicitud HTTP y recibir una respuesta HTTP.
     * 
     * @return un nuevo objeto RestTemplate.
     */
    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
}
