/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import com.wangyin.wycds.demoapp.controller.enums.SourceEnum;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 角色视图
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:27 Exp $$
 */
public class RoleVO extends BaseVO{
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色名称
     */
    @NotBlank(message = "角色名不能为空!")
    private String roleName;
    /**
     * 创建来源
     */
    private String source= SourceEnum.CDSWEB_CREATE.getCode();

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
