package com.codecool.hogwartshouses.api.endpoint;

import com.codecool.hogwartshouses.logic.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentEndpoint.class)
class StudentEndpointTest {

    @MockBean
    StudentService studentService;

    @Autowired
    MockMvc mockMvc;

    String url = "/students";

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk());

        verify(studentService).findAll();
    }
}