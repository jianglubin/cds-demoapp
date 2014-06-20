/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.wangyin.wycds.demoapp.controller.vo.RoleVO;
import com.wangyin.wycds.demoapp.dal.datainterface.RoleDAO;
import com.wangyin.wycds.demoapp.dal.dataobject.RoleDO;
import com.wangyin.wycds.demoapp.util.ConvertUtil;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 14:53 Exp $$
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    /**
     * 获得角色列表
     *
     * @param paginator
     * @return
     */
    public List<RoleVO> getRoleList(Paginator paginator) {
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        int countNum = roleDAO.getRoleListCount();
        if (countNum == 0) {
            return null;
        }
        paginator.setItems(countNum);
        List<RoleDO> roleDOs = roleDAO.getRoleList(paginator);
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
     * 根据角色名查询角色信息
     *
     * @param roleName
     * @param paginator
     * @return
     */
    public List<RoleVO> getRoleListByRoleName(String roleName, Paginator paginator) {
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        int countNum = roleDAO.getRoleListCount();
        if (countNum == 0) {
            return null;
        }
        paginator.setItems(countNum);
        List<RoleDO> roleDOs = roleDAO.getRoleByRoleName(roleName,paginator.getBeginIndex(), paginator.getItemsPerPage());
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
     * 新增角色
     *
     * @param roleVO
     */
    public void addRole(RoleVO roleVO) {
        RoleDO roleDO = new RoleDO();
        ConvertUtil.copyProperties(roleVO, roleDO);
        roleDAO.insertRole(roleDO);
    }

    /**
     * 更新角色
     *
     * @param roleVO
     */
    public void updateRole(RoleVO roleVO) {
        RoleDO roleDO = new RoleDO();
        ConvertUtil.copyProperties(roleVO, roleDO);
        roleDAO.updateRole(roleDO);
    }

    /**
     * 删除角色
     *
     * @param id
     * @param modifiedBy
     */
    public void deleteRole(String id, String modifiedBy) {
        roleDAO.deleteRole(id, modifiedBy);
    }

    /**
     * 根据角色id查询角色信息
     *
     * @param id
     * @return
     */
    public RoleVO getRoleById(String id) {
        RoleDO roleDO = roleDAO.getRoleById(id);
        RoleVO roleVO = new RoleVO();
        ConvertUtil.copyProperties(roleDO, roleVO);
        return roleVO;
    }
}
