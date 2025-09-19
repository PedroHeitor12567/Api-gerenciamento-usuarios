package com.pedroferreira.apisimples.controller;

import com.pedroferreira.apisimples.model.User;
import com.pedroferreira.apisimples.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody User user) {
        User salvo = service.salvar(user);
        String mensagem = "Usuário '" + salvo.getName() + "' salvo com sucesso!";
        return ResponseEntity.status(201).body(mensagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return  ResponseEntity.status(200)
                    .body("Usuário com id " + id + " deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Usuário com id " + id + " não foi encontrado");
        }
    }
}
