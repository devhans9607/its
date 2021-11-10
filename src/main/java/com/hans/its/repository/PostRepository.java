package com.hans.its.repository;

import com.hans.its.entity.PostEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<PostEntity, Long> {
}
