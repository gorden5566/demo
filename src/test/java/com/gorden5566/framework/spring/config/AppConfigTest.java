package com.gorden5566.framework.spring.config;

import com.gorden5566.framework.mybatis.dao.UserDao;
import com.gorden5566.framework.spring.DefaultConfig;

/**
 * spring和mybatis整合
 *
 * @author gorden5566
 * @date 2019/1/17
 */
public class AppConfigTest extends DefaultConfig {

    public static void main(String[] args) {
        // 查询两次，打印两次sql语句+两次查询结果，说明mybatis一级缓存(session级别)已经关闭，每次查询创建新的session
        System.out.println(context.getBean(UserDao.class).query());
        System.out.println(context.getBean(UserDao.class).query());
    }

}