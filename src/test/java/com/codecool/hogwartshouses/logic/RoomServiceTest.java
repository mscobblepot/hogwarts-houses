package com.codecool.hogwartshouses.logic;

import com.codecool.hogwartshouses.persistence.repository.RoomRepository;
import org.junit.jupiter.api.Test;

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

}