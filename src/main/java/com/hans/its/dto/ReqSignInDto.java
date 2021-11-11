package com.hans.its.dto;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
//@ApiModel("로그인 reqSigninDto")
public class ReqSignInDto {

    @NonNull
//    @ApiModelProperty(value = "아이디", required = true)
    private String userId;

    @NonNull
//    @ApiModelProperty(value = "비밀번호", required = true)
    private String userPwd;

}
