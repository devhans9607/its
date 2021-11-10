//package com.hans.its.web;
//
//import com.hans.its.model.Table1;
//import com.hans.its.repository.TestRepository;
//import com.hans.its.service.TestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping(value = "/test")
//@RequiredArgsConstructor
//public class TestController {
//    private final TestService testService;
//
//    @GetMapping("/all")
//    public Flux<Table1> getDto() {
//        return testService.getAllRows();
//    }
//
//    @GetMapping("{id}")
//    public Mono<ResponseEntity<Table1>> getRowById(@PathVariable long id) {
//        return testService.getRowById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//}
