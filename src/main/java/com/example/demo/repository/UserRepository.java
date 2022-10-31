package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> getAll() {
        Query selectALL = entityManager.createQuery("select u from User u");
        return selectALL.getResultList();
    }

    public List<User> getByAge(int age) {
        Query selectByAge = entityManager.createQuery("select user FROM User user WHERE user.age<:age");
        selectByAge.setParameter("age", age);
        return selectByAge.getResultList();

    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public User findByFirstName(String firstname) {
        Query selectByFirstName = entityManager.createQuery("select user FROM User user WHERE user.firstName=:firstName");
        selectByFirstName.setParameter("firstName", firstname);
        return (User) selectByFirstName.getSingleResult();
    }

    @Transactional
    public void delete(long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        } else {
            System.out.println("user not found");
        }
    }

}
