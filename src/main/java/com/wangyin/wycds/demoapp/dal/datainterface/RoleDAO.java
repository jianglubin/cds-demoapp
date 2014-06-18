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
 * 权限查询接口
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:57 Exp $$
 */
@Repository
@Transactional
public interface RoleDAO {

    /**
     * 获取状态为"未删除"的所有权限信息
     *
     * @param paginator
     * @return
     */
    public List<RoleDO> getRoleList(Paginator paginator);

    /**
     * 获取状态为"未删除"的所有权限信息的总数
     *
     * @return
     */
    public Integer getRoleListCount();

    /**
     * 根据登录名查询权限信息
     *
     * @param id
     * @return
     */
    public RoleDO getRoleById(String id);

    /**
     * 根据组合条件查询权限信息
     *
     * @param roleVO
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<RoleDO> getRoleByParameters(@Param("roleVO") RoleVO roleVO, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据组合条件查询权限信息总数
     *
     * @param roleVO
     * @return
     */
    public Integer getRoleByParametersCount(@Param("roleVO") RoleVO roleVO);


    /**
     * 新增一条权限信息
     *
     * @param roleDO
     * @return
     */
    public int insertRole(RoleDO roleDO);

    /**
     * 更新一条权限信息
     * @param id
     * @param roleName
     * @param modifiedBy
     * @return
     */
    public int updateRole(@Param("id") String id,@Param("roleName") String roleName, @Param("modifiedBy") String modifiedBy);

    /**
     * 删除一条权限信息
     *
     * @param id
     * @param modifiedBy
     */
    public int deleteRole(@Param("id") String id, @Param("modifiedBy") String modifiedBy);
}
