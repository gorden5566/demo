package com.gorden5566.learn.pattern.flyweight.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019-02-13
 */
public class SignInfoFactory {

    private static Map<String, SignInfo> pool = new HashMap<>();

    /**
     * 报名信息的对象工厂
     *
     * @return
     */
    @Deprecated
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    /**
     * 从池中获得对象
     *
     * @param key 考试科目+考试地点
     * @return
     */
    public static SignInfo getSignInfo(String key) {
        SignInfo result = null;
        if (!pool.containsKey(key)) {
            System.out.println(key + "----建立对象，并放置到池中");
            result = new SignInfo4Pool(key);
            pool.put(key, result);
        } else {
            result = pool.get(key);
            System.out.println(key + "---直接从池中取得");
        }
        return result;
    }
}
