//package com.hans.its.service;
//
//import com.hans.its.entity.UserEntity;
//import com.hans.its.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class MemberService {
//    private final MemberRepository memberRepository;
//
//    public Flux<UserEntity> findAll() {
//        return memberRepository.findAll();
//    }
//
//    public Mono<?> signUp(UserEntity userEntity) {
//        return memberRepository.save(userEntity);
//    }
//
////    public Mono<?> signIn(ReqSignInDto req) {
////        Mono<MemberEntity> memberEntity;
////        memberEntity = memberRepository.findByUserId(req.getUserId());
////
////        memberEntity.
////    }
//}
