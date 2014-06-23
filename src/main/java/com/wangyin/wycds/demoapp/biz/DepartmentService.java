/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.biz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyin.wycds.demoapp.controller.enums.SourceEnum;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentTreeVO;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentVO;
import com.wangyin.wycds.demoapp.dal.datainterface.DepartmentDAO;
import com.wangyin.wycds.demoapp.dal.dataobject.DepartmentDO;
import com.wangyin.wycds.demoapp.util.ConvertUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门业务类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 10:49 Exp $$
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;

    /**
     * 根据部门id获取部门信息
     *
     * @param departmentId
     * @return
     */
    public DepartmentVO getDepartmentById(String departmentId) {
        DepartmentDO departmentDO = departmentDAO.getDepartmentById(departmentId);
        if (departmentDO == null) {
            return null;
        }
        DepartmentVO departmentVO = new DepartmentVO();
        ConvertUtil.copyProperties(departmentDO, departmentVO);
        getDepartmentByParent(departmentVO);
        return departmentVO;
    }

    /**
     * 获取所有部门信息
     *
     * @return
     */
    public DepartmentVO getAllDepartment() {
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setDepartmentId("0");
        departmentVO.setDepartmentName("网银在线");
        departmentVO.setParentId("#");
        departmentVO.setSource(SourceEnum.CDSWEB_CREATE.getCode());
        getDepartmentByParent(departmentVO);
        return departmentVO;
    }

    /**
     * 新增部门信息
     *
     * @param parentId
     * @param departmentName
     * @param createBy
     */
    public void addDepartment(String parentId,String departmentName,String createBy){
        DepartmentDO departmentDO=new DepartmentDO();
        departmentDO.setParentId(parentId);
        departmentDO.setCreateBy(createBy);
        departmentDO.setModifiedBy(createBy);
        departmentDO.setSource(SourceEnum.CDSWEB_CREATE.getCode());
        departmentDO.setDepartmentName(departmentName);
        departmentDAO.insertDepartment(departmentDO);
    }

    /**
     * 更新部门信息
     *
     * @param departmentId
     * @param departmentName
     * @param modifiedBy
     */
    public void updateDepartment(String departmentId,String departmentName,String modifiedBy){
        departmentDAO.updateDepartment(departmentId,departmentName,modifiedBy);
    }

    /**
     * 删除部门信息
     *
     * @param departmentId
     * @param modifiedBy
     */
    public void deleteDepartment(String departmentId,String modifiedBy){
        departmentDAO.deleteDepartment(departmentId,modifiedBy);
    }
    /**
     * 递归获取子部门信息
     *
     * @param parentDepartmentVO
     */
    private void getDepartmentByParent(DepartmentVO parentDepartmentVO) {
        List<DepartmentDO> departmentDOs = departmentDAO.getDepartmentByParentId(parentDepartmentVO.getDepartmentId());
        if (CollectionUtils.isEmpty(departmentDOs)) {
            return;
        }
        List<DepartmentVO> departmentVOs = new ArrayList<DepartmentVO>();
        for (DepartmentDO departmentDO : departmentDOs) {
            DepartmentVO departmentVO = new DepartmentVO();
            ConvertUtil.copyProperties(departmentDO, departmentVO);
            getDepartmentByParent(departmentVO);
            departmentVOs.add(departmentVO);
        }
        parentDepartmentVO.setChildrenDepartmentVOs(departmentVOs);
    }

    /**
     * 获取部门树形结构对象
     *
     * @param departmentVO
     * @return
     */
    public List<DepartmentTreeVO> getDepartmentTreeJson(DepartmentVO departmentVO) {
        List<DepartmentTreeVO> departmentTreeVOs = new ArrayList<DepartmentTreeVO>();
        convert(departmentVO, departmentTreeVOs);
        return departmentTreeVOs;
    }

    /**
     * 把部门对象转换成树形结构在页面展示
     *
     * @param departmentVO
     * @param departmentTreeVOs
     */
    private void convert(DepartmentVO departmentVO, List<DepartmentTreeVO> departmentTreeVOs) {
        DepartmentTreeVO departmentTreeVO = new DepartmentTreeVO();
        departmentTreeVO.setId(departmentVO.getDepartmentId());
        departmentTreeVO.setText(departmentVO.getDepartmentName());
        departmentTreeVO.setParent(departmentVO.getParentId());
        departmentTreeVOs.add(departmentTreeVO);
        if (CollectionUtils.isEmpty(departmentVO.getChildrenDepartmentVOs())) {
            return;
        }
        for (DepartmentVO vo : departmentVO.getChildrenDepartmentVOs()) {
            convert(vo, departmentTreeVOs);
        }
    }
}
