package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void createUser_invalidData_returnsBadRequest() throws Exception {
        UserDTO invalid = new UserDTO();
        invalid.setName("");
        invalid.setEmail("invalid");

        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(invalid)))
           .andExpect(status().isBadRequest())
           .andExpect(jsonPath("$.name").value("Name darf nicht leer sein"))
           .andExpect(jsonPath("$.email").value("Ungültige E-Mail-Adresse"));
    }
}
