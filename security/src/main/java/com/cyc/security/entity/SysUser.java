package com.cyc.security.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(SysUser)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:15:00
 */
@SuppressWarnings("serial")
public class SysUser extends Model<SysUser> {

    private Integer id;
    //账号
    private String account;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //上一次登录时间
    private Date lastLoginTime;
    //账号是否可用。默认为1（可用）
    private Object enabled;
    //是否过期。默认为1（没有过期）
    private Object notExpired;
    //账号是否锁定。默认为1（没有锁定）
    private Object accountNotLocked;
    //证书（密码）是否过期。默认为1（没有过期）
    private Object credentialsNotExpired;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //创建人
    private Integer createUser;
    //修改人
    private Integer updateUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }

    public Object getNotExpired() {
        return notExpired;
    }

    public void setNotExpired(Object notExpired) {
        this.notExpired = notExpired;
    }

    public Object getAccountNotLocked() {
        return accountNotLocked;
    }

    public void setAccountNotLocked(Object accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    public Object getCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    public void setCredentialsNotExpired(Object credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
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