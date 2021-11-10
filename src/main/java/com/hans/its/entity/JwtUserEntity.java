//package com.hans.its.entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.google.gson.Gson;
//import com.hans.restboard.util.ObjMapperUtils;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Data
//@NoArgsConstructor
//public class JwtUserEntity implements UserDetails {
//
//    private Integer sub;
//    private String name;
//
//    private List<String> roles;
//
//    private Date iat;
//    private Date exp;
//
//    private SimpleGrantedAuthority authorities = null;
//
//    public JwtUserEntity(MemberEntity memberEntity){
//        Date now = new Date();
//        this.sub = memberEntity.getUid();
//        this.name = memberEntity.getName();
//        this.roles = memberEntity.getRoles();
//        this.iat = now;
//        this.exp = new Date(now.getTime() + 1000L * 60 * 60);
//    }
//
//    public Claims toClaims(){
////        Claims claims = Jwts.claims().setSubject(this.sub.toString());
////        claims.put("roles", this.roles);
////        claims.put("name", this.name);
////        claims.setIssuedAt(this.iat);
////        claims.setExpiration(this.exp);
////        return claims;
//        Claims claims = Jwts.claims();
//        Map<String, Object> map = ObjMapperUtils.getObjMapper().convertValue(this, Map.class);
//        map.forEach((s, o)->{
//            claims.put(s, o);
//        });
//        return claims;
//    }
//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //roles.add(Role.MEMBER.toString()); //기본 강제로 멤버 권한 부여
//        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public boolean isValid(){
//        return !this.exp.before(new Date());
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    public String getUsername() {
//        return null;
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
//
//
//
//    @Override
//    public String toString(){
//        Gson gson = new Gson();
//        return gson.toJson(this);
//    }
//}
