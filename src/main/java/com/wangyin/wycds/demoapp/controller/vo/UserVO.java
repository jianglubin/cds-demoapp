/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import java.util.List;

/**
 * 用户对象
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 13:06 Exp $$
 */
public class UserVO extends BaseVO{

    /**
     * 登录名
     */
    private String loginName;
    /**
     * 真实姓名
     */
    private String userName;
    /**
     * 登录密码
     */
    private String loginPassword;
    /**
     * 创建来源
     */
    private String source;
    /**
     * 权限列表
     */
    private List<RoleVO> roleVOs;
    /**
     * 用户组列表
     */
    private List<UsergroupVO> usergroupVOs;
    /**
     * 所属部门
     */
    private DepartmentVO departmentVO;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
