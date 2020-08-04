package com.cyc.security.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cyc.security.entity.SysUser;
import com.cyc.security.service.SysUserService;
import com.cyc.security.util.JsonResult;
import com.cyc.security.util.Result;
import com.cyc.security.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SysUserService sysUserService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/sysUser/getUser")
                .hasAuthority("query_user")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request,response,e)->{

                    JsonResult result = Result.fail(ResultCode.USER_NOT_LOGIN);
                    response.setContentType("text/json;charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(result));
                })
                //登录的方法
                .and()
                .formLogin()
                .permitAll()
                .successHandler((request,response,e)->{
                    //更新用户表上次登录时间、更新人、更新时间等字段
                    User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    SysUser sysUser = sysUserService.getOne(new LambdaQueryWrapper<SysUser>()
                            .eq(SysUser::getUserName,userDetails.getUsername()));
                    sysUser.setLastLoginTime(new Date());
                    sysUser.setUpdateTime(new Date());
                    sysUser.setUpdateUser(sysUser.getId());
                    sysUserService.update(new LambdaUpdateWrapper<SysUser>()
                            .eq(SysUser::getId,sysUser.getId())
                            .set(SysUser::getLastLoginTime,new Date()));

                    //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
                    //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

                    //返回json数据
                    JsonResult result = Result.success();
                    result.setData(sysUser);
                    //处理编码方式，防止中文乱码的情况
                    response.setContentType("text/json;charset=utf-8");
                    //塞到HttpServletResponse中返回给前台
                    response.getWriter().write(JSON.toJSONString(result));

                })
                .failureHandler((request,response,e)->{
                    //返回json数据
                    JsonResult result = null;
                    if (e instanceof AccountExpiredException) {
                        //账号过期
                        result = Result.fail(ResultCode.USER_ACCOUNT_EXPIRED);
                    } else if (e instanceof BadCredentialsException) {
                        //密码错误
                        result = Result.fail(ResultCode.USER_CREDENTIALS_ERROR);
                    } else if (e instanceof CredentialsExpiredException) {
                        //密码过期
                        result = Result.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
                    } else if (e instanceof DisabledException) {
                        //账号不可用
                        result = Result.fail(ResultCode.USER_ACCOUNT_DISABLE);
                    } else if (e instanceof LockedException) {
                        //账号锁定
                        result = Result.fail(ResultCode.USER_ACCOUNT_LOCKED);
                    } else if (e instanceof InternalAuthenticationServiceException) {
                        //用户不存在
                        result = Result.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
                    }else{
                        //其他错误
                        result = Result.fail(ResultCode.COMMON_FAIL);
                    }
                    //处理编码方式，防止中文乱码的情况
                    response.setContentType("text/json;charset=utf-8");
                    //塞到HttpServletResponse中返回给前台
                    response.getWriter().write(JSON.toJSONString(result));

                })
                // 登出的方法

                .and()
                .logout()
                .permitAll()
                .logoutSuccessHandler((request, response, e) -> {

                    JsonResult result = Result.success();
                    response.setContentType("text/json;charset=utf-8");
                    response.getWriter().write(JSON.toJSONString(result));
                })
                //限制登录数量
                .and().sessionManagement().
                maximumSessions(1)
                .expiredSessionStrategy(sessionInformationExpiredEvent -> {
                    JsonResult result = Result.fail(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
                    HttpServletResponse httpServletResponse = sessionInformationExpiredEvent.getResponse();
                    httpServletResponse.setContentType("text/json;charset=utf-8");
                    httpServletResponse.getWriter().write(JSON.toJSONString(result));

                })
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
