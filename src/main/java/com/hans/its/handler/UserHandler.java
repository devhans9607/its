package com.hans.its.handler;

import com.hans.its.entity.UserEntity;
import com.hans.its.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserRepository userRepository;

    public Mono<ServerResponse> test(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("testResult"));
    }

    public Mono<ServerResponse> allUsers(ServerRequest request) {
        Flux<UserEntity> users = userRepository.findAll();
        return ok().contentType(APPLICATION_JSON).body(users, UserEntity.class);
    }

//    public Mono<ServerResponse> addUser(ServerRequest request) {
//        Mono<UserEntity> user = request.bodyToMono(UserEntity.class);
//        return ok().build((BiFunction<ServerWebExchange, ServerResponse.Context, Mono<Void>>) userRepository.saveUser(user));
//    }
}
