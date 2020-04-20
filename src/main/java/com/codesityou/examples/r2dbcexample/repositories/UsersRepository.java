package com.codesityou.examples.r2dbcexample.repositories;

import com.codesityou.examples.r2dbcexample.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends ReactiveCrudRepository<User, UUID> {
}
