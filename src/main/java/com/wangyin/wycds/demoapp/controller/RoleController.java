/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.RoleService;
import com.wangyin.wycds.demoapp.controller.vo.RoleVO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/19 18:46 Exp $$
 */
@Controller
public class RoleController extends BaseController {

    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "configuration/role";

    @Resource(name = "roleService")
    private RoleService roleService;

    @RequestMapping("/role/show")
    public ModelAndView doGet(ModelMap modelMap) {
        return queryAll(modelMap);
    }

    private ModelAndView queryAll(ModelMap modelMap) {
        List<RoleVO> roleVOs;
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        paginator.setPage(1);
        roleVOs = roleService.getRoleList(paginator);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("roleVOs", roleVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping("/role/add")
    public ModelAndView add(@Valid RoleVO roleVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        roleVO.setCreateBy(getUser(session));
        roleVO.setModifiedBy(getUser(session));
        roleService.addRole(roleVO);
        modelMap.addAttribute(MESSAGE, "新增角色信息成功!");
        return queryAll(modelMap);
    }

    @RequestMapping("/role/update")
    public ModelAndView update(@Valid RoleVO roleVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //单独校验id
        if (StringUtils.isBlank(roleVO.getRoleId())) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        roleVO.setModifiedBy(getUser(session));
        roleService.updateRole(roleVO);
        roleVO = roleService.getRoleById(roleVO.getRoleId());
        modelMap.addAttribute("roleVO", roleVO);
        modelMap.addAttribute(MESSAGE, "更新角色信息成功!");
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping(value = "/role/showDetail")
    public ModelAndView detail(String id) {
        if (StringUtils.isBlank(id)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        RoleVO roleVO;
        roleVO = roleService.getRoleById(id);
        return new ModelAndView(RETURN_PAGE, "roleVO", roleVO);
    }

    @RequestMapping(value = "/role/delete")
    public ModelAndView delete(String id, HttpSession session) {
        if (StringUtils.isBlank(id)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        roleService.deleteRole(id, getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }

    @RequestMapping("/role/query")
    public ModelAndView query(RoleVO roleVO, Integer page, ModelMap modelMap) {
        if (roleVO==null) {
            return new ModelAndView(RETURN_PAGE, ERROR, "至少选择一个查询条件!");
        }
        String id=roleVO.getRoleId();
        String roleName=roleVO.getRoleName();
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        if (StringUtils.isNotBlank(id)) {
            RoleVO queryRoleVO = roleService.getRoleById(id);
            paginator.setPage(1);
            paginator.setItems(1);
            roleVOs.add(queryRoleVO);
        }else{
            if (page == null) {
                paginator.setPage(1);
            } else {
                paginator.setPage(page);
            }
            roleVOs=roleService.getRoleListByRoleName(roleName, paginator);
        }
        modelMap.addAttribute("roleVO", roleVO);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("roleVOs", roleVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);

    }
}
