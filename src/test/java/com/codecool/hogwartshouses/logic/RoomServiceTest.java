package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.data.Pet;
import com.codecool.hogwartshouses.persistence.entity.Room;
import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoomServiceTest {
    RoomRepository roomRepository = mock(RoomRepository.class);
    RoomService roomService = new RoomService(roomRepository);

    @Test
    void findAll() {
        roomService.findAll();

        verify(roomRepository).findAll();
    }

    @Test
    void findOne() {
        long id = 1;
        roomService.findOne(id);

        verify(roomRepository).findById(id);
    }

    @Test
    void save() {
        Room room = Room.builder().build();
        roomService.save(room);

        verify(roomRepository).save(room);
    }

    @Test
    void delete() {
        long id = 1;
        roomService.delete(id);

        verify(roomRepository).deleteById(id);
    }

    @Test
    void findAvailable() {
        roomService.findAvailable();

        verify(roomRepository).findByStudentIsNull();
    }

    @Test
    void findAvailableForRatOwners() {
        roomService.findAvailableForRatOwners();

        List<Pet> pets = List.of(Pet.CAT, Pet.OWL);
        verify(roomRepository).findByStudentIsNullOrStudentIsNotNullAndStudentPetIsNotIn(pets);
    }
}