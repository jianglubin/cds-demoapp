/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.DepartmentService;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentTreeVO;
import com.wangyin.wycds.demoapp.controller.vo.DepartmentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 10:29 Exp $$
 */
@Controller
public class DepartmentController {
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
}

