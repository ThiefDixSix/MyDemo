package com.cyc.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyc.security.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyc
 * @since 2020-08-21
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}
