package com.cyc.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysRoleDao;
import com.cyc.security.entity.SysRole;
import com.cyc.security.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:14:42
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

}