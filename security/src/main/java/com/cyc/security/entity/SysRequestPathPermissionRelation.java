package com.cyc.security.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 路径权限关联表(SysRequestPathPermissionRelation)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:14:18
 */
@SuppressWarnings("serial")
public class SysRequestPathPermissionRelation extends Model<SysRequestPathPermissionRelation> {
    //主键id
    private Integer id;
    //请求路径id
    private Integer urlId;
    //权限id
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}