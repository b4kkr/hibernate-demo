package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Boss;
import com.example.hibernatedemo.entity.Desk;
import com.example.hibernatedemo.entity.Employee;
import com.example.hibernatedemo.entity.Task;
import com.example.hibernatedemo.repository.EmployeeRepository;
import com.example.hibernatedemo.service.BossService;
import com.example.hibernatedemo.service.EmployeeService;
import com.example.hibernatedemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HibernateDemoApplication {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BossService bossService;

    @Autowired
    private TaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoApplication.class, args);
    }

    @PostConstruct
    void init() {
        Boss boss = new Boss("Fonok", 50);
        Employee employee = new Employee(
            "Kiss Pista",
            "kiss@mail.hu"
        );
        Desk desk = new Desk(20);
        desk.setEmployee(employee);
        employee.setDesk(desk);
        boss.getEmployees().add(employee);
        employee.setBoss(boss);
        Task task = new Task("Do your work");
        task.setBoss(boss);
        task.setEmployee(employee);
        employee.getTasks().add(task);
        boss.getTasks().add(task);
        taskService.save(task);

    }


}
