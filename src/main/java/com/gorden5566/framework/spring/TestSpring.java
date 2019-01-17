package com.gorden5566.framework.spring;

import com.gorden5566.framework.mybatis.dao.UserDao;
import com.gorden5566.framework.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class TestSpring {
    private static AnnotationConfigApplicationContext context;
    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean(AppConfig.class));

        // 数据库查询
        testQuery();

    }

    /**
     * 查询两次，打印两次sql语句+两次查询结果，说明mybatis一级缓存(session级别)已经关闭，每次查询创建新的session
     */
    private static void testQuery() {
        System.out.println(context.getBean(UserDao.class).query());
        System.out.println(context.getBean(UserDao.class).query());
    }
}
