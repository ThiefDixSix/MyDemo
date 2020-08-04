package com.cyc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * 获取用户登录信息的类
 */
@Component
public class CousomUser {
    public static User getUserDetails(){
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
}
