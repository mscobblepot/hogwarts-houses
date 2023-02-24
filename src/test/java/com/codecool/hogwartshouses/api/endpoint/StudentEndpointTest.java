package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentEndpoint.class)
class StudentEndpointTest {

    @MockBean
    StudentService studentService;

    @Autowired
    MockMvc mockMvc;

    String url = "/students";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(studentService).findAll();
    }
}