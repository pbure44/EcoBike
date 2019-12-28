package com.ecobike.app;

import com.ecobike.app.repository.impl.FileRepository;
import com.ecobike.app.service.impl.CatalogService;
import com.ecobike.app.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;


@SpringBootApplication
public class EcobikeApplication {

    @Autowired
    private MenuService menuService;

    @PostConstruct
    public void init() throws IOException {
        menuService.menuStart();
    }

    public static void main(String[] args) {
        SpringApplication.run(EcobikeApplication.class, args);
    }

}
