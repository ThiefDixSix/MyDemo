package com.cyc.security.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.security.config.CousomUser;
import com.cyc.security.entity.SysPermission;
import com.cyc.security.entity.SysRolePermissionRelation;
import com.cyc.security.entity.SysUser;
import com.cyc.security.entity.SysUserRoleRelation;
import com.cyc.security.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-04 16:15:03
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends ApiController {
    /**
     * 服务对象
     */
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

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param sysUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysUser> page, SysUser sysUser) {
        return success(this.sysUserService.page(page, new QueryWrapper<>(sysUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getUser")
    public R selectOne(@RequestParam("id") Long id) {
        System.out.println(CousomUser.getUserDetails());
        // 查询用户对应的角色信息
        List<Integer> roleIdS = sysUserRoleRelationService.list(new LambdaQueryWrapper<SysUserRoleRelation>()
                .eq(SysUserRoleRelation::getUserId, id))
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
        List<String> sysPermissionNames = new ArrayList<>();
        if (!sysPermissions.isEmpty()){
            sysPermissionNames = sysPermissions.stream().map(SysPermission::getPermissionCode).collect(Collectors.toList());
        }
        SysUser byId = sysUserService.getById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userMsg",byId);
        jsonObject.put("permissions",sysPermissionNames);
        return success(jsonObject);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.save(sysUser));
    }

    /**
     * 修改数据
     *
     * @param sysUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysUser sysUser) {
        return success(this.sysUserService.updateById(sysUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserService.removeByIds(idList));
    }

    /**
     * 根据用户名查询用户所有的相关信息
     * @param userName
     * @return
     */
    @GetMapping("/getUserInfo/{userName}")
    public R getUserInfo(@PathVariable String userName){
        return success(this.sysUserService.getUserInfo(userName));
    }
}