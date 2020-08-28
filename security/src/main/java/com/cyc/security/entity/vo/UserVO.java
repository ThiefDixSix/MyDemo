package com.cyc.security.entity.vo;

import com.cyc.security.entity.SysPermission;
import com.cyc.security.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class UserVO extends SysUser {

    //角色名
    private String roleName;
    //角色说明
    private String roleDescription;

    private List<SysPermissionVO> permissionDetails;
}
