package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.entity.Boss;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BossRepository {

    private final EntityManager entityManager;

    public void save(Boss boss){
        try(Session session = entityManager.unwrap(Session.class)){
            session.saveOrUpdate(boss);
        }
    }

}
