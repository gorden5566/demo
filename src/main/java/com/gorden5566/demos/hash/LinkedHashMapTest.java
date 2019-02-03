package com.gorden5566.demos.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gorden5566
 * @date 2019/1/24
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "value" + i);
        }

        // 使用 LinkedHashMap，默认取数据顺序与存数据顺序一致
        // 普通的 HashMap 不保证取数据的顺序
        // LinkedHashMap 在 HashMap 的基础上增加了双向链表，用于记录节点的顺序
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)iterator.next();
            System.out.println(String.format("key: %s, value: %s", entry.getKey(), entry.getValue()));
        }
    }
}
