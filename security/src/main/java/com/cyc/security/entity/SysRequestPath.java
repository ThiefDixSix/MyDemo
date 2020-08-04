package com.cyc.security.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * 请求路径(SysRequestPath)表实体类
 *
 * @author makejava
 * @since 2020-08-04 16:14:03
 */
@SuppressWarnings("serial")
public class SysRequestPath extends Model<SysRequestPath> {
    //主键id 
    private Integer id;
    // 请求路径 
    private String url;
    // 路径描述 
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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