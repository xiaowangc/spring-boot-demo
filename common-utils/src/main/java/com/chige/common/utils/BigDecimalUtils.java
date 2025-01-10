package com.chige.common.utils;

import java.math.BigDecimal;


public class BigDecimalUtils {

    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        return v1.add(null == v2? new BigDecimal(0): v2);
    }

    public static BigDecimal add(double v1, double v2) {
        return add(new BigDecimal(v1), new BigDecimal(v2));
    }

    public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
        return v1.subtract(null == v2? new BigDecimal(0): v2);
    }

    public static BigDecimal sub(double v1, double v2) {
        return sub(new BigDecimal(v1), new BigDecimal(v2));
    }

    public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
        return v1.multiply(null == v2? new BigDecimal(0): v2);
    }

    public static BigDecimal mul(double v1, double v2) {
        return mul(new BigDecimal(v1), new BigDecimal(v2));
    }

    public static BigDecimal div(double v1, double v2) {
        return div(new BigDecimal(v1), new BigDecimal(v2));
    }

    public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
        return v1.divide(v2, 2, BigDecimal.ROUND_HALF_UP);
    }
}