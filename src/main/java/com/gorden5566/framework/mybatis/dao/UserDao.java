package com.gorden5566.framework.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
public interface UserDao {

    @Select("select * from user")
    List<Map<Integer, String>> query();
}
