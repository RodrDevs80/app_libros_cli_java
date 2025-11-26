package com.librosappaplura.librosapp_pract_alura;

import com.librosappaplura.librosapp_pract_alura.services.ConsumeApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosappPractAluraApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LibrosappPractAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Principal principal = new Principal();
       principal.menu();
    }
}
