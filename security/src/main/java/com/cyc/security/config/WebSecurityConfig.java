package com.cyc.security.config;

import com.alibaba.fastjson.JSON;
import com.cyc.security.util.JsonResult;
import com.cyc.security.util.Result;
import com.cyc.security.util.ResultCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/sysUser/getUser")
                .hasAuthority("query_user")
                .and()
                // 未登录时添加这个操作
                .exceptionHandling()
                .authenticationEntryPoint((request,response,e)->{

                    JsonResult result = Result.fail(ResultCode.USER_NOT_LOGIN);
                    response.setContentType("text/json;charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(result));
                })
        .and()
        ;
    }
    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息`
        return new UserDetailsServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

}
