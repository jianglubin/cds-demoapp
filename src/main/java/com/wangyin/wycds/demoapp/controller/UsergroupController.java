/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.GroupService;
import com.wangyin.wycds.demoapp.controller.vo.UsergroupVO;
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
 * 用户群组控制类
 * 
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 9:42 Exp $$
 */
@Controller
public class UsergroupController extends BaseController{
    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "configuration/usergroup";

    @Resource(name = "groupService")
    private GroupService groupService;

    @RequestMapping("/usergroup/show")
    public ModelAndView doGet(ModelMap modelMap) {
        return queryAll(modelMap);
    }

    private ModelAndView queryAll(ModelMap modelMap) {
        List<UsergroupVO> usergroupVOs;
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        paginator.setPage(1);
        usergroupVOs = groupService.getUsergroupList(paginator);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("usergroupVOs", usergroupVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping("/usergroup/add")
    public ModelAndView add(@Valid UsergroupVO usergroupVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        usergroupVO.setCreateBy(getUser(session));
        usergroupVO.setModifiedBy(getUser(session));
        groupService.addUsergroup(usergroupVO);
        modelMap.addAttribute(MESSAGE, "新增角色信息成功!");
        return queryAll(modelMap);
    }

    @RequestMapping("/usergroup/update")
    public ModelAndView update(@Valid UsergroupVO usergroupVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //单独校验id
        if (StringUtils.isBlank(usergroupVO.getUsergroupId())) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        usergroupVO.setModifiedBy(getUser(session));
        groupService.updateUsergroup(usergroupVO);
        usergroupVO = groupService.getUsergroupById(usergroupVO.getUsergroupId());
        modelMap.addAttribute("usergroupVO", usergroupVO);
        modelMap.addAttribute(MESSAGE, "更新角色信息成功!");
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping(value = "/usergroup/showDetail")
    public ModelAndView detail(String id) {
        if (StringUtils.isBlank(id)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        UsergroupVO usergroupVO;
        usergroupVO = groupService.getUsergroupById(id);
        return new ModelAndView(RETURN_PAGE, "usergroupVO", usergroupVO);
    }

    @RequestMapping(value = "/usergroup/delete")
    public ModelAndView delete(String id, HttpSession session) {
        if (StringUtils.isBlank(id)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少角色id!");
        }
        groupService.deleteUsergroup(id, getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }

    @RequestMapping("/usergroup/query")
    public ModelAndView query(UsergroupVO usergroupVO, Integer page, ModelMap modelMap) {
        if (usergroupVO==null) {
            return new ModelAndView(RETURN_PAGE, ERROR, "至少选择一个查询条件!");
        }
        String id=usergroupVO.getUsergroupId();
        String usergroupName=usergroupVO.getUsergroupName();
        List<UsergroupVO> usergroupVOs = new ArrayList<UsergroupVO>();
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        if (StringUtils.isNotBlank(id)) {
            UsergroupVO queryUsergroupVO = groupService.getUsergroupById(id);
            paginator.setPage(1);
            paginator.setItems(1);
            usergroupVOs.add(queryUsergroupVO);
        }else{
            if (page == null) {
                paginator.setPage(1);
            } else {
                paginator.setPage(page);
            }
            usergroupVOs=groupService.getUsergroupListByUsergroupName(usergroupName, paginator);
        }
        modelMap.addAttribute("usergroupVO", usergroupVO);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("usergroupVOs", usergroupVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);

    }
}
