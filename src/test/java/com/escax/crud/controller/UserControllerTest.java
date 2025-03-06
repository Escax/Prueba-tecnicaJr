/*
package com.escax.crud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.escax.crud.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.escax.crud.service.UserService;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;


import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService; // ✅ Se asegura que `UserService` esté mockeado

    @InjectMocks
    private UserController userController; // ✅ Se inyecta manualmente el controlador

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // ✅ Inicializa los Mocks antes de cada test
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userService.findAllUsers()).thenReturn(Collections.emptyList()); // ✅ Se asegura que devuelve una lista vacía

        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(0)));
    }

    @Test
    void testCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO(1L, "Juan Pérez", "juan.perez@example.com", "123456", Collections.emptyList());

        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO); // ✅ Simulamos que el usuario se crea correctamente

        mockMvc.perform(post("/api/v1/users")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk());
    }
}

 */