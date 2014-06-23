/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.UserService;
import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 13:46 Exp $$
 */
@Controller
public class UserController extends BaseController {

    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "configuration/user";

    /**
     * 返回页面
     */
    private static final String RETURN_LIST_PAGE = "module/user_list";
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/user/show")
    public ModelAndView doGet(ModelMap modelMap) {
        return queryAll(modelMap,RETURN_PAGE);
    }

    @RequestMapping("/userList/query/{departmentId}")
    public ModelAndView doListGet(@PathVariable String departmentId,Integer page,ModelMap modelMap) {
        if (StringUtils.isBlank(departmentId)) {
            return new ModelAndView(RETURN_LIST_PAGE, ERROR, "缺少部门id!");
        }
        List<UserVO> userVOs;
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        if (page == null) {
            paginator.setPage(1);
        } else {
            paginator.setPage(page);
        }
        userVOs = userService.getUserListByDepartmentId(departmentId,paginator);
        modelMap.addAttribute("userVOs", userVOs);
        return new ModelAndView(RETURN_LIST_PAGE,modelMap);
    }
    private ModelAndView queryAll(ModelMap modelMap,String returnPage) {
        List<UserVO> userVOs;
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        paginator.setPage(1);
        userVOs = userService.getUserList(paginator);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("userVOs", userVOs);
        return new ModelAndView(returnPage, modelMap);
    }

    @RequestMapping("/user/add")
    public ModelAndView add(@Valid UserVO userVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        userVO.setCreateBy(getUser(session));
        userVO.setModifiedBy(getUser(session));
        userService.addUser(userVO);
        modelMap.addAttribute(MESSAGE, "新增用户信息成功!");
        return queryAll(modelMap,RETURN_LIST_PAGE);
    }

    @RequestMapping("/user/update")
    public ModelAndView update(@Valid UserVO userVO, BindingResult result, ModelMap modelMap, HttpSession session) {
        //单独校验id
        if (StringUtils.isBlank(userVO.getLoginName())) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少用户登录名!");
        }
        //校验没有通过,返回错误结果
        if (result.hasErrors()) {
            return new ModelAndView(RETURN_PAGE, ERROR, getError(result));
        }
        userVO.setModifiedBy(getUser(session));
        userService.updateUser(userVO);
        userVO = userService.getUserByLoginName(userVO.getLoginName());
        modelMap.addAttribute("userVO", userVO);
        modelMap.addAttribute(MESSAGE, "更新用户信息成功!");
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

    @RequestMapping(value = "/user/showDetail")
    public ModelAndView detail(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少用户id!");
        }
        UserVO userVO;
        userVO = userService.getUserByLoginName(loginName);
        return new ModelAndView(RETURN_PAGE, "userVO", userVO);
    }

    @RequestMapping(value = "/user/delete")
    public ModelAndView delete(String id, HttpSession session) {
        if (StringUtils.isBlank(id)) {
            return new ModelAndView(RETURN_PAGE, ERROR, "缺少用户id!");
        }
        userService.deleteUser(id, getUser(session));
        return new ModelAndView(RETURN_PAGE);
    }

    @RequestMapping("/user/query")
    public ModelAndView query(UserVO userVO, Integer page, ModelMap modelMap) {
        if (userVO==null) {
            return new ModelAndView(RETURN_PAGE, ERROR, "至少选择一个查询条件!");
        }
        String loginName=userVO.getLoginName();
        String userName=userVO.getUserName();
        List<UserVO> userVOs = new ArrayList<UserVO>();
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        if (StringUtils.isNotBlank(loginName)) {
            UserVO queryUserVO = userService.getUserByLoginName(loginName);
            paginator.setPage(1);
            paginator.setItems(1);
            userVOs.add(queryUserVO);
        }else{
            if (page == null) {
                paginator.setPage(1);
            } else {
                paginator.setPage(page);
            }
            userVOs=userService.getUserByUserName(userName,paginator);
        }
        modelMap.addAttribute("userVO", userVO);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("userVOs", userVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);

    }
}
