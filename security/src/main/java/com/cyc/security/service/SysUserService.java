package com.cyc.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyc.security.entity.SysUser;
import com.cyc.security.entity.vo.UserVO;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-08-04 16:16:12
 */
public interface SysUserService extends IService<SysUser> {

    UserVO getUserInfo(String userName);
}