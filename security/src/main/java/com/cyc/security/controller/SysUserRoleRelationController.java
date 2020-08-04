package com.cyc.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.security.entity.SysUserRoleRelation;
import com.cyc.security.service.SysUserRoleRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户角色关联关系表(SysUserRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-04 16:15:14
 */
@RestController
@RequestMapping("sysUserRoleRelation")
public class SysUserRoleRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                分页对象
     * @param sysUserRoleRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysUserRoleRelation> page, SysUserRoleRelation sysUserRoleRelation) {
        return success(this.sysUserRoleRelationService.page(page, new QueryWrapper<>(sysUserRoleRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysUserRoleRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserRoleRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysUserRoleRelation sysUserRoleRelation) {
        return success(this.sysUserRoleRelationService.save(sysUserRoleRelation));
    }

    /**
     * 修改数据
     *
     * @param sysUserRoleRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysUserRoleRelation sysUserRoleRelation) {
        return success(this.sysUserRoleRelationService.updateById(sysUserRoleRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserRoleRelationService.removeByIds(idList));
    }
}