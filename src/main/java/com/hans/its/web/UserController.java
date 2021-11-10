package com.hans.its.web;

import com.hans.its.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Api(tags = {"2. Member"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

//    @ApiImplicitParams({@ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")})
    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/users")
    public Flux<?> findAllUser() {
        // 결과데이터가 여러건인경우 getListResult를 이용해서 결과를 출력한다.
        return userService.findAll();
    }

    //    @GetMapping("users")
//    public Flux<User> findAll() {
//        return userService.findAll();
//    }
//
//    @PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Mono<User> addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }
//
//    @DeleteMapping(value = "users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Mono<Void> deleteUser(@PathVariable Long id) {
//        return userService.deleteUser(id);
//    }
}
