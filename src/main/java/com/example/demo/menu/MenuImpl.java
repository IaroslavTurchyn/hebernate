package com.example.demo.menu;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Scanner;
@Component
public class MenuImpl implements Menu{
    @Autowired
    private UserRepository userRepository;
    private final String[] items = {
            "1.Create user",
            
            "2.Update user",
           
            "3.Delete user",
           
            "4.Show user info",
            
            "5.Show all users info",
            
            "0. Exit"
    };





    @Override
     public  void show() {
        showItems(items);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (true) {
            switch (choice){
                case 1:
                userRepository.save();
                    show();
                    break;
                case 2:
                    userRepository.update();
                    show();
                    break;
                case 3:
                    userRepository.delete();
                    show();
                    break;
                case 4:
                    userRepository.getInfo();
                    show();
                    break;
                case 5:
                    userRepository.getAll().forEach(System.out::println);
                    show();
                    break;
                case 0:
                    exit();
                    break;
            }


        }
    }

    @Override
    public void exit() {
        System.exit(0);

    }
}
