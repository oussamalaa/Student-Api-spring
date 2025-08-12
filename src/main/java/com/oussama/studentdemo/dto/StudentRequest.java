package com.oussama.studentdemo.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequest {
    @NotBlank(message = "name is required")
    private String name;

    @Min(value = 5, message = "age must be >= 5")
    @Max(value = 120, message = "age must be <= 120")
    private int age;

    public StudentRequest() {}
    public StudentRequest(String name, int age) { this.name = name; this.age = age; }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
