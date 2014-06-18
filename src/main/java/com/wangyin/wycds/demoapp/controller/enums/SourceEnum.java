/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 创建来源枚举
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 18:28 Exp $$
 */
public enum SourceEnum {

    /**cdsweb工程创建*/
    CDSWEB_CREATE("cdsweb", "cdsweb工程创建"),

    /**统一登陆系统导入*/
    SSO_CREATE("sso", "统一登陆系统导入");

    // 成员变量
    private String code;
    private String value;

    private SourceEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 根据业务码获得业务类型
     *
     * @param code 业务码
     * @return 业务类型
     */
    public static SourceEnum getEnumByCode(String code) {
        SourceEnum[] values = SourceEnum.values();
        for (SourceEnum operate : values) {
            if (StringUtils.equals(operate.getCode(), code)) {
                return operate;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
