package com.codesityou.examples.r2dbcexample.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class Router {

    private final MediaType json = MediaType.APPLICATION_JSON;

    @Bean
    public RouterFunction<ServerResponse> postsEndpoint (PostsHandler handler){
        return RouterFunctions.route(POST("/posts").and(accept(json)), handler::create)
                .andRoute(GET("/posts/one/{id}").and(accept(json)), handler::findOne)
                .andRoute(GET("/posts/user/{userId}").and(accept(json)), handler::findForUser)
                .andRoute(DELETE("/posts/{id}").and(accept(json)), handler::remove);
    }

    @Bean
    public RouterFunction<ServerResponse> usersEndpoint (UsersHandler handler){
        return RouterFunctions.route(POST("/users").and(accept(json)), handler::create)
                .andRoute(GET("/users/{userId}").and(accept(json)), handler::find)
                .andRoute(DELETE("/users/{userId}").and(accept(json)), handler::remove);
    }

}
