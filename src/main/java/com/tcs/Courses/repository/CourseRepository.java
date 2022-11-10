package com.tcs.Courses.repository;

import com.tcs.Courses.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long> {
    @Query(value="SELECT id,credits,name,student_id FROM courses c WHERE student_id=:id",nativeQuery = true)
    List<CourseModel> getCourseByStudent(@Param("id") Long id);
}