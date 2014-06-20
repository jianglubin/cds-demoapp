/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * json格式工具类
 *
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/20 12:26 Exp $$
 */
public class JsonUtil {
    /**
     * 普通日志记录器
     */
    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    /**
     * json mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String list2Json(List<?> list){
        try {
            System.out.println("ObjectMapper");
            //writeValue具有和writeObject相同的功能
            objectMapper.writeValue(System.out, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
