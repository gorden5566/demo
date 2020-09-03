package com.gorden5566.framework.hbase.codec;

import com.alibaba.fastjson.JSON;
import com.gorden5566.framework.hbase.Serializer;
import org.apache.hadoop.hbase.util.Bytes;

import java.lang.reflect.Type;

/**
 * @author gorden5566
 * @date 2020/09/04
 */
public class JsonSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) {
        return Bytes.toBytes(JSON.toJSONString(object));
    }

    @Override
    public Object deserialize(byte[] bytes, Type clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
