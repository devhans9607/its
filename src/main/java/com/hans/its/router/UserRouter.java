package com.hans.its.router;

import com.hans.its.entity.User;
import com.hans.its.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Slf4j
@Configuration
public class UserRouter {

    @Bean
    @RouterOperations(
            {
                    @RouterOperation(
                            path = "/v1/user",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.POST,
                            beanClass = UserHandler.class,
                            beanMethod = "addUser",
                            operation = @Operation(
                                    operationId = "addUser",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = User.class))),
                                    },
                                    requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = User.class))))
                    ),
                    @RouterOperation(
                            path = "/v1/users",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class,
                            beanMethod = "allUsers",
                            operation = @Operation(
                                    operationId = "allusers",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = User.class)))
                                    })
                    ),
                    @RouterOperation(
                            path = "/v1/test",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class,
                            beanMethod = "test",
                            operation = @Operation(
                                    operationId = "test",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = String.class)))
                                    })
                    ),
                    @RouterOperation(
                            path = "/v1/users2",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class,
                            beanMethod = "allUsers2",
                            operation = @Operation(
                                    operationId = "allUsers2",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = User.class)))
                                    })
                    ),
                    @RouterOperation(
                            path = "/v1/user/{uid}",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class,
                            beanMethod = "findByUid",
                            operation = @Operation(
                                    operationId = "findByUid",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = User.class)))
                                    },
                                    parameters = {@Parameter(in = ParameterIn.PATH, name = "uid")})
                    ),
                    @RouterOperation(
                            path = "/v1/user/{uid}",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.DELETE,
                            beanClass = UserHandler.class,
                            beanMethod = "removeUser",
                            operation = @Operation(
                                    operationId = "removeUser",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = Integer.class)))
                                    },
                                    parameters = {@Parameter(in = ParameterIn.PATH, name = "uid")})
                    ),
                    @RouterOperation(
                            path = "/v1/user/name/{name}",
                            produces = {MediaType.APPLICATION_JSON_VALUE},
                            method = RequestMethod.GET,
                            beanClass = UserHandler.class,
                            beanMethod = "queryTest",
                            operation = @Operation(
                                    operationId = "getByName query test",
                                    responses = { @ApiResponse(
                                            responseCode = "200",
                                            description = "suc",
                                            content = @Content(schema = @Schema(implementation = User.class)))
                                    },
                                    parameters = {@Parameter(in = ParameterIn.PATH, name = "name")})
                    )
            }
    )
    RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions
                .route(POST("/v1/user"), userHandler::addUser)
                .andRoute(GET("/v1/test"), userHandler::test)
                .andRoute(GET("/v1/users"), userHandler::allUsers)
                .andRoute(GET("/v1/users2"), userHandler::allUsers2)
                .andRoute(GET("/v1/user/{uid}"), userHandler::findByUid)
                .andRoute(DELETE("/v1/user/{uid}"), userHandler::removeUser)
                .andRoute(GET("/v1/user/name/{name}"), userHandler::queryTest)
                ;
    }
}
