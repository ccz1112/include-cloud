package com.include.comm.util;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: chenshuo
 * @Date: 2022-08-08
 * @Time: 10:50
 * @version： 1.0
 * @Description:
 **/
public class FieldCommUtils {

    private static String eqKey = "eq";
    private static String neKey = "ne";
    private static String orderByDescKey = "orderByDesc";
    private static String lastKey = "last";
    private static String selectKey = "select";
    private static String inKey = "in";
    //用于判断是否为不定长参数
    private static final String[] con = new String[]{};
    //存放方法Key,与对应的json数据
    private static Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    //对应mybatis-plus中参数的类型
    public static Map<String, Class[]> classMap = new HashMap<>();

    static {
        //记录mybatis对应方法及参数 Key:方法名 val:参数类型
        classMap.put(eqKey, new Class[]{Object.class, Object.class});
        classMap.put(neKey, new Class[]{Object.class, Object.class});
        classMap.put(orderByDescKey, new Class[]{Object.class});
        classMap.put(lastKey, new Class[]{String.class});
        classMap.put(selectKey, new Class[]{String[].class});//适用于不定长String参数
        classMap.put(inKey, new Class[]{Object.class, Object[].class});
    }


    public static Map<String, String> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public static void select(String... args) {
        concurrentHashMap.put(selectKey, String.join(",", args));
    }

    public static void eq(String key, Object val) {
        Map map = new HashMap();
        map.put(key, val);
        if (concurrentHashMap.containsKey(eqKey)) {
            String str = concurrentHashMap.get(eqKey);
            Map map1 = JSON.parseObject(str, Map.class);
            map1.put(key, val);
            concurrentHashMap.put(eqKey, JSON.toJSONString(map1));
        } else {
            concurrentHashMap.put(eqKey, JSON.toJSONString(map));
        }
    }


    public static void ne(String key, Object val) {
        Map map = new HashMap();
        map.put(key, val);
        if (concurrentHashMap.containsKey(neKey)) {
            String str = concurrentHashMap.get(neKey);
            Map map1 = JSON.parseObject(str, Map.class);
            map1.put(key, val);
            concurrentHashMap.put(neKey, JSON.toJSONString(map1));
        } else {
            concurrentHashMap.put(neKey, JSON.toJSONString(map));
        }

    }

    public static void in(String key, Object... val) {
        Map map = new HashMap();
        String buff = "";
        for (int i = 0; i < val.length; i++) {
            buff = buff + val[i] + ",";
        }
        map.put(key, buff.substring(0, buff.length() - 1));
        if (concurrentHashMap.containsKey(inKey)) {
            String str = concurrentHashMap.get(inKey);
            Map map1 = JSON.parseObject(str, Map.class);
            map1.put(key, buff.substring(0, buff.length() - 1));
            concurrentHashMap.put(inKey, JSON.toJSONString(map1));
        } else {
            concurrentHashMap.put(inKey, JSON.toJSONString(map));
        }

    }

    public static void orderByDesc(String fieId) {
        concurrentHashMap.put(orderByDescKey, fieId);
    }

    public static void last(String sql) {
        concurrentHashMap.put(lastKey, sql);
    }

    public static QueryWrapper getQueryWrapper(String str) throws Exception {
        //key可以为表名,灵活配置
        Map<String, String> fieMap = JSON.parseObject(str, Map.class);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        Class clazz = QueryWrapper.class;
        try {
            for (Map.Entry<String, String> a : fieMap.entrySet()) {
                String key = a.getKey();
                //根据配置的参数长度
                Class[] classes = classMap.get(key);
                Method method = clazz.getMethod(key, classes);
                String val = a.getValue();
                //针对不定长参数特殊处理
                Class[] paramTypes = method.getParameterTypes();


                int count = method.getParameterCount();

                if (count > 1) {
                    Map<Object, Object> map = JSON.parseObject(val, Map.class);
                    boolean isArray = paramTypes[1].isArray();
                    if (isArray) {
                        for (Map.Entry<Object, Object> keyMap : map.entrySet()) {
                            String[] asd = new String[]{};
                            Object value = keyMap.getValue();
                            asd = String.valueOf(value).split(",");
                            queryWrapper = (QueryWrapper) method.invoke(queryWrapper, keyMap.getKey(), asd);
                        }
                    } else {
                        for (Map.Entry<Object, Object> keyMap : map.entrySet()) {
                            queryWrapper = (QueryWrapper) method.invoke(queryWrapper, keyMap.getKey(), keyMap.getValue());
                        }
                    }
                } else {

                    if (con.getClass().getTypeName().equals(paramTypes[0].getTypeName())) {
                        Object[] asd = new Object[1];
                        asd[0] = val.split(",");
                        queryWrapper = (QueryWrapper) method.invoke(queryWrapper, asd);
                    } else {
                        queryWrapper = (QueryWrapper) method.invoke(queryWrapper, val);
                    }
                }
            }
            return queryWrapper;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new NoSuchMethodException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalAccessException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }


    public static void clear() {
        concurrentHashMap = new ConcurrentHashMap();
    }

}