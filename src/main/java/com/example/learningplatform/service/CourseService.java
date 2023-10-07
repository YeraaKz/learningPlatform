package com.example.learningplatform.service;

import com.example.learningplatform.entity.Course;
import com.example.learningplatform.entity.Enrollment;
import com.example.learningplatform.entity.User;
import com.example.learningplatform.exception.NotFoundException;
import com.example.learningplatform.repository.CourseRepository;
import com.example.learningplatform.repository.EnrollmentRepository;
import com.example.learningplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;

    public List<Course> findAll() { return courseRepository.findAll(); }

    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id " + id));
    }

    public void enrollUserInCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Course not found with id " + id));

        User user = getCurrentUser();

        Enrollment enrollment = Enrollment.builder()
                .user(user)
                .course(course)
                .enrollmentDate(new Date())
                .build();

        enrollmentRepository.save(enrollment);
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new NotFoundException("User not found with email " + authentication.getName()));
        return currentUser;
    }
}
