package com.teamproject.gaxga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class JoinMembershipForm {
    private Long userCode;
    private String gaId;
    private String gaPass;
    private String gaNick;
    private String gaPhone;
    private String gaAddress;
    private String gaDetailAddress;
    private String gaEmail;
    private String gaP_Image;

//    public JoinMembership toEntity(){
//        return new JoinMembership(null, gaId, gaPass, gaNick, gaPhone, gaAddress, gaDetailAddress, gaEmail, gaP_Image);
//    }
}
