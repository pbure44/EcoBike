package com.ecobike.app;

import com.ecobike.app.service.impl.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class EcobikeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(EcobikeApplication.class, args);
        MenuService menuService = new MenuService();
        menuService.menuStart();

    }

}
