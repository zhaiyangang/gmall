package com.atguigu.gmall.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @Auther ZYG
 * @Date 2022/9/14
 */
public class Jsons {
    private static ObjectMapper mapper = new ObjectMapper();
    /**
     * 把对象转成json字符串
     * @param object
     * @return
     */
    public static String toStr(Object object) {

        try {
            String s = mapper.writeValueAsString(object);
            return s;
        } catch (JsonProcessingException e) {
            return null;
        }

    }
}
