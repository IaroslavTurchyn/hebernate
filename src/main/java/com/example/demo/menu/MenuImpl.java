package com.example.demo.menu;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Scanner;
@Repository
public class MenuImpl implements Menu{
@Autowired
    private UserRepository userRepository;
    private final String[] items = {"""
            1.Create user
            ---------
            2.Update user
            --------
            3.Delete user 
            --------
            4.Show user info
            --------
            5.Show all users info
            -------
            0. Exit"""
    };





    @Override
     public  void show() {
        showItems(items);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                userRepository.save();
                    show();
                case 2:
                    userRepository.update();
                    show();
                case 3:
                    userRepository.delete();
                    show();
                case 4:
                    userRepository.getInfo();
                    show();;
                case 5:
                    userRepository.getAll().forEach(System.out::println);
                    show();
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
