package com.cyc.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 权限表(SysPermission)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:13:58
 */
@SuppressWarnings("serial")
public class SysPermission extends Model<SysPermission> {
    //主键id
    private Integer id;
    //权限code
    private String permissionCode;
    //权限名
    private String permissionName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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