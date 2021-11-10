package com.hans.its.router;

import com.hans.its.entity.UserEntity;
import com.hans.its.handler.UserHandler;
import com.hans.its.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Component
public class UserRouter {

//    private final UserHandler userHandler;

//    @Bean
//    @RouterOperation(
//            path = "/test",
//            produces = {MediaType.APPLICATION_JSON_VALUE},
//            beanClass = UserHandler.class,
//            method = RequestMethod.GET,
//            beanMethod = "test",
//            operation = @Operation(operationId = "test", responses = {
//                    @ApiResponse(responseCode = "200", description = "suc",
//                            content = @Content(schema = @Schema(implementation = String.class)))}
//            ))
//    public RouterFunction<ServerResponse> route2(UserHandler userHandler) {
//        return RouterFunctions
//                .route(
//                        GET("/test")
//                                .and(accept(MediaType.APPLICATION_JSON)), userHandler::test
//                );
//    }
//
//    @Bean
//    @RouterOperation(
//            path = "/users",
//            produces = {MediaType.APPLICATION_JSON_VALUE},
//            beanClass = UserHandler.class,
//            method = RequestMethod.GET,
//            beanMethod = "allUsers",
//            operation = @Operation(operationId = "allUsers", responses = {
//                    @ApiResponse(responseCode = "200", description = "suc",
//                            content = @Content(schema = @Schema(implementation = UserEntity.class)))}
//            ))
//    public RouterFunction<ServerResponse> route3(UserHandler userHandler) {
//        return RouterFunctions
//                .route(
//                        GET("/users")
//                                .and(accept(MediaType.APPLICATION_JSON)), userHandler::allUsers
//                );
//    }

//    @Bean
//    @RouterOperation(
//            path = "/users",
//            produces = {MediaType.APPLICATION_JSON_VALUE},
//            beanClass = UserHandler.class,
//            method = RequestMethod.GET,
//            beanMethod = "users get all",
//            operation = @Operation(operationId = "get all opId", responses = {
//                    @ApiResponse(responseCode = "200", description = "succ",
//                            content = @Content(schema = @Schema(implementation = UserEntity.class)))}
//            ))
//    public RouterFunction<ServerResponse> allUsers(UserHandler userHandler) {
//        return RouterFunctions
//                .route(
//                        GET("/users")
//                                .and(accept(MediaType.APPLICATION_JSON)), userHandler::allUsers
//                );
//    }

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(path = "/v1/users"
                    ,produces = {MediaType.APPLICATION_JSON_VALUE},
                    method = RequestMethod.GET,
                    beanClass = UserHandler.class, beanMethod = "allUsers",
                    operation = @Operation(operationId = "allusers", responses = {
                            @ApiResponse(responseCode = "200", description = "suc", content = @Content(schema = @Schema(implementation = UserEntity.class)))
                    })),
                    @RouterOperation(path = "/v1/test"
                            ,produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class, beanMethod = "test",
                            operation = @Operation(operationId = "test", responses = {
                                    @ApiResponse(responseCode = "200", description = "suc", content = @Content(schema = @Schema(implementation = String.class)))
                            }))
            }
    )
    RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions
//                .route(POST("/user"), userHandler::addUser)
                .route(GET("/v1/test"), userHandler::test)
                .andRoute(GET("/v1/users"), userHandler::allUsers);
    }



//        .path("/router", b1 -> b1
//                .nest(accept(APPLICATION_JSON), b2 -> b2
//                        .GET("/users", userHandler::allUsers)
//                        .POST("/user", userHandler::addUser)
//                        .GET("/test", userHandler::test))
//                )
//        .build();
}
