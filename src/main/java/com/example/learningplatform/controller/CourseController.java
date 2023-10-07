package com.example.learningplatform.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.example.learningplatform.entity.Course;
import com.example.learningplatform.entity.User;
import com.example.learningplatform.model.dto.CourseDTO;
import com.example.learningplatform.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        List<Course> courses = courseService.findAll();

        return ResponseEntity.ok(courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(modelMapper.map(courseService.findById(id), CourseDTO.class));
    }

    @PostMapping("/{id}/enroll")
    public ResponseEntity<String> enrollUserInCourse(@PathVariable("id") Long id){
        courseService.enrollUserInCourse(id);
        return ResponseEntity.ok("User enrolled in the course successfully");
    }
}
