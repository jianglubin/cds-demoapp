/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.dal.datainterface;

import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.dal.dataobject.UserDO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户查询接口
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:57 Exp $$
 */
@Repository
@Transactional
public interface UserDAO {

    /**
     * 获取状态为"未删除"的所有用户信息
     *
     * @param paginator
     * @return
     */
    public List<UserDO> getUserList(Paginator paginator);

    /**
     * 获取状态为"未删除"的所有用户信息的总数
     *
     * @return
     */
    public Integer getUserListCount();

    /**
     * 根据登录名查询用户信息
     *
     * @param loginName
     * @return
     */
    public UserDO getUserByLoginName(String loginName);

    /**
     * 根据用户名称模糊查询用户信息
     *
     * @param userName
     * @param beginIndex
     * @param itemsPerPage
     * @return
     */
    public List<UserDO> getUserByUserName(@Param("userName") String userName, @Param("beginIndex") Integer beginIndex, @Param("itemsPerPage") Integer itemsPerPage);

    /**
     * 根据用户名称模糊查询用户信息总数
     *
     * @param userName
     * @return
     */
    public Integer getUserByUserNameCount(@Param("userName") String userName);


    /**
     * 新增一条用户信息
     *
     * @param userDO
     * @return
     */
    public int insertUser(UserDO userDO);

    /**
     * 更新一条用户信息
     *
     * @param userDO
     * @return
     */
    public int updateUser(UserDO userDO);

    /**
     * 删除一条用户信息
     *
     * @param loginName
     * @param modifiedBy
     */
    public int deleteUser(@Param("loginName") String loginName, @Param("modifiedBy") String modifiedBy);
}
