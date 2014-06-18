/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.wangyin.wycds.demoapp.controller.vo.RoleVO;
import com.wangyin.wycds.demoapp.dal.datainterface.RoleDAO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 14:53 Exp $$
 */
@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public List<RoleVO> getRoleList(Paginator paginator){
        List<RoleVO> roleVOs=new ArrayList<RoleVO>();
        roleDAO.getRoleList(paginator);
        return roleVOs;
    }

    public Integer getRoleListCount() {
        return roleDAO.getRoleListCount();
    }
}
