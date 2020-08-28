package com.cyc.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyc.security.entity.SysUser;
import com.cyc.security.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-04 16:15:01
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

    UserVO getUserInfo(@Param("userName") String userName);
}