package com.hans.its.repository;

import com.hans.its.entity.MemberEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MemberRepository extends ReactiveCrudRepository<MemberEntity, Long> {
}
