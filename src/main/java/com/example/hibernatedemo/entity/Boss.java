package com.example.hibernatedemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bosses")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private int age;

    @OneToMany(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH,
        CascadeType.REMOVE
    }, mappedBy = "boss")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
