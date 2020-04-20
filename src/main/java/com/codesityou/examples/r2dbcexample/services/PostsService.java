package com.codesityou.examples.r2dbcexample.services;

import com.codesityou.examples.r2dbcexample.models.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PostsService {

    Mono<Post> create (Post post);

    Mono<Void> remove (UUID id);

    Mono<Post> findById (UUID id);

    Flux<Post> findByUser (UUID userId);
}
