/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.dal.datainterface.UserDAO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<UserVO> getUserList(Paginator paginator){
        List<UserVO> userVOs=new ArrayList<UserVO>();
        userDAO.getUserList(paginator);
        return userVOs;
    }

    public Integer getUserListCount() {
        return userDAO.getUserListCount();
    }
}
