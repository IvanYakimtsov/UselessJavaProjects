package com.ivan.calculator.calculatorData;

import com.ivan.calculator.CalculationException;

import  java.util.HashMap;
/**
 * Created by Ivan on 08.05.2017.
 */
public class FactorialUtil
{
    static HashMap<Integer,Double> cache = new HashMap<Integer,Double>();

    public static Double factorial(Integer n) throws CalculationException
    {
        Double ret;
        if(n>170) throw new CalculationException("переполнение");
        if (n == 0) return 1.0;
        if (null != (ret = cache.get(n))) return ret;
        ret = n*factorial(n-1);
        cache.put(n, ret);
        return ret;
    }
}
