package com.springbook.biz.user.command;

import lombok.Data;

@Data
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;
}
