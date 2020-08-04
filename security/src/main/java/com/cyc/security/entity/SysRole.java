package com.cyc.security.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 用户角色表(SysRole)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:14:31
 */
@SuppressWarnings("serial")
public class SysRole extends Model<SysRole> {
    //主键id
    private Integer id;
    //角色名
    private String roleName;
    //角色说明
    private String roleDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
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