package com.codesityou.examples.r2dbcexample.services;

import com.codesityou.examples.r2dbcexample.models.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UsersService {

    Mono<User> createUser (User user);

    Mono<User> findById (UUID userId);

    Mono<Void> remove (UUID userId);

}
