/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.dal.datainterface;

import com.wangyin.wycds.demoapp.controller.vo.DepartmentVO;
import com.wangyin.wycds.demoapp.dal.dataobject.DepartmentDO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限查询接口
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:37 Exp $$
 */
@Repository
@Transactional
public interface DepartmentDAO {

    /**
     * 获取状态为"未删除"的所有权限信息
     *
     * @param paginator
     * @return
     */
    public List<DepartmentDO> getDepartmentList(Paginator paginator);

    /**
     * 获取状态为"未删除"的所有权限信息的总数
     *
     * @return
     */
    public Integer getDepartmentListCount();

    /**
     * 根据登录名查询权限信息
     *
     * @param id
     * @return
     */
    public DepartmentDO getDepartmentById(String id);

    /**
     * 根据组合条件查询权限信息
     *
     * @param departmentVO
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<DepartmentDO> getDepartmentByParameters(@Param("departmentVO") DepartmentVO departmentVO, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据组合条件查询权限信息总数
     *
     * @param departmentVO
     * @return
     */
    public Integer getDepartmentByParametersCount(@Param("departmentVO") DepartmentVO departmentVO);


    /**
     * 新增一条权限信息
     *
     * @param departmentDO
     * @return
     */
    public int insertDepartment(DepartmentDO departmentDO);

    /**
     * 更新一条权限信息
     * @param id
     * @param departmentName
     * @param modifiedBy
     * @return
     */
    public int updateDepartment(@Param("id") String id, @Param("departmentName") String departmentName, @Param("modifiedBy") String modifiedBy);

    /**
     * 删除一条权限信息
     *
     * @param id
     * @param modifiedBy
     */
    public int deleteDepartment(@Param("id") String id, @Param("modifiedBy") String modifiedBy);
}
