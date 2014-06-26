/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.wycds.demoapp.biz.UserService;
import com.wangyin.wycds.demoapp.controller.form.UserQueryForm;
import com.wangyin.wycds.demoapp.controller.vo.UserVO;
import com.wangyin.wycds.demoapp.util.Paginator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户综合查询页面控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/23 13:50 Exp $$
 */
@Controller
public class UserQueryController extends BaseController{
    /**
     * 返回页面
     */
    private static final String RETURN_PAGE = "module/user_query";

    @Autowired
    UserService userService;
    @RequestMapping("/userQuery/show")
    public ModelAndView doGet(ModelMap modelMap){
        return new ModelAndView(RETURN_PAGE,modelMap);
    }
    @RequestMapping("/userQuery/query")
    public ModelAndView doQuery(UserQueryForm userQueryForm,Integer page,ModelMap modelMap){
        List<UserVO> userVOs=new ArrayList<UserVO>();
        if(StringUtils.isNotBlank(userQueryForm.getLoginName())){
            UserVO userVO;
            userVO = userService.getUserByLoginName(userQueryForm.getLoginName());
            userVOs.add(userVO);
            modelMap.addAttribute("userVOs", userVOs);
            return new ModelAndView(RETURN_PAGE,modelMap);
        }
        Paginator paginator = new Paginator();
        paginator.setItemsPerPage(PAGE_SIZE);
        if (page == null) {
            paginator.setPage(1);
        } else {
            paginator.setPage(page);
        }
        userVOs = userService.getUserListByParameter(userQueryForm,paginator);
        modelMap.addAttribute("userVOs", userVOs);
        return new ModelAndView(RETURN_PAGE,modelMap);
    }
}
