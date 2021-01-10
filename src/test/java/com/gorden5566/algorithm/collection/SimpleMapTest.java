package com.gorden5566.algorithm.collection;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gorden5566
 * @date 2021/01/10
 */
public class SimpleMapTest {

    @Test
    public void test1() {
        Map<String, String> map = new SimpleMap<>();
        map.put("a", "a");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("a", map.get("a"));

        map.put("b", "b");
        Assert.assertEquals(2, map.size());
        Assert.assertEquals("b", map.get("b"));

        map.put("a", "x");
        Assert.assertEquals(2, map.size());
        Assert.assertEquals( "x", map.get("a"));
    }
}