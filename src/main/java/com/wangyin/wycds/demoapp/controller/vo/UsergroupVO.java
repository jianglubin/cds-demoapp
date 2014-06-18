/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

/**
 * 用户组视图
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 16:27 Exp $$
 */
public class UsergroupVO extends BaseVO{
    /**
     * 用户组id
     */
    private String roleId;
    /**
     * 用户组名称
     */
    private String roleName;
    /**
     * 创建来源
     */
    private String source;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
