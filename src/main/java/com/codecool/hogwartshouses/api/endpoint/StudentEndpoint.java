package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.StudentService;
import com.codecool.hogwartshouses.persistence.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentEndpoint {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }
}
