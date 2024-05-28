package com.teamproject.gaxga.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class UserDetail implements UserDetails {

    private User user;
    public UserDetail(User user) {
        this.user = user;
        log.info("=========1" + user.getGaP_Image());
    }
    public String getGaPImage(){
        log.info("=========2" + user.getGaP_Image());
        return user.getGaP_Image();
    }

    public String getGaNick(){
        return user.getGaNick();
    }
    public String getGaPhone(){
        return user.getGaPhone();
    }
    // todo : 이메일 변경시 @뒷주소 어떻게할지 얘기 필요
    public String getGaEmail(){
        return user.getGaEmail();
    }
    // todo : 주소 변경시 디테일 주소등 어떻게 할지 얘기 필요
    public String getGaAddress(){
        return user.getGaAddress();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getGaPass();
    }

    @Override
    public String getUsername() {
        return user.getGaId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}