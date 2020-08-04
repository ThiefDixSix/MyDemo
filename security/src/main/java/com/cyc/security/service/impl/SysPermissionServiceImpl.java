package com.cyc.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysPermissionDao;
import com.cyc.security.entity.SysPermission;
import com.cyc.security.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限表(SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:14:01
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermission> implements SysPermissionService {

}