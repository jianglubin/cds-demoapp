/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.wangyin.wycds.demoapp.controller.vo.DepartmentVO;
import com.wangyin.wycds.demoapp.controller.vo.RoleVO;
import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.controller.vo.UsergroupVO;
import com.wangyin.wycds.demoapp.dal.datainterface.DepartmentDAO;
import com.wangyin.wycds.demoapp.dal.datainterface.RoleDAO;
import com.wangyin.wycds.demoapp.dal.datainterface.UserDAO;
import com.wangyin.wycds.demoapp.dal.datainterface.UsergroupDAO;
import com.wangyin.wycds.demoapp.dal.dataobject.DepartmentDO;
import com.wangyin.wycds.demoapp.dal.dataobject.RoleDO;
import com.wangyin.wycds.demoapp.dal.dataobject.UserDO;
import com.wangyin.wycds.demoapp.dal.dataobject.UsergroupDO;
import com.wangyin.wycds.demoapp.util.ConvertUtil;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户信息业务管理类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 14:53 Exp $$
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private UsergroupDAO usergroupDAO;

    /**
     * 获取用户基本信息
     *
     * @param paginator
     * @return
     */
    public List<UserVO> getUserList(Paginator paginator) {
        List<UserVO> userVOs = new ArrayList<UserVO>();
        int countNum=userDAO.getUserListCount();
        if(countNum==0){
            return  null;
        }
        paginator.setItems(countNum);
        List<UserDO> userDOs = userDAO.getUserList(paginator);
        if (CollectionUtils.isEmpty(userDOs)) {
            return null;
        }
        for (UserDO userDO : userDOs) {
            UserVO userVO = new UserVO();
            String loginName = userDO.getLoginName();
            ConvertUtil.copyProperties(userDO, userVO);
            userVO.setRoleVOs(getRoleList(loginName));
            userVO.setUsergroupVOs(getUsergroupList(loginName));
            userVO.setDepartmentVO(getDepartment(loginName));
            userVOs.add(userVO);
        }
        return userVOs;
    }

    /**
     * 获取用户所有的权限
     *
     * @param loginName
     * @return
     */
    private List<RoleVO> getRoleList(String loginName) {
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        List<RoleDO> roleDOs = roleDAO.getRoleListByLoginName(loginName);
        if (CollectionUtils.isEmpty(roleDOs)) {
            return null;
        }
        for (RoleDO roleDO : roleDOs) {
            RoleVO roleVO = new RoleVO();
            ConvertUtil.copyProperties(roleDO, roleVO);
            roleVOs.add(roleVO);
        }
        return roleVOs;
    }

    /**
     * 获取用户所有的用户组
     *
     * @param loginName
     * @return
     */
    private List<UsergroupVO> getUsergroupList(String loginName) {
        List<UsergroupVO> usergroupVOs = new ArrayList<UsergroupVO>();
        List<UsergroupDO> usergroupDOs = usergroupDAO.getUsergroupListByLoginName(loginName);
        if (CollectionUtils.isEmpty(usergroupDOs)) {
            return null;
        }
        for (UsergroupDO usergroupDO : usergroupDOs) {
            UsergroupVO usergroupVO = new UsergroupVO();
            ConvertUtil.copyProperties(usergroupDO, usergroupVO);
            usergroupVOs.add(usergroupVO);
        }
        return usergroupVOs;
    }

    /**
     * 根据用户登录名查询部门
     * @param loginName
     * @return
     */
    private DepartmentVO getDepartment(String loginName) {
        DepartmentDO departmentDO = departmentDAO.getDepartmentListByLoginName(loginName);
        if (departmentDO==null) {
            return null;
        }
        DepartmentVO departmentVO=new DepartmentVO();
        ConvertUtil.copyProperties(departmentDO,departmentVO);
        return departmentVO;
    }

    /**
     * 新增用户信息
     * @param userVO
     */
    public void addUser(UserVO userVO) {
        UserDO userDO = new UserDO();
        ConvertUtil.copyProperties(userVO, userDO);
        userDAO.insertUser(userDO);
    }

    /**
     * 更新用户信息
     * @param userVO
     */
    public void updateUser(UserVO userVO) {
        UserDO userDO = new UserDO();
        ConvertUtil.copyProperties(userVO, userDO);
        userDAO.updateUser(userDO);
    }

    /**
     * 删除用户信息
     * @param loginName
     * @param modifiedBy
     */
    public void deleteUser(String loginName, String modifiedBy) {
        userDAO.deleteUser(loginName, modifiedBy);
    }

    /**
     * 根据登陆名查询用户信息
     * @param loginName
     * @return
     */
    public UserVO getUserByLoginName(String loginName) {
        UserDO userDO = userDAO.getUserByLoginName(loginName);
        UserVO userVO = new UserVO();
        ConvertUtil.copyProperties(userDO, userVO);
        return userVO;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @param paginator
     * @return
     */
    public List<UserVO> getUserByUserName(String userName,Paginator paginator){
        List<UserVO> userVOs = new ArrayList<UserVO>();
        int countNum=userDAO.getUserByUserNameCount(userName);
        if(countNum==0){
            return  null;
        }
        paginator.setItems(countNum);
        List<UserDO> userDOs= userDAO.getUserByUserName(userName, paginator.getBeginIndex(), paginator.getItemsPerPage());
        for (UserDO userDO : userDOs) {
            UserVO userVO = new UserVO();
            String loginName = userDO.getLoginName();
            ConvertUtil.copyProperties(userDO, userVO);
            userVO.setRoleVOs(getRoleList(loginName));
            userVO.setUsergroupVOs(getUsergroupList(loginName));
            userVO.setDepartmentVO(getDepartment(loginName));
            userVOs.add(userVO);
        }
        return userVOs;
    }

}
