package com.cyc.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysRolePermissionRelationDao;
import com.cyc.security.entity.SysRolePermissionRelation;
import com.cyc.security.service.SysRolePermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:14:54
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl extends ServiceImpl<SysRolePermissionRelationDao, SysRolePermissionRelation> implements SysRolePermissionRelationService {

}