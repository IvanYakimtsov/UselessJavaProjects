package com.ivan.calculator.calculatorData;

import  java.util.HashMap;
/**
 * Created by Ivan on 08.05.2017.
 */
public class FactorialUtil
{
    static HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();

    public static Integer factorial(int n)
    {
        Integer ret;

        if (n == 0) return 1;
        if (null != (ret = cache.get(n))) return ret;
        ret = n*factorial(n-1);
        cache.put(n, ret);
        return ret;
    }
}
