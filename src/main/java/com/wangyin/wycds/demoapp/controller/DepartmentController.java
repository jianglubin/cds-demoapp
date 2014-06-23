/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.DepartmentService;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentTreeVO;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 部门控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 10:29 Exp $$
 */
@Controller
public class DepartmentController extends BaseController{
    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "configuration/department";

    @Resource(name = "departmentService")
    DepartmentService departmentService;

    @RequestMapping("/department/show")
    public ModelAndView doGet(ModelMap modelMap) {
        return queryAll(modelMap);
    }

    private ModelAndView queryAll(ModelMap modelMap) {
        DepartmentVO departmentVO = departmentService.getAllDepartment();
        List<DepartmentTreeVO> departmentTreeVO = departmentService.getDepartmentTreeJson(departmentVO);
        modelMap.addAttribute("data", departmentTreeVO);
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping("/department/showJson")
    public @ResponseBody List<DepartmentTreeVO> getShopInJSON() {
       DepartmentVO departmentVO = departmentService.getAllDepartment();
       List<DepartmentTreeVO> departmentTreeVO = departmentService.getDepartmentTreeJson(departmentVO);
       return departmentTreeVO;
    }

    @RequestMapping("/department/add/{parentId}/{departmentName}")
    public ModelAndView add(@PathVariable String parentId,@PathVariable String departmentName, HttpSession session){
        if(StringUtils.isBlank(parentId)||StringUtils.isBlank(departmentName)){
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少上级部门id或部门名称!");
        }
        departmentService.addDepartment(parentId,departmentName,getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }

    @RequestMapping("/department/update/{departmentId}/{departmentName}")
    public ModelAndView update(@PathVariable String departmentId,@PathVariable String departmentName, HttpSession session){
        if(StringUtils.isBlank(departmentId)||StringUtils.isBlank(departmentName)){
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少部门id或部门名称!");
        }
        departmentService.updateDepartment(departmentId,departmentName,getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }

    @RequestMapping("/department/delete/{departmentId}")
    public ModelAndView update(@PathVariable String departmentId, HttpSession session){
        if(StringUtils.isBlank(departmentId)){
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少部门id!");
        }
        departmentService.deleteDepartment(departmentId,getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }
}

