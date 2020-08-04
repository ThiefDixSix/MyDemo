package com.cyc.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysUserRoleRelationDao;
import com.cyc.security.entity.SysUserRoleRelation;
import com.cyc.security.service.SysUserRoleRelationService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:15:11
 */
@Service("sysUserRoleRelationService")
public class SysUserRoleRelationServiceImpl extends ServiceImpl<SysUserRoleRelationDao, SysUserRoleRelation> implements SysUserRoleRelationService {

}