package com.oussama.studentdemo.service;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student " + id + " not found");
    }
}
