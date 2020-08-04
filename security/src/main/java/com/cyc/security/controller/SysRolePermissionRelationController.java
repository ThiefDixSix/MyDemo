package com.cyc.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.security.entity.SysRolePermissionRelation;
import com.cyc.security.service.SysRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-04 16:14:57
 */
@RestController
@RequestMapping("sysRolePermissionRelation")
public class SysRolePermissionRelationController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    /**
     * 分页查询所有数据
     *
     * @param page                      分页对象
     * @param sysRolePermissionRelation 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysRolePermissionRelation> page, SysRolePermissionRelation sysRolePermissionRelation) {
        return success(this.sysRolePermissionRelationService.page(page, new QueryWrapper<>(sysRolePermissionRelation)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysRolePermissionRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRolePermissionRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysRolePermissionRelation sysRolePermissionRelation) {
        return success(this.sysRolePermissionRelationService.save(sysRolePermissionRelation));
    }

    /**
     * 修改数据
     *
     * @param sysRolePermissionRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysRolePermissionRelation sysRolePermissionRelation) {
        return success(this.sysRolePermissionRelationService.updateById(sysRolePermissionRelation));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRolePermissionRelationService.removeByIds(idList));
    }
}