package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("findByUsername: "+ userRepository.findByGaId("asdf")+" ==존재하는지 확인" + userRepository.existsByGaId("asdf"));
        log.info("============username1 : " + username);

        User userData = userRepository.findByGaId(username);
        log.info("============username2 : " + userData.getGaId());
        if (userData != null) {
            return new UserDetail(userData);
        }

        return null;
    }
}
