package com.teamproject.gaxga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class LoginForm {
    private String gaId;
    private String gaPass;

    public LoginForm toEntity(){
        return new LoginForm(gaId, gaPass);
    }
}
