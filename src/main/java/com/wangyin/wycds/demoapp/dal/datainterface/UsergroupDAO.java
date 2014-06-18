/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.dal.datainterface;

import com.wangyin.wycds.demoapp.controller.vo.UsergroupVO;
import com.wangyin.wycds.demoapp.dal.dataobject.UsergroupDO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户组查询接口
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:57 Exp $$
 */
@Repository
@Transactional
public interface UsergroupDAO {

    /**
     * 获取状态为"未删除"的所有用户组信息
     *
     * @param paginator
     * @return
     */
    public List<UsergroupDO> getUsergroupList(Paginator paginator);

    /**
     * 获取状态为"未删除"的所有用户组信息的总数
     *
     * @return
     */
    public Integer getUsergroupListCount();

    /**
     * 根据登录名查询用户组信息
     *
     * @param id
     * @return
     */
    public UsergroupDO getUsergroupById(String id);

    /**
     * 根据组合条件查询用户组信息
     *
     * @param usergroupVO
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<UsergroupDO> getUsergroupByParameters(@Param("usergroupVO") UsergroupVO usergroupVO, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据组合条件查询用户组信息总数
     *
     * @param usergroupVO
     * @return
     */
    public Integer getUsergroupByParametersCount(@Param("usergroupVO") UsergroupVO usergroupVO);


    /**
     * 新增一条用户组信息
     *
     * @param usergroupDO
     * @return
     */
    public int insertUsergroup(UsergroupDO usergroupDO);

    /**
     * 更新一条用户组信息
     * @param id
     * @param usergroupName
     * @param modifiedBy
     * @return
     */
    public int updateUsergroup(@Param("id") String id, @Param("usergroupName") String usergroupName, @Param("modifiedBy") String modifiedBy);

    /**
     * 删除一条用户组信息
     *
     * @param id
     * @param modifiedBy
     */
    public int deleteUsergroup(@Param("id") String id, @Param("modifiedBy") String modifiedBy);
}
