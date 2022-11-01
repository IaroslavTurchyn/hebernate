package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Scanner;

@Repository
public class UserRepository {
    Scanner scanner=new Scanner(System.in);
    @PersistenceContext
    private EntityManager entityManager;

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save() {
        System.out.println("Enter your first name");
        String firstName = scanner.next();

        System.out.println("Enter your last name");
        String lastName = scanner.next();

        System.out.println("Enter your age");
        int age = scanner.nextInt();

        System.out.println("Enter your state: Male or Female ");
        String state =scanner.next();

        entityManager.persist(new User(firstName,lastName,age,state));
    }

    @Transactional
    public void update() {
        System.out.println("Please enter id:");
        long id = scanner.nextLong();
        User user = findById(id);
        if (user == null) {
            System.out.println("user not found");
            System.exit(0);
        }else {
            System.out.println("Enter your  first name: ");
            String firstName = scanner.next();

            System.out.println("Enter your last  name: ");
            String lastName = scanner.next();

            System.out.println("Enter your  age : ");
            int age = scanner.nextInt();

            System.out.println("Enter your state: Male or Female ");
            String state =scanner.next();
            entityManager.merge(new User(id,firstName,lastName,age,state));
        }
    }

    public List<User> getAll() {
        Query selectALL = entityManager.createQuery("select u from User u");
        return selectALL.getResultList();
    }

    public void getInfo() {
        System.out.println("Enter user id:");
        Long id = scanner.nextLong();

        User user = findById(id);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user);
        }
    }


        @Transactional
        public void delete () {
            System.out.println("Please enter id:");
            long id = scanner.nextLong();
            User user = findById(id);
            if (user != null) {
                entityManager.remove(user);
            } else {
                System.out.println("user not found");
            }
        }
    }


