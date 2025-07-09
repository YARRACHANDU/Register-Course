package com.course.course.Registration.controller;

import org.springframework.web.bind.annotation.*;

import com.course.course.Registration.entity.Course;
import com.course.course.Registration.entity.Student;
import com.course.course.Registration.service.StudentService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://127.0.0.1:3000")

public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> list() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/register/{courseId}")
    public void register(@PathVariable Long id, @PathVariable Long courseId) {
        service.registerCourse(id, courseId);
    }

    @GetMapping("/{id}/courses")
    public Set<Course> getCourses(@PathVariable Long id) {
        return service.getStudentCourses(id);
    }
}
