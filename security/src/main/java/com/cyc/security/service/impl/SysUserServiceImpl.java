package com.cyc.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysUserDao;
import com.cyc.security.entity.SysUser;
import com.cyc.security.entity.vo.UserVO;
import com.cyc.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:15:03
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public UserVO getUserInfo(String userName) {
        return sysUserDao.getUserInfo(userName);
    }
}