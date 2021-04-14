package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Task;
import com.example.hibernatedemo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public void save(Task task){
        taskRepository.save(task);
    }
}
