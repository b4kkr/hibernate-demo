package com.example.hibernatedemo.repository;

import com.example.hibernatedemo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {


    private final EntityManager entityManager;

    //CRUD
    public void save(Employee employee) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.saveOrUpdate(employee);
        }
    }

    public List<Employee> getAll(){
        try(Session session = entityManager.unwrap(Session.class)){
            Query query = session.createQuery("from Employee");
            return query.getResultList();
        }
    }

    public Employee getEmployeeById(Long id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(Employee.class, id);
        }
    }

}
