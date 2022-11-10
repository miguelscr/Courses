package com.tcs.Courses.controller;

import com.tcs.Courses.model.CourseModel;
import com.tcs.Courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<CourseModel> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/course/{id}")
    public Optional<CourseModel> getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping("/course")
    public CourseModel setCourse(@RequestBody CourseModel course){
        return courseService.insertCourse(course);
    }

    @PutMapping("/course/{id}")
    public CourseModel updateCourse(@RequestBody CourseModel course, @PathVariable Long id){
        return courseService.updateCourse(course,id);
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

    @GetMapping("/courseForStudent/{id}")
    public List<CourseModel> getCourseForStudent(@PathVariable Long id){
        return courseService.getCourseForStudent(id);
    }

}