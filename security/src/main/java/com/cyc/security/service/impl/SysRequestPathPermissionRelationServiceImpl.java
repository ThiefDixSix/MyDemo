package com.cyc.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysRequestPathPermissionRelationDao;
import com.cyc.security.entity.SysRequestPathPermissionRelation;
import com.cyc.security.service.SysRequestPathPermissionRelationService;
import org.springframework.stereotype.Service;

/**
 * 路径权限关联表(SysRequestPathPermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:14:25
 */
@Service("sysRequestPathPermissionRelationService")
public class SysRequestPathPermissionRelationServiceImpl extends ServiceImpl<SysRequestPathPermissionRelationDao, SysRequestPathPermissionRelation> implements SysRequestPathPermissionRelationService {

}