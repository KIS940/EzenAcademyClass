package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindInfoService {

    @Autowired
    private UserRepository userRepository;

    public User findUserInfo(String Nickname, String PhoneNum){
        User user = userRepository.findByGaNickAndGaPhone(Nickname, PhoneNum);
        if(user == null){
            System.out.println("회원정보가 없습니다.");
            return null;
        }else{
            System.out.println("회원정보 ID : " + user.getGaId());
            return user;
        }
    }

}
