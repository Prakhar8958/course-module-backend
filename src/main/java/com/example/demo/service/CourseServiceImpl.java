package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepo;
    @Override
    public List<Course> getCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(String id) {
        return courseRepo.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
        Course newcourse = new Course();
        newcourse.setId(UUID.randomUUID().toString());
        newcourse.setTitle(course.getTitle());
        newcourse.setDescription(course.getDescription());
        return courseRepo.save(newcourse);
    }

    @Override
    public Course updateCourse(String id,Course course) {
        Course currcourse=courseRepo.getReferenceById(id);
                currcourse.setTitle(course.getTitle());
                currcourse.setDescription(course.getDescription());
                return courseRepo.save(currcourse);

    }

    @Override
    public ResponseEntity<HttpStatus> deleteCourse(String id) {
        Optional<Course> course=courseRepo.findById(id);
        if(course.isPresent()){
            courseRepo.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
