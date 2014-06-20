/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.dal.datainterface;

import com.wangyin.wycds.demoapp.controller.vo.RoleVO;
import com.wangyin.wycds.demoapp.dal.dataobject.RoleDO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色查询接口
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:57 Exp $$
 */
@Repository
@Transactional
public interface RoleDAO {

    /**
     * 获取状态为"未删除"的所有角色信息
     *
     * @param paginator
     * @return
     */
    public List<RoleDO> getRoleList(Paginator paginator);

    /**
     * 获取状态为"未删除"的所有角色信息的总数
     *
     * @return
     */
    public Integer getRoleListCount();

    /**
     * 根据登录名查询角色信息
     *
     * @param id
     * @return
     */
    public RoleDO getRoleById(String id);

    /**
     * 根据角色名查询角色信息
     *
     * @param roleName
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<RoleDO> getRoleByRoleName(@Param("roleName") String roleName, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据角色名查询角色信息总数
     *
     * @param roleName
     * @return
     */
    public Integer getRoleByRoleNameCount(@Param("roleName") String roleName);


    /**
     * 新增一条角色信息
     *
     * @param roleDO
     * @return
     */
    public int insertRole(RoleDO roleDO);

    /**
     * 更新一条角色信息
     * @return
     */
    public int updateRole(RoleDO roleDO);

    /**
     * 删除一条角色信息
     *
     * @param id
     * @param modifiedBy
     */
    public int deleteRole(@Param("id") String id, @Param("modifiedBy") String modifiedBy);

    /**
     * 根据登录名查询用户角色
     *
     * @param loginName
     * @return
     */
    public List<RoleDO> getRoleListByLoginName(String loginName);
}
