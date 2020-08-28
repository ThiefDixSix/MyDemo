package com.cyc.security.entity.vo;

import com.cyc.security.entity.SysPermission;
import com.cyc.security.entity.SysRequestPath;
import lombok.Data;

import java.util.List;

@Data
public class SysPermissionVO extends SysPermission {
    private List<SysRequestPath> urlDetails;
}
