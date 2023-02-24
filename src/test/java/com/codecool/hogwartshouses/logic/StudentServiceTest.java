package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.persistence.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    StudentRepository studentRepository = mock(StudentRepository.class);
    StudentService studentService = new StudentService(studentRepository);

    @Test
    void findAll() {
        studentService.findAll();

        verify(studentRepository).findAll();
    }
}