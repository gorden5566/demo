package com.gorden5566.framework.hbase;

import com.gorden5566.framework.hbase.codec.JsonSerializer;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class SerializerFactory {

    private static Serializer serializer = new JsonSerializer();

    public static Serializer getDefaultSerializer() {
        return serializer;
    }

}
