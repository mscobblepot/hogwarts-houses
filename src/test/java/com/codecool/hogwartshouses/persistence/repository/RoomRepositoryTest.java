package com.codecool.hogwartshouses.persistence.repository;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
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
        studentRepository.deleteAll();
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

    @Test
    void findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn() {
        Student studentWithCat = Student.builder().pet(Pet.CAT).build();
        Student studentWithOwl = Student.builder().pet(Pet.OWL).build();
        Student studentWithRat = Student.builder().pet(Pet.RAT).build();
        studentRepository.saveAll(List.of(studentWithCat, studentWithOwl, studentWithRat));
        Room room1 = Room.builder().student(studentWithCat).build();
        Room room2 = Room.builder().student(studentWithOwl).build();
        Room room3 = Room.builder().student(studentWithRat).build();
        Room room4 = Room.builder().build();
        roomRepository.saveAll(List.of(room1, room2, room3, room4));

        assertAll(
                () -> roomForPetOwners(List.of(room4), List.of()),
                () -> roomForPetOwners(List.of(room2, room3, room4), List.of(Pet.CAT)),
                () -> roomForPetOwners(List.of(room1, room3, room4), List.of(Pet.OWL)),
                () -> roomForPetOwners(List.of(room1, room2, room4), List.of(Pet.RAT)),
                () -> roomForPetOwners(List.of(room3, room4), List.of(Pet.CAT, Pet.OWL)),
                () -> roomForPetOwners(List.of(room4), List.of(Pet.CAT, Pet.OWL, Pet.RAT))
        );
    }

    private void roomForPetOwners(List<Room> expected, List<Pet> exclusions) {
        List<Room> result = roomRepository.findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(exclusions);

        assertIterableEquals(expected, result);
    }
}