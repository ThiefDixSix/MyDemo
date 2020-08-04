package com.cyc.security.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:15:04
 */
@SuppressWarnings("serial")
public class SysUserRoleRelation extends Model<SysUserRoleRelation> {
    //主键id
    private Integer id;
    //用户id
    private Integer userId;
    //角色id
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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