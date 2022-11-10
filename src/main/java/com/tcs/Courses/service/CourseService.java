package com.tcs.Courses.service;

import com.tcs.Courses.model.CourseModel;
import com.tcs.Courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseModel> getCourses(){
        return courseRepository.findAll();
    }

    public Optional<CourseModel> getCourse(Long id){
        return courseRepository.findById(id);
    }

    public CourseModel insertCourse(CourseModel course){
        return courseRepository.save(course);
    }

    public CourseModel updateCourse(CourseModel newCourse, Long id){
        return courseRepository.findById(id).map(
                course -> {
                    course.setName(newCourse.getName());
                    course.setCredits(newCourse.getCredits());
                    return courseRepository.save(course);
                }
        ).orElseThrow(() -> new RuntimeException("Sire, I'm afraid I don't found the course"));
    }

    public String deleteCourse(Long id){
        try{
            courseRepository.deleteById(id);
            return "Horreeeyy!!";
        }
        catch(Exception e){
            return "Sire, I'm afraid that there's an error";
        }
    }

    public List<CourseModel> getCourseForStudent(Long id){
        return courseRepository.getCourseByStudent(id);
    }
}
