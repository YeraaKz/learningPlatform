package com.example.learningplatform.repository;

import com.example.learningplatform.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public List<Course> findAll();
}
