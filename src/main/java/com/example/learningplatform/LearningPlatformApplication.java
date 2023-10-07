package com.example.learningplatform;

import com.example.learningplatform.entity.Course;
import com.example.learningplatform.entity.Lesson;
import com.example.learningplatform.entity.Role;
import com.example.learningplatform.entity.User;
import com.example.learningplatform.repository.CourseRepository;
import com.example.learningplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class LearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPlatformApplication.class, args);
	}

	private final PasswordEncoder passwordEncoder;

//	@Bean
//	CommandLineRunner runner(CourseRepository courseRepository,
//							 UserRepository userRepository){
//        return args -> {
//
//			User user_student = User.builder()
//					.username("Yera")
//					.password(passwordEncoder.encode("123"))
//					.firstname("Yernar")
//					.lastname("Orysbayev")
//					.role(Role.USER)
//					.email("test@mail.ru")
//					.build();
//
//			User user_teacher = User.builder()
//					.username("teacher1")
//					.password(passwordEncoder.encode("123"))
//					.firstname("teacher1_firstname")
//					.lastname("teacher2_lastname")
//					.role(Role.TEACHER)
//					.email("teacher@gmail.com")
//					.build();
//
//			userRepository.save(user_teacher);
//			userRepository.save(user_student);
//
//            Course course = Course.builder()
//					.name("Basic of Blockchain")
//					.description("In this course you will learn about basics of blockchain")
//					.levelDifficulty(1)
//					.dateCreated(new Date())
//					.teacher(user_teacher)
//					.build();
//
//			courseRepository.save(course);
//		};
//    }
}
