package com.ecobike.app;

import com.ecobike.app.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcobikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcobikeApplication.class, args);
    }

}
