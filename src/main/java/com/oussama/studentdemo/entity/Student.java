package com.oussama.studentdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                  // Use wrapper Long (nullable)

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false)
    private int age;

    public Student() { }             // Required by JPA

    // Convenience ctor for creates (used by service.create)
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // (Optional) keep an id-including ctor if you want
    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters & setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
