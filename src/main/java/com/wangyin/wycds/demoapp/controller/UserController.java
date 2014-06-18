/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.UserService;
import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 13:46 Exp $$
 */
@Controller
public class UserController extends BaseController{

    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "configuration/appInfoManage";

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/app/show")
    public ModelAndView doGet(ModelMap modelMap) {
        return queryAll(modelMap);
    }

    private ModelAndView queryAll(ModelMap modelMap) {
        List<UserVO> userVOs;
        Paginator paginator = new Paginator();
        if (userService.getUserListCount()== null) {
            return new ModelAndView(RETURN_PAGE, ERROR, "查询数据出错!");
        }
        paginator.setItems(userService.getUserListCount());
        paginator.setItemsPerPage(PAGE_SIZE);
        paginator.setPage(1);
        userVOs = userService.getUserList(paginator);
        modelMap.addAttribute("paginator", paginator);
        modelMap.addAttribute("userVOs", userVOs);
        return new ModelAndView(RETURN_PAGE, modelMap);
    }

}
