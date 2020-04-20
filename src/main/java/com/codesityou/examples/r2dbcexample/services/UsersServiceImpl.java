package com.codesityou.examples.r2dbcexample.services;

import com.codesityou.examples.r2dbcexample.models.User;
import com.codesityou.examples.r2dbcexample.repositories.UsersRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component("UsersService")
public class UsersServiceImpl implements UsersService{

    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<User> createUser(User user) {
       // User result = new User(UUID.randomUUID(), user.getName());
        return repository.save(user);
    }

    @Override
    public Mono<User> findById(UUID userId) {
        return repository.findById(userId);
    }

    @Override
    public Mono<Void> remove(UUID userId) {
        return repository.deleteById(userId);
    }
}
