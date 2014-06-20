/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.wangyin.wycds.demoapp.controller.vo.UsergroupVO;
import com.wangyin.wycds.demoapp.dal.datainterface.UsergroupDAO;
import com.wangyin.wycds.demoapp.dal.dataobject.UsergroupDO;
import com.wangyin.wycds.demoapp.util.ConvertUtil;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户群组管理
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 9:33 Exp $$
 */
@Service
public class GroupService {
    @Autowired
    private UsergroupDAO usergroupDAO;

    /**
     * 获得用户组列表
     *
     * @param paginator
     * @return
     */
    public List<UsergroupVO> getUsergroupList(Paginator paginator) {
        List<UsergroupVO> usergroupVOs = new ArrayList<UsergroupVO>();
        int countNum = usergroupDAO.getUsergroupListCount();
        if (countNum == 0) {
            return null;
        }
        paginator.setItems(countNum);
        List<UsergroupDO> usergroupDOs = usergroupDAO.getUsergroupList(paginator);
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
     * 根据用户组名查询用户组信息
     *
     * @param usergroupName
     * @param paginator
     * @return
     */
    public List<UsergroupVO> getUsergroupListByUsergroupName(String usergroupName, Paginator paginator) {
        List<UsergroupVO> usergroupVOs = new ArrayList<UsergroupVO>();
        int countNum = usergroupDAO.getUsergroupListCount();
        if (countNum == 0) {
            return null;
        }
        paginator.setItems(countNum);
        List<UsergroupDO> usergroupDOs = usergroupDAO.getUsergroupByUsergroupName(usergroupName,paginator.getBeginIndex(), paginator.getItemsPerPage());
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
     * 新增用户组
     *
     * @param usergroupVO
     */
    public void addUsergroup(UsergroupVO usergroupVO) {
        UsergroupDO usergroupDO = new UsergroupDO();
        ConvertUtil.copyProperties(usergroupVO, usergroupDO);
        usergroupDAO.insertUsergroup(usergroupDO);
    }

    /**
     * 更新用户组
     *
     * @param usergroupVO
     */
    public void updateUsergroup(UsergroupVO usergroupVO) {
        UsergroupDO usergroupDO = new UsergroupDO();
        ConvertUtil.copyProperties(usergroupVO, usergroupDO);
        usergroupDAO.updateUsergroup(usergroupDO);
    }

    /**
     * 删除用户组
     *
     * @param id
     * @param modifiedBy
     */
    public void deleteUsergroup(String id, String modifiedBy) {
        usergroupDAO.deleteUsergroup(id, modifiedBy);
    }

    /**
     * 根据用户组id查询用户组信息
     *
     * @param id
     * @return
     */
    public UsergroupVO getUsergroupById(String id) {
        UsergroupDO usergroupDO = usergroupDAO.getUsergroupById(id);
        UsergroupVO usergroupVO = new UsergroupVO();
        ConvertUtil.copyProperties(usergroupDO, usergroupVO);
        return usergroupVO;
    }
}
