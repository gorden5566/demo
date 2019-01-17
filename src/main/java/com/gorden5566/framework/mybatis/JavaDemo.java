package com.gorden5566.framework.mybatis;

import com.gorden5566.framework.mybatis.dao.UserDao;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public class JavaDemo {

    public static void main(String[] args) {
        // DataSource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("yhd90()");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/demos?useUnicode=true&charterEncoding=utf8&useSSL=false");

        // mybatis配置
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserDao.class);

        // 获取session
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        System.out.println(sqlSession.getMapper(UserDao.class).query());
        System.out.println(sqlSession.getMapper(UserDao.class).query());

    }
}
