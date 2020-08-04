package com.cyc.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:14:48
 */
@SuppressWarnings("serial")
public class SysRolePermissionRelation extends Model<SysRolePermissionRelation> {
    //主键id 
    private Integer id;
    //角色id
    private Integer roleId;
    //权限id
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}