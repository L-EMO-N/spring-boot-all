package com.lemon.weixin.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2018/3/16
 */
public class HashMapAndHashTable {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
    }


    @Test
    public void demo1(){
        Map<String,Object> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.size());

    }

    @Test
    public  void demo2(){
            Map<String,Object> map = new Hashtable<>();
            map.put(null,"1");
        System.out.println(map.size());
    }
}
