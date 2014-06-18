/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller.vo;

/**
 * 页面视图基础类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 16:25 Exp $$
 */
public class BaseVO {
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private String creationDate;
    /**
     * 最后修改人
     */
    private String modifiedBy;
    /**
     * 最后修改时间
     */
    private String modificationDate;
    /**
     * 删除状态(true已删除,false未删除)
     */
    private String deleteStatus;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseVO{");
        sb.append("createBy='").append(createBy).append('\'');
        sb.append(", creationDate='").append(creationDate).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", modificationDate='").append(modificationDate).append('\'');
        sb.append(", deleteStatus='").append(deleteStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
