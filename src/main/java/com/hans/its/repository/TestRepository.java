package com.hans.its.repository;

import com.hans.its.model.Table1;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends ReactiveCrudRepository<Table1, Long> {
}
