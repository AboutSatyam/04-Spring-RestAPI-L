package com.satyam._8resthateoas.rest;

import com.satyam._8resthateoas.model.Course;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    private final WebMvcLinkBuilderFactory webMvcLinkBuilderFactory;

    public CourseController(WebMvcLinkBuilderFactory webMvcLinkBuilderFactory) {
        this.webMvcLinkBuilderFactory = webMvcLinkBuilderFactory;
    }

    @GetMapping("/course-info")
    public ResponseEntity<Course> getCourseInfo() {

        Course course = new Course(1, "Devops With AWS", 9999.8);
        Link link = webMvcLinkBuilderFactory.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getAllCourseInfo()).withRel("GetAll Course Info");
        course.add(link);
        return new ResponseEntity<Course>(course, HttpStatus.OK);

    }


    @GetMapping("/all-course-info")
    public ResponseEntity<List> getAllCourseInfo() {

        Course course = new Course(1, "Devops With AWS", 9999.8);
        Course course1 = new Course(1, "Devops With AWS", 9999.8);
        Course course2 = new Course(1, "Devops With AWS", 9999.8);

        List<Course> courses = new ArrayList<>();

        courses.add(course);
        courses.add(course1);
        courses.add(course2);

        return new ResponseEntity<List>(courses, HttpStatus.OK);
    }
}

