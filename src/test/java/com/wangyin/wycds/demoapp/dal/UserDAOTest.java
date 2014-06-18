/**
 * Wangyin.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */
package com.wangyin.wycds.demoapp.dal;

import com.wangyin.wycds.demoapp.dal.dataobject.UserDO;
import org.apache.ibatis.io.Resources;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 蒋鲁宾
 * @version v 0.1 2014/6/18 14:26 Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDAOTest {

    @Test
    public void queryUser() throws Exception{
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sf.openSession();

        UserDO u = session.selectOne("com.wangyin.wycds.demoapp.dal.dataobject.UserDO.getUser","admin");

        System.out.println(u.getLoginPassword());

    }
}
