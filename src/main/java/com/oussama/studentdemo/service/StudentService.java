package com.oussama.studentdemo.service;

import com.oussama.studentdemo.entity.Student;
import com.oussama.studentdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> findAll() {
        return repo.findAll();
    }

    public Student findById(Long id) {
        if (id == null) throw new IllegalArgumentException("id must not be null");
        return repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student create(String name, int age) {
        // Let JPA generate the id (Student.id must be Long with @GeneratedValue)
        Student s = new Student(name, age);
        return repo.save(s);
    }

    public Student update(Long id, String name, int age) {
        Student s = findById(id); // 404 if missing
        s.setName(name);
        s.setAge(age);
        return repo.save(s);
    }

    public void delete(Long id) {
        if (id == null) throw new IllegalArgumentException("id must not be null");
        if (!repo.existsById(id)) throw new StudentNotFoundException(id);
        repo.deleteById(id);
    }
}
