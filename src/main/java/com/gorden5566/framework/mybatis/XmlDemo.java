package com.gorden5566.framework.mybatis;

import com.gorden5566.framework.mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class XmlDemo {
    public static void main(String[] args) throws IOException {
        testCache();

    }

    /**
     * mybatis一级缓存测试
     */
    public static void testCache() {
        // 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 开启session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 添加dao配置
        sqlSession.getConfiguration().addMapper(UserDao.class);

        // 执行两次查询，输出一条sql和两次的查询结果
        System.out.println(sqlSession.getMapper(UserDao.class).query());
        System.out.println(sqlSession.getMapper(UserDao.class).query());

        System.out.println();
    }
}
