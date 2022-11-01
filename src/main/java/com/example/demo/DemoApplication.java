package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.menu.Menu;
import com.example.demo.menu.MenuImpl;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    public MenuImpl menu;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.show();

    }


}
