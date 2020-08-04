package com.cyc.security.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyc.security.entity.SysPermission;
import com.cyc.security.entity.SysRolePermissionRelation;
import com.cyc.security.entity.SysUser;
import com.cyc.security.entity.SysUserRoleRelation;
import com.cyc.security.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userName == null || userName.equals("")){
            throw new RuntimeException("用户名不能为空");
        }
        // 查询用户信息
        SysUser sysUser = sysUserService.getOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUserName,userName)
        );
        if (sysUser == null){
            throw new RuntimeException("用户不存在");
        }
        // 查询用户对应的角色信息
        List<Integer> roleIdS = sysUserRoleRelationService.list(new LambdaQueryWrapper<SysUserRoleRelation>()
                .eq(SysUserRoleRelation::getUserId, sysUser.getId()))
                .stream().map(SysUserRoleRelation::getRoleId)
                .collect(Collectors.toList());
        // 查询角色对应的权限id
        List<Integer> permissionIdS = sysRolePermissionRelationService.list(new LambdaQueryWrapper<SysRolePermissionRelation>()
                .in(SysRolePermissionRelation::getRoleId,roleIdS))
                .stream()
                .map(SysRolePermissionRelation::getPermissionId)
                .collect(Collectors.toList());
        // 查询角色对应的权限信息
        List<SysPermission> sysPermissions = sysPermissionService.list(new LambdaQueryWrapper<SysPermission>()
                .in(SysPermission::getId,permissionIdS));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (!CollectionUtils.isEmpty(sysPermissions)) {
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }

        return new User(sysUser.getUserName(),sysUser.getPassword(),!sysUser.getEnabled().equals(1), !sysUser.getNotExpired().equals(1), !sysUser.getCredentialsNotExpired().equals(1), !sysUser.getAccountNotLocked().equals(1), grantedAuthorities);
    }
}
