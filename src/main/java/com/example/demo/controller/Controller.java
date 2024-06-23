package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class Controller {

    @Autowired
    private CourseService courseService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCourse")
    public Course addcourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCourse")
    public List<Course> getAllProjects(){
        List<Course> allCourses =null;
        try{
            allCourses=courseService.getCourse();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allCourses;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCourseById/{id}")
    public Optional<Course> getProjectsById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable String id,@RequestBody Course course){
        return courseService.updateCourse(id,course);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/deleteCourse/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id){
        try{
            this.courseService.deleteCourse(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
