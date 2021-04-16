package com.example.myapp.util;

/**
 * @author 25798
 * 公共方法
 */
public class StringUtils {
    public static Boolean isEmpty(String str) {
        if(str == null || str.length() <= 0) {
            return true;
        }else {
            return false;
        }
    }
}
