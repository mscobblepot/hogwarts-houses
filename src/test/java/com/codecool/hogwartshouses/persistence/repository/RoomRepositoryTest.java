package com.codecool.hogwartshouses.persistence.repository;

import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DataJpaTest
class RoomRepositoryTest {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    StudentRepository studentRepository;

    @AfterEach
    void after() {
        roomRepository.deleteAll();
    }

    @Test
    void findByStudentIsNull() {
        Student student = Student.builder().build();
        studentRepository.save(student);
        Room room1 = Room.builder().student(student).build();
        Room room2 = Room.builder().build();
        roomRepository.saveAll(List.of(room1, room2));

        List<Room> result = roomRepository.findByStudentIsNull();
        List<Room> expected = List.of(room2);

        assertIterableEquals(expected, result);
    }
}