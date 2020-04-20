package com.codesityou.examples.r2dbcexample.services;

import com.codesityou.examples.r2dbcexample.models.Post;
import com.codesityou.examples.r2dbcexample.repositories.PostsRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component("PostsService")
public class PostsServiceImpl implements PostsService{

    private final PostsRepository repository;

    public PostsServiceImpl(PostsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Post> create(Post post) {
        //Post result = new Post(UUID.randomUUID(), post.getTitle(), post.getContent(), post.getUserId());
        return repository.save(post);
    }

    @Override
    public Mono<Void> remove(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Post> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Post> findByUser(UUID userId) {
        return repository.findByUserId(userId);
    }
}
