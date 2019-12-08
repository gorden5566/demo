package com.gorden5566.framework.netty;

import java.lang.reflect.Field;

/**
 * @author gorden5566
 * @date 2019/10/19
 */
public class DirectMemoryLimit {
    public static void main(String[] args) throws Exception {

        Long directMemoryLimit = getDirectMemoryLimit();

        System.out.println(directMemoryLimit);
    }

    private static Long getDirectMemoryLimit() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = Class.forName("io.netty.util.internal.PlatformDependent");
        if (clazz == null) {
            return null;
        }

        Field directMemoryLimit = clazz.getDeclaredField("DIRECT_MEMORY_LIMIT");
        if (directMemoryLimit == null) {
            return null;
        }

        directMemoryLimit.setAccessible(true);

        return directMemoryLimit.getLong(clazz);
    }
}
