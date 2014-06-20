/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import com.wangyin.wycds.demoapp.controller.enums.SourceEnum;

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
    private String usergroupId;
    /**
     * 用户组名称
     */
    private String usergroupName;
    /**
     * 创建来源
     */
    private String source= SourceEnum.CDSWEB_CREATE.getCode();

    public String getUsergroupId() {
        return usergroupId;
    }

    public void setUsergroupId(String usergroupId) {
        this.usergroupId = usergroupId;
    }

    public String getUsergroupName() {
        return usergroupName;
    }

    public void setUsergroupName(String usergroupName) {
        this.usergroupName = usergroupName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
