/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.controller;

import com.wangyin.ssoclient.sso.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpSession;

/**
 * 基础控制类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 14:58 Exp $$
 */
public class BaseController {

    /**
     * 默认页大小：20
     */
    protected static final int PAGE_SIZE = 20;

    /**
     * 默认页面提示语key
     */
    protected static final String MESSAGE = "message";

    /**
     * 默认页面提示语key
     */
    protected static final String ERROR = "error";

    /**
     * 默认错误展现页面
     */
    protected static final String defaultErrorTarget = "error.vm";

    /**
     * 解析validate校验的结果,把错误信息进行封装
     *
     * @param result
     * @return
     */
    protected String getError(BindingResult result) {
        if (result == null || result.getErrorCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : result.getAllErrors()) {
            sb.append(objectError.getDefaultMessage()).append("<br/>");
        }
        return sb.toString();
    }

    /**
     * 获取目前系统登录用户,以后从session中获取,现阶段写死
     *
     * @return
     */
    protected String getUser(HttpSession session) {
//        User user = (User) session.getAttribute(com.wangyin.ssoclient.sso.model.Configuration.userSession);
//        return user.getUsername();
        return "admin";
    }
}
