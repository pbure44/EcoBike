package com.ecobike.app;

import com.ecobike.app.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcobikeApplication implements CommandLineRunner {

    @Autowired
    private MenuService menuService;

    public static void main(String[] args) {
        SpringApplication.run(EcobikeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuService.menuStart();
    }
}
