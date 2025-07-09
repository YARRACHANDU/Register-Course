package com.course.course.Registration.controller;

import org.springframework.web.bind.annotation.*;

import com.course.course.Registration.entity.Course;
import com.course.course.Registration.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://127.0.0.1:3000")

public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @GetMapping
    public List<Course> list() {
        return service.getAllCourses();
    }
}
