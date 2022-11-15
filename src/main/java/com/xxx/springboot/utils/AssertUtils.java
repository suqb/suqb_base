package com.xxx.springboot.utils;


import com.xxx.springboot.exceptions.ParamsExceptions;

public class AssertUtils {

    public static void isTrue(Boolean flag, String msg) {
        if (flag) {
            throw new ParamsExceptions(msg);
        }
    }
}
