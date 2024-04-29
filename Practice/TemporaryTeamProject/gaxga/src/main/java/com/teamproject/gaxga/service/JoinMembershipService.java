package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JoinMembershipService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    public boolean joinPutData(JoinMembershipForm joinMembershipForm) {

        // todo : 회원가입시 특수문자 방지
        boolean isUser = userRepository.existsByGaId(joinMembershipForm.getGaId());
        if (isUser) {
            return false;
        }
        User data = new User();

        data.setGaId(joinMembershipForm.getGaId());
        data.setGaPass(bCryptPasswordEncoder.encode(joinMembershipForm.getGaPass()));
        data.setGaNick(joinMembershipForm.getGaNick());
        data.setGaPhone(joinMembershipForm.getGaPhone());
        data.setGaAddress(joinMembershipForm.getGaAddress());
        data.setGaDetailAddress(joinMembershipForm.getGaDetailAddress());
        data.setGaEmail(joinMembershipForm.getGaEmail());
        // todo : 나중에 프로필이미지 디폴트로 넣기
        data.setGaP_Image(joinMembershipForm.getGaP_Image());
        userRepository.save(data);
        return true;
    }

    public JoinMembershipForm findUserInfo() {
        User data = userRepository.findByGaId();
        List<JoinMembershipForm> userInfoList = new ArrayList<>();
    }
}
