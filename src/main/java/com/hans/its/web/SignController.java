package com.hans.its.web;

import com.hans.its.entity.UserEntity;
import com.hans.its.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@Api(tags = {"3. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class SignController {
    private final UserService userService;

    //    @ApiImplicitParams({@ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")})
//    @ApiOperation(value = "회원 추가", notes = "회원정보를 추가한다")
//    @PostMapping(value = "/user")
//    public Mono<?> signUp(@RequestBody UserEntity userEntity) {
//        return memberService.signUp(userEntity);
//    }
}
