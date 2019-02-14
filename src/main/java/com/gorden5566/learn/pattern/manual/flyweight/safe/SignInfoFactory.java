package com.gorden5566.learn.pattern.manual.flyweight.safe;

import com.gorden5566.learn.pattern.manual.flyweight.simple.SignInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class SignInfoFactory {
    /**
     * 池容器
     */
    private static Map<String, SignInfo> pool = new HashMap<>();

    /**
     * 从池中获得对象
     * @param key 考试科目
     * @return
     */
    public static SignInfo getSignInfo(String key) {
        //设置返回对象
        SignInfo result = null;
        //池中没有该对象，则建立，并放入池中
        if (!pool.containsKey(key)) {
            result = new SignInfo();
            pool.put(key, result);
        } else {
            result = pool.get(key);
        }
        return result;
    }
}
