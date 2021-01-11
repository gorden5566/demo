package com.gorden5566.algorithm.collection;

import com.gorden5566.algorithm.collection.map.Map;
import com.gorden5566.algorithm.collection.map.SimpleMap;
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

    @Test
    public void test2() {
        Map<String, String> map = new SimpleMap<>();
        map.put("a", "a");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("a", map.get("a"));

        String a = map.remove("a");
        Assert.assertEquals("a", a);
        Assert.assertEquals(0, map.size());

        map.put("a", "a");
        map.put("b", "b");
        map.put("a", "x");
        Assert.assertEquals(2, map.size());
        String x = map.remove("a");
        Assert.assertEquals("x", x);
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void test3() {
        Map<String, String> map = new SimpleMap<>();
        map.put("a", "a");
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(true, map.containsKey("a"));

        map.remove("a");
        Assert.assertEquals(false, map.containsKey("a"));
        Assert.assertEquals(0, map.size());
    }
}