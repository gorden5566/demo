package com.gorden5566.framework.hbase;

import java.lang.reflect.Type;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public interface Serializer {
    /**
     * convert to bytes
     *
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * parse from bytes
     *
     * @param bytes input bytes
     * @param clazz target class
     * @return
     */
    Object deserialize(byte[] bytes, Type clazz);
}
