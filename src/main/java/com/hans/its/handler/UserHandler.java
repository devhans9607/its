package com.hans.its.handler;

import com.hans.its.entity.UserEntity;
import com.hans.its.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
@RequiredArgsConstructor
public class UserHandler {

    private final Validator validator;
    private final UserRepository userRepository;

    public Mono<ServerResponse> test(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("testResult"));
    }

    public Mono<ServerResponse> allUsers(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON).body(userRepository.findAll(), UserEntity.class);
    }

    public Mono<ServerResponse> allUsers2(ServerRequest request) {
//        Integer page = request.queryParam("page").isPresent() ? Integer.parseInt(request.queryParam("page").get()) - 1 : 0;
//        Integer size = request.queryParam("pagesize").isPresent() ? Integer.parseInt(request.queryParam("pagesize").get()) : 20;
//        Sort sort = new Sort(Sort.Direction.DESC, "createdAt");
        return Mono.just(userRepository.findAll())
                .flatMap(users -> ok().contentType(APPLICATION_JSON).body(users, UserEntity.class))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> addUser(ServerRequest request) {
        Mono<UserEntity> user = request.bodyToMono(UserEntity.class).doOnNext(this::validate);
        return user.flatMap(userRepository::save)
                .flatMap(entity -> ok().contentType(APPLICATION_JSON).bodyValue(entity));
    }

    private void validate(UserEntity user) {
        Errors errors = new BeanPropertyBindingResult(user, UserEntity.class.getName());
        validator.validate(user, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }

    public Mono<ServerResponse> findByUid(ServerRequest request) {
        int uid = Integer.parseInt(request.pathVariable("uid"));
        return userRepository.findUserEntityByUid(uid)
                .flatMap(user -> ok().contentType(APPLICATION_JSON).bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
