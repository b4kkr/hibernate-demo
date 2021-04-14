package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Employee;
import com.example.hibernatedemo.repository.EmployeeRepository;
import com.example.hibernatedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HibernateDemoApplication {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @PostConstruct
    void init() {
        Employee employee = new Employee(
            "Kiss Pista",
            "kiss@mail.hu"
        );
        employeeService.save(employee);
    }


}
