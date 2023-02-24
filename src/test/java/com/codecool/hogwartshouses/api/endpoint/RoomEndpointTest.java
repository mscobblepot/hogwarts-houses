package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
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

}