package com.example.atividade01.controller;

import com.example.atividade01.model.User;
import com.example.atividade01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para criar usuário (apenas admins)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // Outros métodos CRUD conforme necessário
}
