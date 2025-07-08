package com.course.course.Registration.service;

import com.course.course.Registration.entity.Course;
import com.course.course.Registration.entity.Student;
import com.course.course.Registration.repository.StudentRepository;
import com.course.course.Registration.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public void registerCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();
        student.getCourses().add(course);
        studentRepo.save(student);
    }

    public Set<Course> getStudentCourses(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow().getCourses();
    }
}
