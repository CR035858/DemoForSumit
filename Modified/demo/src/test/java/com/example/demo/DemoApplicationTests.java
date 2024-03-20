package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class DemoApplicationTests {

	
    private UserService myService;
    private UserController myController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
    	myService = new UserService();
    	myController = new UserController(myService);
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
    }

    @Test
    public void testGetUser() throws Exception {
        when(myService.getUser(1)).thenReturn(new User(1, "John"));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John"));

        verify(myService).getUser(1);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        when(myService.getAllUsers()).thenReturn(Arrays.asList(new User(1, "John"), new User(2, "Alice")));

        mockMvc.perform(get("/api/users/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Alice"));

        verify(myService).getAllUsers();
    }

    @Test
    public void testCreateUser() throws Exception {
        User newUser = new User(3, "Bob");
        when(myService.createUser(newUser)).thenReturn(newUser);

        mockMvc.perform(post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"name\":\"Bob\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Bob"));

        verify(myService).createUser(newUser);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User updatedUser = new User(1, "UpdatedName");
        when(myService.updateUser(1, updatedUser)).thenReturn(updatedUser);

        mockMvc.perform(put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"UpdatedName\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("UpdatedName"));

        verify(myService).updateUser(1, updatedUser);
    }

    @Test
    public void testDeleteUser() throws Exception {
        when(myService.deleteUser(1)).thenReturn(true);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());

        verify(myService).deleteUser(1);
    }
   
}

