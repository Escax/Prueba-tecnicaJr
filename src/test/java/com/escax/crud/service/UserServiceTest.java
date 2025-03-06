package com.escax.crud.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.escax.crud.dto.UserDTO;
import com.escax.crud.entity.User;
import com.escax.crud.mapper.UserMapper;
import com.escax.crud.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper; // ✅ Agregamos Mock para evitar NullPointerException

    @InjectMocks
    private UserService userService; // ✅ Ahora se inyectan los Mocks

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // ✅ Inicializamos los Mocks
        user = new User();
        user.setId(1L);
        user.setName("Juan Pérez");
        user.setEmail("juan.perez@example.com");
    }

    @Test
    void testCreateUser() {
        UserDTO userDTO = new UserDTO(1L, "Juan Pérez", "juan.perez@example.com", "123456", Collections.emptyList());

        User userEntity = new User();
        userEntity.setId(1L);
        userEntity.setName("Juan Pérez");
        userEntity.setEmail("juan.perez@example.com");

        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(userEntity); // ✅ Simulamos conversión DTO -> Entidad
        when(userRepository.save(any(User.class))).thenReturn(userEntity); // ✅ Simulamos guardado en BD
        when(userMapper.toDTO(any(User.class))).thenReturn(userDTO); // ✅ Simulamos conversión Entidad -> DTO

        UserDTO createdUser = userService.createUser(userDTO);

        assertNotNull(createdUser); // ✅ Verifica que no sea null
        assertEquals("Juan Pérez", createdUser.name());
        assertEquals("juan.perez@example.com", createdUser.email());
    }


    @Test
    void testFindUserById_UserExists() {
        User userEntity = new User();
        userEntity.setId(1L);
        userEntity.setName("Juan Pérez");
        userEntity.setEmail("juan.perez@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity)); // ✅ Simula usuario encontrado
        when(userMapper.toDTO(any(User.class))).thenReturn(new UserDTO(1L, "Juan Pérez", "juan.perez@example.com", "******", Collections.emptyList())); // ✅ Simula conversión a DTO

        UserDTO foundUser = userService.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals("Juan Pérez", foundUser.name());
    }


    @Test
    void testFindUserById_UserNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty()); // ✅ Simula usuario no encontrado

        assertThrows(RuntimeException.class, () -> userService.getUserById(2L)); // ✅ Verifica que se lance la excepción esperada
    }


}
