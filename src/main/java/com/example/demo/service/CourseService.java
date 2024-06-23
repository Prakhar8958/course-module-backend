package com.example.demo.service;

import com.example.demo.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseService {

   public List<Course> getCourse();

   public Optional<Course> getCourseById(String id);

   public Course addCourse(Course course);

   public Course updateCourse(String id,Course course);

   public ResponseEntity<HttpStatus> deleteCourse(String id);
}
