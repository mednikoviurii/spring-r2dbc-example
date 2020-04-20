package com.codesityou.examples.r2dbcexample.rest;

import com.codesityou.examples.r2dbcexample.models.User;
import com.codesityou.examples.r2dbcexample.services.UsersService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class UsersHandler {

    private final UsersService service;
    private final MediaType json;

    public UsersHandler(UsersService service){
        this.service = service;
        this.json = MediaType.APPLICATION_JSON;
    }

    public Mono<ServerResponse> create (ServerRequest request){
        Mono<User> body = request.bodyToMono(User.class);
        Mono<User> result = body.flatMap(u -> service.createUser(u));
        return ServerResponse.ok().contentType(json).body(result, User.class);
    }

    public Mono<ServerResponse> find (ServerRequest request){
        UUID id = UUID.fromString(request.pathVariable("userId"));
        Mono<User> result = service.findById(id);
        return ServerResponse.ok().contentType(json).body(result, User.class);
    }

    public Mono<ServerResponse> remove (ServerRequest request){
        UUID id = UUID.fromString(request.pathVariable("userId"));
        Mono<Void> result = service.remove(id);
        return ServerResponse.ok().contentType(json).body(result, Void.class);
    }
}
