package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.RoomService;
import com.codecool.hogwartshouses.persistence.entity.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomEndpoint.class)
class RoomEndpointTest {

    @MockBean
    RoomService roomService;

    @Autowired
    MockMvc mockMvc;

    String url = "/rooms";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk());

        verify(roomService).findAll();
    }

    @Test
    void getOneFindsEntity() throws Exception {
        long id = 1;
        String uri = url + "/" + id;
        Room room = Room.builder().id(id).build();
        when(roomService.findOne(id)).thenReturn(Optional.of(room));

        mockMvc.perform(get(uri))
                .andExpect(status().isOk());

        verify(roomService).findOne(id);
    }

    @Test
    void getOneDoesNotFindEntity() throws Exception {
        long id = 1;
        String uri = url + "/" + id;

        mockMvc.perform(get(uri))
                .andExpect(status().is4xxClientError());

        verify(roomService).findOne(id);
    }

}