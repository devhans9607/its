package com.hans.its.config;

import io.swagger.annotations.ApiOperation;
import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;

//https://github.com/springfox/springfox#migrating-from-earlier-snapshot

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(Optional.class, Flux.class, Mono.class, Publisher.class)
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                .build();
    }
}
