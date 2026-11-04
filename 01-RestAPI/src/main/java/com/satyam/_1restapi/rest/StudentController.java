package com.satyam._1restapi.rest;

import com.satyam._1restapi.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api2")
public class StudentController {

    @GetMapping("/info")
    public Student studentInfo() {
        Student st = new Student(1, "Satyam", "Thane");
        return st;
    }

    @PostMapping("/add")
    public String addstudent(@RequestBody Student data) {

        System.out.println(data);
        return "Data Saved Yepp";
    }
}
