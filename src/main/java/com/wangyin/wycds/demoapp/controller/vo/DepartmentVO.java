/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import com.wangyin.wycds.demoapp.controller.enums.SourceEnum;

import java.util.List;

/**
 * 部门视图
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 17:11 Exp $$
 */
public class DepartmentVO extends BaseVO{
    /**
     * 部门id
     */
    private String departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 上级部门id
     */
    private String parentId;

    /**
     * 下级部门列表
     */
    List<DepartmentVO> childrenDepartmentVOs;
    /**
     * 创建来源
     */
    private String source= SourceEnum.CDSWEB_CREATE.getCode();

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<DepartmentVO> getChildrenDepartmentVOs() {
        return childrenDepartmentVOs;
    }

    public void setChildrenDepartmentVOs(List<DepartmentVO> childrenDepartmentVOs) {
        this.childrenDepartmentVOs = childrenDepartmentVOs;
    }
}
