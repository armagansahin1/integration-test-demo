package com.loki.integrationtestdemo.controller;

import com.loki.integrationtestdemo.business.abstracts.IStudentService;
import com.loki.integrationtestdemo.controller.abstracts.AbstractController;
import com.loki.integrationtestdemo.entity.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentControllers extends AbstractController {

    private final IStudentService studentService;

    @Autowired
    public StudentControllers(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody StudentDAO studentDAO){
        return created(studentService.add(studentDAO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ok(studentService.get(id));
    }
}
