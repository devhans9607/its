package com.hans.its.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Builder
@Getter
@AllArgsConstructor
// entity's cons should be protected
// https://velog.io/@gillog/Entity-DTO-VO-%EB%B0%94%EB%A1%9C-%EC%95%8C%EA%B8%B0
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// same to anounce @Table(name="?") + @Entity
@Table("users")
public class MemberEntity {
    @Id
    @Column("uid")
    private Integer uid;

    @Column("userid")
    private String userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column("pwd")
    private String userPwd;
    @Column("name")
    private String name; //name 수저ㅏ
    //isEnabled 칼럼 있을 시 overriding 불필
    private Boolean valid;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //roles.add(Role.MEMBER.toString()); //기본 강제로 멤버 권한 부여
//        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
//    @Override
////    @JsonIgnore
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public String getPassword() {
//        return this.userPwd;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public String getUsername() {
//        return this.userId;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public boolean isEnabled() {
//        return true;
//    }
}