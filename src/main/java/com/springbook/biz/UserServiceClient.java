package com.springbook.biz;

import com.springbook.biz.user.command.UserVO;
import com.springbook.biz.user.service.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) container.getBean("userService");

        UserVO vo = new UserVO();
        vo.setId("user1");
        vo.setPassword("user1");

        UserVO user = userService.getUser(vo);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다.");
        }
        container.close();
    }
}
