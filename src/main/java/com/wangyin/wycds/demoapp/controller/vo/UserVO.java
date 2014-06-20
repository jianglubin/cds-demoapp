/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import com.wangyin.wycds.demoapp.controller.enums.SourceEnum;
import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank(message = "登录名不能为空!")
    private String loginName;
    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空!")
    private String userName;
    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空!")
    private String loginPassword;
    /**
     * 创建来源
     */
    private String source= SourceEnum.CDSWEB_CREATE.getCode();
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

    public List<RoleVO> getRoleVOs() {
        return roleVOs;
    }

    public void setRoleVOs(List<RoleVO> roleVOs) {
        this.roleVOs = roleVOs;
    }

    public List<UsergroupVO> getUsergroupVOs() {
        return usergroupVOs;
    }

    public void setUsergroupVOs(List<UsergroupVO> usergroupVOs) {
        this.usergroupVOs = usergroupVOs;
    }

    public DepartmentVO getDepartmentVO() {
        return departmentVO;
    }

    public void setDepartmentVO(DepartmentVO departmentVO) {
        this.departmentVO = departmentVO;
    }
}
