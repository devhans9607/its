//package com.hans.its.repository;
//
//import com.hans.its.entity.UserEntity;
//import lombok.AllArgsConstructor;
//import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy;
//import org.springframework.data.r2dbc.core.DatabaseClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.data.r2dbc.query.Criteria.where;
//import static org.springframework.data.relational.core.query.Update.update;
//
//@AllArgsConstructor
//public class UserRepositoryImpl implements CustomUserRepository {
//
//    private final DatabaseClient query;
//    private final ReactiveDataAccessStrategy dataAccessStrategy;
//
//    @Override
//    public Flux<UserEntity> findAllUser() {
//        return query.select()
//                .from("users")
//                .as(UserEntity.class)
//                .fetch()
//                .all();
//    }
//
//    @Override
//    public Flux<UserEntity> findAllUserProjection() {
//        return query.select()
//                .from("users")
//                .as(UserEntity.class)
//                .project("uid", "userid")
//                .fetch()
//                .all();
//    }
//
//    @Override
//    public Mono<UserEntity> createUser(UserEntity user) {
//        return query.insert()
//                .into(UserEntity.class)
//                .using(user)
//                .map(this.dataAccessStrategy.getConverter().populateIdIfNecessary(user))
//                .first()
//                .defaultIfEmpty(user);
//    }
//
//    @Override
//    public Mono<UserEntity> updateUser(UserEntity user) {
//        return query.update()
//                .table(UserEntity.class)
//                .using(user)
//                .then()
//                .then(Mono.just(user));
//    }
//
//    @Override
//    public Mono<UserEntity> updateUserByUntyped(UserEntity user) {
//        return query.update()
//                .table("users")
//                .using(update("userid", user.getUserId()).set("name", user.getName()))
//                .matching(where("uid").is(user.getUid()))
//                .then()
//                .then(Mono.just(user));
//    }
//
//
//    @Override
//    public Mono<Void> removeUser(long uid) {
//        return query.delete()
//                .from(UserEntity.class)
//                .matching(where("uid").is(uid))
//                .then();
//    }
//
//}
