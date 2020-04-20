package com.codesityou.examples.r2dbcexample.rest;

import com.codesityou.examples.r2dbcexample.models.Post;
import com.codesityou.examples.r2dbcexample.services.PostsService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class PostsHandler {

    private final PostsService service;
    private final MediaType json;

    public PostsHandler(PostsService service){
        this.service = service;
        this.json = MediaType.APPLICATION_JSON;
    }

    public Mono<ServerResponse> create (ServerRequest request){
        Mono<Post> body = request.bodyToMono(Post.class);
        Mono<Post> result = body.flatMap(service::create);
        return ServerResponse.ok().contentType(json).body(result, Post.class);
    }

    public Mono<ServerResponse> remove (ServerRequest request){
        UUID id = UUID.fromString(request.pathVariable("id"));
        Mono<Void> result = service.remove(id);
        return ServerResponse.ok().contentType(json).body(result, Void.class);
    }

    public Mono<ServerResponse> findOne (ServerRequest request){
        UUID id = UUID.fromString(request.pathVariable("id"));
        Mono<Post> result = service.findById(id);
        return ServerResponse.ok().contentType(json).body(result, Post.class);
    }

    public Mono<ServerResponse> findForUser (ServerRequest request){
        UUID id = UUID.fromString(request.pathVariable("userId"));
        Flux<Post> result = service.findByUser(id);
        return ServerResponse.ok().contentType(json).body(result, Post.class);
    }
}
