/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

import java.util.Map;

/**
 * 部门树形结构
 * // Alternative format of the node (id & parent are required)
 {
 id          : "string" // required
 parent      : "string" // required
 text        : "string" // node text
 icon        : "string" // string for custom
 state       : {
 opened    : boolean  // is the node open
 disabled  : boolean  // is the node disabled
 selected  : boolean  // is the node selected
 },
 li_attr     : {}  // attributes for the generated LI node
 a_attr      : {}  // attributes for the generated A node
 }
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 12:13 Exp $$
 */
public class DepartmentTreeVO {

    private String id;

    private String parent;

    private String text;

    private String icon;

    private Map<String,String> state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, String> getState() {
        return state;
    }

    public void setState(Map<String, String> state) {
        this.state = state;
    }
}
