package com.pedroferreira.apisimples.service;

import com.pedroferreira.apisimples.model.User;
import com.pedroferreira.apisimples.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listar() {
        return repository.findAll();
    }

    public Optional<User> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public User salvar(User user) {
        return repository.save(user);
    }

    @Transactional
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Usuário não encontrado com id: " + id);
        }
    }
}
