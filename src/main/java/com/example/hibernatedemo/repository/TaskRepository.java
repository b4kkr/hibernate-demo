package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.entity.Task;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final EntityManager entityManager;

    public void save(Task task){
        try(Session session = entityManager.unwrap(Session.class)){
            session.saveOrUpdate(task);
        }
    }

}
