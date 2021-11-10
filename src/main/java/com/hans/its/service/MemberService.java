package com.hans.its.service;

import com.hans.its.entity.MemberEntity;
import com.hans.its.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Flux<MemberEntity> findAll() {
        return memberRepository.findAll();
    }
}
