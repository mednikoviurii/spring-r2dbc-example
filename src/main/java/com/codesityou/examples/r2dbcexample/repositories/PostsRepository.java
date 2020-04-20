package com.codesityou.examples.r2dbcexample.repositories;

import com.codesityou.examples.r2dbcexample.models.Post;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PostsRepository extends ReactiveCrudRepository<Post, UUID> {

    @Query("SELECT * FROM posts WHERE user_id = :userId")
    Flux<Post> findByUserId (UUID userId);

}
