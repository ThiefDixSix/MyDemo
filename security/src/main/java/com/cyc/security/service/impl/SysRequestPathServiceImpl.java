package com.cyc.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyc.security.dao.SysRequestPathDao;
import com.cyc.security.entity.SysRequestPath;
import com.cyc.security.service.SysRequestPathService;
import org.springframework.stereotype.Service;

/**
 * 请求路径(SysRequestPath)表服务实现类
 *
 * @author makejava
 * @since 2020-08-04 16:14:12
 */
@Service("sysRequestPathService")
public class SysRequestPathServiceImpl extends ServiceImpl<SysRequestPathDao, SysRequestPath> implements SysRequestPathService {

}