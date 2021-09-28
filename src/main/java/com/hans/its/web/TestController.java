package com.hans.its.web;

import com.hans.its.model.Table1;
import com.hans.its.repository.TestRepository;
import com.hans.its.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("")
    public Flux<Table1> getDto() {
        return testService.getRows();
    }

    @PostMapping("/new")
    public Mono<Object> createDto() {
        return null;
    }
}
