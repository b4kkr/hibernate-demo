package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Employee;
import com.example.hibernatedemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.getAll();
    }

}
