package com.oussama.studentdemo.service;

import com.oussama.studentdemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final Map<Long, Student> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public StudentService() {
        // seed data
        create("Alice", 20);
        create("Bob", 22);
    }

    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }

    public Student findById(Long id) {
        if (id == null) throw new IllegalArgumentException("id must not be null");
        Student s = store.get(id);
        if (s == null) throw new StudentNotFoundException(id);
        return s;
    }

    public Student create(String name, int age) {
        long id = seq.incrementAndGet();
        Student s = new Student(id, name, age);
        store.put(id, s);
        return s;
    }

    public Student update(Long id, String name, int age) {
        Student s = findById(id);
        s.setName(name);
        s.setAge(age);
        return s;
    }

    public void delete(Long id) {
        if (store.remove(id) == null) throw new StudentNotFoundException(id);
    }
}
