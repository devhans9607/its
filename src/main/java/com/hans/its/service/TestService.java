//package com.hans.its.service;
//
//import com.hans.its.model.Table1;
//import com.hans.its.repository.TestRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class TestService {
//
//    private final TestRepository testRepository;
//
//    public Flux<Table1> getAllRows() {
//        Flux<Table1> allRows = testRepository.findAll();
////        List<Table1> blocked = allRows.collectList().block();
////        blocked.forEach(item -> log.info("row : {}", item));
//        return allRows;
//    }
//
//    public Mono<Table1> getRowById(long id) {
//        return testRepository.findById(id);
//    }
//
//    public Mono<Table1> createRow(Table1 table1){
//        return testRepository.save(table1);
//    }
//}
