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
     * 根据用户组名称查询用户组信息
     *
     * @param usergroupName
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<UsergroupDO> getUsergroupByUsergroupName(@Param("usergroupName") String usergroupName, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据用户组名称查询用户组信息总数
     *
     * @param usergroupName
     * @return
     */
    public Integer getUsergroupByUsergroupNameCount(@Param("usergroupName") String usergroupName);


    /**
     * 新增一条用户组信息
     *
     * @param usergroupDO
     * @return
     */
    public int insertUsergroup(UsergroupDO usergroupDO);

    /**
     * 更新一条用户组信息
     * @param usergroupDO
     * @return
     */
    public int updateUsergroup(UsergroupDO usergroupDO);

    /**
     * 删除一条用户组信息
     *
     * @param id
     * @param modifiedBy
     */
    public int deleteUsergroup(@Param("id") String id, @Param("modifiedBy") String modifiedBy);

    /**
     * 根据登录名查询用户组
     *
     * @param loginName
     * @return
     */
    public List<UsergroupDO> getUsergroupListByLoginName(String loginName);
}
